package edu.nju.nba.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player_career_high")
public class PlayerCareerHigh implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ID
	private String ID;
	// 球员姓名
	private String playerName;
	// 球员生涯之最数据
	private String careerHighData;
	// 获得生涯之最数据时的年份
	private String year;
	// 辅助数据
	private int yAxis;
	
	public PlayerCareerHigh() {
		super();
	}

	public PlayerCareerHigh(String iD, String playerName,
			String careerHighData, String year, int yAxis) {
		super();
		ID = iD;
		this.playerName = playerName;
		this.careerHighData = careerHighData;
		this.year = year;
		this.yAxis = yAxis;
	}

	@Id
	@GeneratedValue
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getCareerHighData() {
		return careerHighData;
	}

	public void setCareerHighData(String careerHighData) {
		this.careerHighData = careerHighData;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getyAxis() {
		return yAxis;
	}

	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}
	
	public String toString() {
		return "name: "+playerName+" data: "+careerHighData+" year: "+year;
	}

}
