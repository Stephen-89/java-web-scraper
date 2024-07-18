package com.stephen.scraper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.stephen.scraper.Pojo.MeetingClass;
import com.stephen.scraper.Pojo.Rider.Rider;
import com.stephen.scraper.Pojo.Rider.Start;

public class GenetateHtml {

	private static final String TD_OPEN = "<td>";
	private static final String TD_CLOSE = "</td>";

	@SuppressWarnings("deprecation")
	public static String generateHtml(MeetingClass meetingClass, Rider rider) throws IOException {
		
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("<tr><th>Position</th><th style='width:80%;'>Athlete</th><th>Score</th></tr>");

		int count = 0;
			
		for(Start start: rider.getStarts()) {

			//while(true) {

				stringBuilder.append("<tr>");
				stringBuilder.append(TD_OPEN + start.getRank() + TD_CLOSE);
				stringBuilder.append(TD_OPEN + start.getRider_name() + ", (" + start.getLogo_id() + ")" + TD_CLOSE);
//				for (int i = 0; i < 3; i++) {
//					stringBuilder.append("<td>" + start.getResults().get(i).getPercent() + "</td>");
//				}
				stringBuilder.append(TD_OPEN + start.getResult_preview() + TD_CLOSE);
				stringBuilder.append("</tr>");
				
				count++;
				if(count == 3) {
					break;
				}
				
			//}

		}
		
		File htmlTemplateFile = new File("results/template/template.html");
		String htmlString = FileUtils.readFileToString(htmlTemplateFile);
		
		htmlString = htmlString.replace("$name", meetingClass.getName());
		htmlString = htmlString.replace("$date", DateUtils.formatDate(meetingClass.getStart_at()));
		htmlString = htmlString.replace("$td", stringBuilder.toString());
		
		return htmlString;
		
	}

}
