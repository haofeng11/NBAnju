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
@Table(name = "team_game_record")
public class TeamGameRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	// 根据公式计算排名：胜场/（胜场+负场）*100%
	private String rank;
	private String seasonID;
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
	// 东西部
	private String district;
	private String tag;

	public TeamGameRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
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

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSeasonID() {
		return seasonID;
	}

	public void setSeasonID(String seasonID) {
		this.seasonID = seasonID;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
	

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public TeamGameRecord(String rank, String seasonID, String team,
			String winGame, String loseGame, String victory, String winGap,
			String district, String tag) {
		super();
		this.rank = rank;
		this.seasonID = seasonID;
		this.team = team;
		this.winGame = winGame;
		this.loseGame = loseGame;
		this.victory = victory;
		this.winGap = winGap;
		this.district = district;
		this.tag = tag;
	}

	

}
