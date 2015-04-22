package edu.nju.nba.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @className TeamGameRecord
 * @description 球队战绩类（每日更新）
 * @author fenghao
 * 
 */

@Entity
@Table(name="team_game_record")
public class TeamGameRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	// 根据公式计算排名：胜场/（胜场+负场）*100%
	private String teamRanking;
	private String seasonID;
	public String getSeasonID() {
		return seasonID;
	}

	public void setSeasonID(String seasonID) {
		this.seasonID = seasonID;
	}

	// 球队
	private String team;
	// 胜场
	private String winGame;
	// 负场
	private String loseGame;
	// 胜率
	private String victory;
	// 胜场差
	private String winGap;

	public TeamGameRecord() {
		super();
		// TODO Auto-generated constructor stub
	}



	public TeamGameRecord(String teamRankingString, String seasonID,
			String team, String winGame, String loseGame, String victory,
			String winGap) {
		super();
		this.teamRanking = teamRankingString;
		this.seasonID = seasonID;
		this.team = team;
		this.winGame = winGame;
		this.loseGame = loseGame;
		this.victory = victory;
		this.winGap = winGap;
	}

	@Id
	@GeneratedValue
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}


	public String getTeamRankingString() {
		return teamRanking;
	}

	public void setTeamRankingString(String teamRankingString) {
		this.teamRanking = teamRankingString;
	}

	public String getWinGame() {
		return winGame;
	}

	public void setWinGame(String winGame) {
		this.winGame = winGame;
	}

	public String getLoseGame() {
		return loseGame;
	}

	public void setLoseGame(String loseGame) {
		this.loseGame = loseGame;
	}

	public String getVictory() {
		return victory;
	}

	public void setVictory(String victory) {
		this.victory = victory;
	}

	public String getWinGap() {
		return winGap;
	}

	public void setWinGap(String winGap) {
		this.winGap = winGap;
	}

}
