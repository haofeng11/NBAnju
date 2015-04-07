package edu.nju.nba.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @className Game
 * @description 单场比赛类（比赛基础信息）
 * @author 作者: fenghao
 */

@Entity
@Table
public class Game implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String gameId;
	private String seasonId;
	// 比赛日期
	private String gameDate;
	// 主队名
	private String homeTeam;
	// 客队名
	private String guestTeam;
	// 主队总分
	private String homeScore;
	// 客队总分
	private String gueatScore;
	// 第一节
	private String firstHomeScore;
	private String firstGuestScore;
	// 第二节
	private String secondHomeScore;
	private String secondGuestScore;
	// 第三节
	private String thirdHomeScore;
	private String thirdGuestScore;
	// 第四节
	private String fourthHomeScore;
	private String fourthGuestScore;

	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Game(String gameId, String seasonId, String gameDate,
			String homeTeam, String guestTeam, String homeScore,
			String gueatScore, String firstHomeScore, String firstGuestScore,
			String secondHomeScore, String secondGuestScore,
			String thirdHomeScore, String thirdGuestScore,
			String forthHomeScore, String forthGuestScore) {
		super();
		this.gameId = gameId;
		this.seasonId = seasonId;
		this.gameDate = gameDate;
		this.homeTeam = homeTeam;
		this.guestTeam = guestTeam;
		this.homeScore = homeScore;
		this.gueatScore = gueatScore;
		this.firstHomeScore = firstHomeScore;
		this.firstGuestScore = firstGuestScore;
		this.secondHomeScore = secondHomeScore;
		this.secondGuestScore = secondGuestScore;
		this.thirdHomeScore = thirdHomeScore;
		this.thirdGuestScore = thirdGuestScore;
		this.fourthHomeScore = forthHomeScore;
		this.fourthGuestScore = forthGuestScore;
	}

	@Id
	@GeneratedValue
	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(String seasonId) {
		this.seasonId = seasonId;
	}

	public String getGameDate() {
		return gameDate;
	}

	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getGuestTeam() {
		return guestTeam;
	}

	public void setGuestTeam(String guestTeam) {
		this.guestTeam = guestTeam;
	}

	public String getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(String homeScore) {
		this.homeScore = homeScore;
	}

	public String getGueatScore() {
		return gueatScore;
	}

	public void setGueatScore(String gueatScore) {
		this.gueatScore = gueatScore;
	}

	public String getFirstHomeScore() {
		return firstHomeScore;
	}

	public void setFirstHomeScore(String firstHomeScore) {
		this.firstHomeScore = firstHomeScore;
	}

	public String getFirstGuestScore() {
		return firstGuestScore;
	}

	public void setFirstGuestScore(String firstGuestScore) {
		this.firstGuestScore = firstGuestScore;
	}

	public String getSecondHomeScore() {
		return secondHomeScore;
	}

	public void setSecondHomeScore(String secondHomeScore) {
		this.secondHomeScore = secondHomeScore;
	}

	public String getSecondGuestScore() {
		return secondGuestScore;
	}

	public void setSecondGuestScore(String secondGuestScore) {
		this.secondGuestScore = secondGuestScore;
	}

	public String getThirdHomeScore() {
		return thirdHomeScore;
	}

	public void setThirdHomeScore(String thirdHomeScore) {
		this.thirdHomeScore = thirdHomeScore;
	}

	public String getThirdGuestScore() {
		return thirdGuestScore;
	}

	public void setThirdGuestScore(String thirdGuestScore) {
		this.thirdGuestScore = thirdGuestScore;
	}

	public String getFourthHomeScore() {
		return fourthHomeScore;
	}

	public void setFourthHomeScore(String forthHomeScore) {
		this.fourthHomeScore = forthHomeScore;
	}

	public String getFourthGuestScore() {
		return fourthGuestScore;
	}

	public void setFourthGuestScore(String forthGuestScore) {
		this.fourthGuestScore = forthGuestScore;
	}

	public String toString() {
		return gameDate + ":"+homeTeam+homeScore+"-"+gueatScore+guestTeam;
	}
}
