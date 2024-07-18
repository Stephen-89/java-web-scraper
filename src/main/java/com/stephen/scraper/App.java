package com.stephen.scraper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;

import com.stephen.scraper.Pojo.ClassSection;
import com.stephen.scraper.Pojo.Cpedi;
import com.stephen.scraper.Pojo.MeetingClass;
import com.stephen.scraper.Pojo.Rider.Rider;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

/**
 * Our scraper class
 */
public class App {

	private static int COUNT_FILE = 1;
	private static int COUNT_IMAGE = 1;
	private static String NEW_FILE = "results/results-%d.html";
	private static String DATE = "";

	public static void main(String[] args) throws ParseException {
		try {
			Cpedi cpedi = extractCpedi();
			if (cpedi != null &&  (cpedi.getMeetingClasses() != null)) {
					extractMeetingClasses(cpedi);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Cpedi extractCpedi() throws IOException {
		String json = Jsoup.connect("https://online.equipe.com/api/v1/meetings/61647/schedule").ignoreContentType(true)
				.execute().body();
		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);
		return objectMapper.readValue(json, Cpedi.class);
	}

	private static void extractMeetingClasses(Cpedi cpedi) throws ParseException {
		for (MeetingClass meetingClass : cpedi.getMeetingClasses()) {
			if (meetingClass.getClassSections() != null &&  (meetingClass.getName() != null)) {
					extractClassSections(meetingClass);
				
			}
		}
	}

	private static void extractClassSections(MeetingClass meetingClass) throws ParseException {
		for (ClassSection classSection : meetingClass.getClassSections()) {
			System.out.println(String.format("Round: %s", meetingClass.getName()));
			try {
				String jsonResults = Jsoup.connect(String
						.format("https://online.equipe.com/api/v1/class_sections/%d", classSection.getId()))
						.ignoreContentType(true).execute().body();
				ObjectMapper objectMapperResults = new ObjectMapper()
						.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				Rider rider = objectMapperResults.readValue(jsonResults, Rider.class);
				extractRider(meetingClass, rider);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void extractRider(MeetingClass meetingClass, Rider rider) throws IOException, ParseException {
		if (rider.getStarts().get(0).getResults() != null) {
			
			DATE = DateUtils.formatDate(meetingClass.getStart_at());
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date dateFrom = dateFormat.parse("05-07-2024");
			Date dateTo = dateFormat.parse(DATE);
			
			//if(dateTo.compareTo(dateFrom) == 0) {
				String htmlString = GenetateHtml.generateHtml(meetingClass, rider);
				NEW_FILE = String.format("results/html/results-%d.html", COUNT_FILE);
				COUNT_FILE += 1;
				try (PrintWriter out = new PrintWriter(NEW_FILE)) {
					out.println(htmlString);
				}
				generateImage();	
			//}
			
		}
	}

	public static void generateImage() {

		// Set the path to the chromedriver executable
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

		// Set Chrome options to run in headless mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless").addArguments("--remote-allow-origins=*");

		// Initialize the WebDriver
		WebDriver driver = new ChromeDriver(options);

		try {

			// Replace with the path to your local HTML file
			File localHtmlPath = new File(NEW_FILE);

			driver.get("file:///" + localHtmlPath.getAbsolutePath());

			// Take a screenshot
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// Save the screenshot to a file
			File destinationFile = new File(String.format(Constants.NEW_SCREENSHOT, DATE, COUNT_IMAGE));
			FileHandler.copy(screenshot, destinationFile);
			
			CropImage.cropImage(COUNT_IMAGE, DATE);
			
			COUNT_IMAGE += 1;

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
