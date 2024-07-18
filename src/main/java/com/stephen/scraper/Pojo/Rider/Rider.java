package com.stephen.scraper.Pojo.Rider;

import java.util.ArrayList;

public class Rider {
	
	public int id;
	public int meeting_class_id;
	public int total;
	public ArrayList<Start> starts;

	public Rider() {
		super();
	}

	public Rider(int id, int meeting_class_id, int total, ArrayList<Start> starts) {
		super();
		this.id = id;
		this.meeting_class_id = meeting_class_id;
		this.total = total;
		this.starts = starts;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public ArrayList<Start> getStarts() {
		return starts;
	}

	public void setStarts(ArrayList<Start> starts) {
		this.starts = starts;
	}

}
