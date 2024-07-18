package com.stephen.scraper.Pojo;

import java.util.ArrayList;

public class Cpedi {

	public int id;
	public String name;
	public String venue_country;
	public ArrayList<MeetingClass> meeting_classes;

	public Cpedi() {
	}

	public Cpedi(int id, String name, String venue_country, ArrayList<MeetingClass> meeting_classes) {
		super();
		this.id = id;
		this.name = name;
		this.venue_country = venue_country;
		this.meeting_classes = meeting_classes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVenue_country() {
		return venue_country;
	}

	public void setVenue_country(String venue_country) {
		this.venue_country = venue_country;
	}

	public ArrayList<MeetingClass> getMeetingClasses() {
		return meeting_classes;
	}

	public void setMeetingClasses(ArrayList<MeetingClass> meeting_classes) {
		this.meeting_classes = meeting_classes;
	}

}
