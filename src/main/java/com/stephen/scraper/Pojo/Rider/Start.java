package com.stephen.scraper.Pojo.Rider;

import java.util.ArrayList;

public class Start {
	public int rank;
	public String prize;
	public String result_preview;
	public String rider_name;
	public String horse_name;
	public String logo_id;
	public ArrayList<Result> results;

	public Start() {
		super();
	}

	public Start(int rank, String prize, String result_preview, String rider_name, String horse_name, String logo_id,
			ArrayList<Result> results) {
		super();
		this.rank = rank;
		this.prize = prize;
		this.result_preview = result_preview;
		this.rider_name = rider_name;
		this.horse_name = horse_name;
		this.logo_id = logo_id;
		this.results = results;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public String getResult_preview() {
		return result_preview;
	}

	public void setResult_preview(String result_preview) {
		this.result_preview = result_preview;
	}

	public String getRider_name() {
		return rider_name;
	}

	public void setRider_name(String rider_name) {
		this.rider_name = rider_name;
	}

	public String getHorse_name() {
		return horse_name;
	}

	public void setHorse_name(String horse_name) {
		this.horse_name = horse_name;
	}

	public String getLogo_id() {
		return logo_id;
	}

	public void setLogo_id(String logo_id) {
		this.logo_id = logo_id;
	}

	public ArrayList<Result> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result> results) {
		this.results = results;
	}

}
