package edu.nju.nba.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @classname GameSchedule
 * @description 赛程类
 * @author fenghao
 * 
 */
//赛程类不要？

/*@Entity
@Table*/
public class GameSchedule implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String gameId;
	// 赛季ID
	private String seasonId;
	// 比赛日期
	private String gameDate;
	// 主队id
	private String homeTeam;
	// 客队id
	private String guestTeam;
	// 主队得分
	private String homeScore;
	// 客队得分
	private String guestScore;

	public GameSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GameSchedule(String gameId, String seasonId, String gameDate,
			String hometeam, String guestteam, String homeScore,
			String guestScore) {
		super();
		this.gameId = gameId;
		this.seasonId = seasonId;
		this.gameDate = gameDate;
		this.homeTeam = hometeam;
		this.guestTeam = guestteam;
		this.homeScore = homeScore;
		this.guestScore = guestScore;
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

	public String getHometeam() {
		return homeTeam;
	}

	public void setHometeam(String hometeam) {
		this.homeTeam = hometeam;
	}

	public String getGuestteam() {
		return guestTeam;
	}

	public void setGuestteam(String guestteam) {
		this.guestTeam = guestteam;
	}

	public String getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(String homeScore) {
		this.homeScore = homeScore;
	}

	public String getGuestScore() {
		return guestScore;
	}

	public void setGuestScore(String guestScore) {
		this.guestScore = guestScore;
	}
	
	public String toString() {
		return gameDate + ":"+homeTeam+homeScore+"-"+guestScore+guestTeam;
	}

}
