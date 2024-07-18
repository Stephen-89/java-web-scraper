package com.stephen.scraper.Pojo;

import java.util.ArrayList;

public class MeetingClass {

	public int id;
	public String name;
	public String start_at;
	public ArrayList<ClassSection> class_sections;

	public MeetingClass() {
	}

	public MeetingClass(int id, String name, String start_at, ArrayList<ClassSection> class_sections) {
		super();
		this.id = id;
		this.name = name;
		this.start_at = start_at;
		this.class_sections = class_sections;
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

	public String getStart_at() {
		return start_at;
	}

	public void setStart_at(String start_at) {
		this.start_at = start_at;
	}

	public ArrayList<ClassSection> getClassSections() {
		return class_sections;
	}

	public void setClassSections(ArrayList<ClassSection> class_sections) {
		this.class_sections = class_sections;
	}

}
