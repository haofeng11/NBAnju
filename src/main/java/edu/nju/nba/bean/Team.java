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
@Table(name = "team_base_info")
public class Team implements Serializable {

	private static final long serialVersionUID = 1L;

	private String teamID;
	// 球队中文名称
	private String cName;
	// 英文名
	private String eName;
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
	// 总冠军次数
	private String champion;
	// 最高连胜纪录
	private String topWinningStreak;
	// 球队图片地址
	private String picture;

	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Team(String teamID, String cName, String eName, String teamDistrict,
			String foundedTime, String teamLocation, String mainStadium,
			String boss, String coach, String teamStar, String champion,
			String topWinningStreak, String picture) {
		super();
		this.teamID = teamID;
		this.cName = cName;
		this.eName = eName;
		this.teamDistrict = teamDistrict;
		this.foundedTime = foundedTime;
		this.teamLocation = teamLocation;
		this.mainStadium = mainStadium;
		this.boss = boss;
		this.coach = coach;
		this.teamStar = teamStar;
		this.champion = champion;
		this.topWinningStreak = topWinningStreak;
		this.picture = picture;
	}

	@Id
	@GeneratedValue
	public String getTeamID() {
		return teamID;
	}

	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
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

	public String getChampion() {
		return champion;
	}

	public void setChampion(String champion) {
		this.champion = champion;
	}

	public String getTopWinningStreak() {
		return topWinningStreak;
	}

	public void setTopWinningStreak(String topWinningStreak) {
		this.topWinningStreak = topWinningStreak;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		return cName + " : " + teamDistrict + " : " + teamLocation;
	}

}
