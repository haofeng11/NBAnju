package edu.nju.nba.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player_greatest")
public class PlayerCareerHigh implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//id
	private int id;
	// 球员姓名
	private String player;
	// 球员生涯之最数据
	private String event;
	// 获得生涯之最数据时的年份
	private String year;
	// 辅助数据
	private int eventNum;
	
	public PlayerCareerHigh() {
		super();
	}
	
	public PlayerCareerHigh(String player, String event,
			String year, int eventNum) {
		this.player = player;
		this.event = event;
		this.year = year;
		this.eventNum = eventNum;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getEventNum() {
		return eventNum;
	}

	public void setEventNum(int eventNum) {
		this.eventNum = eventNum;
	}

	public String toString() {
		return "name: "+player+" event: "+event+" year: "+year;
	}

}
