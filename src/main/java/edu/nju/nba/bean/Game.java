package edu.nju.nba.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @className Game
 * @description 单场比赛类（存储比赛结果信息）
 * @author 作者: fenghao
 */

@Entity
@Table
public class Game {

	private Integer gameid;
	// 比赛日期
	private String gameDate;
	// 主队id
	private Integer hostTeamid;
	// 客队id
	private Integer guestTeamid;
	// 总比分
	private String score;
	// 第一节比分
	private String firstSquareScore;
	// 第二节比分
	private String secondSquareScore;
	// 第三节比分
	private String thirdSquareScore;
	// 第四节比分
	private String forthSquareScore;

	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Game(Integer gameid, String gameDate, Integer hostTeamid,
			Integer guestTeamid, String score, String firstSquareScore,
			String secondSquareScore, String thirdSquareScore,
			String forthSquareScore) {
		super();
		this.gameid = gameid;
		this.gameDate = gameDate;
		this.hostTeamid = hostTeamid;
		this.guestTeamid = guestTeamid;
		this.score = score;
		this.firstSquareScore = firstSquareScore;
		this.secondSquareScore = secondSquareScore;
		this.thirdSquareScore = thirdSquareScore;
		this.forthSquareScore = forthSquareScore;
	}

	@Id
	@GeneratedValue
	public Integer getGameid() {
		return gameid;
	}

	public void setGameid(Integer gameid) {
		this.gameid = gameid;
	}

	public String getGameDate() {
		return gameDate;
	}

	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}

	public Integer getHostTeamid() {
		return hostTeamid;
	}

	public void setHostTeamid(Integer hostTeamid) {
		this.hostTeamid = hostTeamid;
	}

	public Integer getGuestTeamid() {
		return guestTeamid;
	}

	public void setGuestTeamid(Integer guestTeamid) {
		this.guestTeamid = guestTeamid;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getFirstSquareScore() {
		return firstSquareScore;
	}

	public void setFirstSquareScore(String firstSquareScore) {
		this.firstSquareScore = firstSquareScore;
	}

	public String getSecondSquareScore() {
		return secondSquareScore;
	}

	public void setSecondSquareScore(String secondSquareScore) {
		this.secondSquareScore = secondSquareScore;
	}

	public String getThirdSquareScore() {
		return thirdSquareScore;
	}

	public void setThirdSquareScore(String thirdSquareScore) {
		this.thirdSquareScore = thirdSquareScore;
	}

	public String getForthSquareScore() {
		return forthSquareScore;
	}

	public void setForthSquareScore(String forthSquareScore) {
		this.forthSquareScore = forthSquareScore;
	}

	public String toString(){
		return gameDate + "";
	}
}
