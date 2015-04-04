package edu.nju.nba.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @className Team
 * @description 球队信息类
 * @author 作者 : fenghao
 * @date 创建时间：2015年3月31日 上午9:56:23
 */

@Entity
@Table
public class Team implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer teamID;
	// 球队名称
	private String teamName;
	// 区域
	private String teamDistrict;
	// 成立时间
	private String foundedTime;
	// 所在地
	private String teamLocation;
	// 主场馆
	private String mainStadium;
	// 球队老板
	private String boss;
	// 现任教练
	private String coach;
	// 历任球星
	private String teamStar;
	// 季后赛次数
	private int numOfPlayoff;
	// 分区冠军次数
	private int divisionCrown;
	// 总冠军次数
	private int champion;
	// 最高连胜纪录
	private int topWinningStreak;
	// 最好战绩
	private String bestRecord;
	
	

	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Team(Integer teamID, String teamName, String teamDistrict,
			String foundedTime, String teamLocation, String mainStadium,
			String boss, String coach, String teamStar,
			int numOfPlayoff, int divisionCrown, int champion,
			int topWinningStreak, String bestRecord) {
		super();
		this.teamID = teamID;
		this.teamName = teamName;
		this.teamDistrict = teamDistrict;
		this.foundedTime = foundedTime;
		this.teamLocation = teamLocation;
		this.mainStadium = mainStadium;
		this.boss = boss;
		this.coach = coach;
		this.teamStar = teamStar;
		this.numOfPlayoff = numOfPlayoff;
		this.divisionCrown = divisionCrown;
		this.champion = champion;
		this.topWinningStreak = topWinningStreak;
		this.bestRecord = bestRecord;
	}



	@Id
	@GeneratedValue
	public Integer getTeamID() {
		return teamID;
	}

	public void setTeamID(Integer teamID) {
		this.teamID = teamID;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String name) {
		this.teamName = name;
	}

	public String getTeamDistrict() {
		return teamDistrict;
	}

	public void setTeamDistrict(String teamDistrict) {
		this.teamDistrict = teamDistrict;
	}

	public String getFoundedTime() {
		return foundedTime;
	}

	public void setFoundedTime(String foundedTime) {
		this.foundedTime = foundedTime;
	}

	public String getTeamLocation() {
		return teamLocation;
	}

	public void setTeamLocation(String teamLocation) {
		this.teamLocation = teamLocation;
	}

	public String getMainStadium() {
		return mainStadium;
	}

	public void setMainStadium(String mainStadium) {
		this.mainStadium = mainStadium;
	}

	public String getBoss() {
		return boss;
	}

	public void setBoss(String boss) {
		this.boss = boss;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public String getTeamStar() {
		return teamStar;
	}

	public void setTeamStar(String teamStar) {
		this.teamStar = teamStar;
	}

	public int getNumOfPlayoff() {
		return numOfPlayoff;
	}

	public void setNumOfPlayoff(int numOfPlayoff) {
		this.numOfPlayoff = numOfPlayoff;
	}

	public int getDivisionCrown() {
		return divisionCrown;
	}

	public void setDivisionCrown(int divisionCrown) {
		this.divisionCrown = divisionCrown;
	}

	public int getChampion() {
		return champion;
	}

	public void setChampion(int champion) {
		this.champion = champion;
	}

	public int getTopWinningStreak() {
		return topWinningStreak;
	}

	public void setTopWinningStreak(int topWinningStreak) {
		this.topWinningStreak = topWinningStreak;
	}

	public String getBestRecord() {
		return bestRecord;
	}

	public void setBestRecord(String bestRecord) {
		this.bestRecord = bestRecord;
	}
	
	public String toString() {
		return teamName + " : " + teamDistrict + " : " + teamLocation ;
	}

}
