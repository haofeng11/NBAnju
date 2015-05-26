package edu.nju.nba.bean;


public class TeamGameRecordVO {
	private TeamGameRecord record;
	private String bName;
	public TeamGameRecordVO(TeamGameRecord record, String bName) {
		super();
		this.record = record;
		this.bName = bName;
	}
	public TeamGameRecord getRecord() {
		return record;
	}
	public void setRecord(TeamGameRecord record) {
		this.record = record;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}

}
