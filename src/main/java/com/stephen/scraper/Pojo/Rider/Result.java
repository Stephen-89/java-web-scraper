package com.stephen.scraper.Pojo.Rider;

public class Result {
	
	public String judge_by;
	public String percent;

	public Result() {
		super();
	}

	public Result(String judge_by, String percent) {
		super();
		this.judge_by = judge_by;
		this.percent = percent;
	}

	public String getJudge_by() {
		return judge_by;
	}

	public void setJudge_by(String judge_by) {
		this.judge_by = judge_by;
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

}
