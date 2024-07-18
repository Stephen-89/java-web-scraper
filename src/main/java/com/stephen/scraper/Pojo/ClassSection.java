package com.stephen.scraper.Pojo;

public class ClassSection {

	public int id;
	public int meeting_class_id;
	
	public ClassSection() {
	}

	public ClassSection(int id, int meeting_class_id) {
		super();
		this.id = id;
		this.meeting_class_id = meeting_class_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMeeting_class_id() {
		return meeting_class_id;
	}

	public void setMeeting_class_id(int meeting_class_id) {
		this.meeting_class_id = meeting_class_id;
	}

}
