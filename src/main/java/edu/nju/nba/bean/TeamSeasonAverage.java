package edu.nju.nba.bean;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @className TeamSingleGame
 * @description 球队单赛季平均数据类
 * @author 作者 :fenghao
 */

@Entity
@Table (name="team_season_average")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class TeamSeasonAverage implements Serializable {

	private static final long serialVersionUID = 1L;

	// 单独ID
	private Integer id;
	// 球队
	private String team;
	// 赛季ID
	private String seasonID;
	// 场次
	private String gameCnt;
	// 胜场
	private String winCnt;
	// 负场
	private String loseCnt;
	// 命中率
	private String shootPercentage;
	// 命中
	private int shootHit;
	// 出手
	private int shootTotal;
	// 三分命中率
	private String threePercentage;
	// 三分命中
	private int threeHit;
	// 三分出手
	private int threeTotal;
	// 罚球命中率
	private String freeThrowPercentage;
	// 罚球命中
	private String freeThrowHit;
	// 罚球出手数
	private String freeThrowTotal;
	// 篮板
	private String rebound;
	// 前场板
	private String offensiveRebound;
	// 后场板
	private String defensiveRebound;
	// 助攻
	private String assistance;
	// 抢断
	private String grab;
	// 盖帽
	private String block;
	// 失误
	private String mistake;
	// 犯规
	private String foul;
	// 总得分
	private String score;
	
	

	public TeamSeasonAverage() {
		super();
		
	}

	public TeamSeasonAverage(Integer id, String team, String seasonID,
			String gameCnt, String winCnt, String loseCnt,
			String shootPercentage, int shootHit, int shootTotal,
			String threePercentage, int threeHit, int threeTotal,
			String freeThrowPercentage, String freeThrowHit,
			String freeThrowTotal, String rebound, String offensiveRebound,
			String defensiveRebound, String assistance, String grab,
			String block, String mistake, String foul, String score) {
		super();
		this.id = id;
		this.team = team;
		this.seasonID = seasonID;
		this.gameCnt = gameCnt;
		this.winCnt = winCnt;
		this.loseCnt = loseCnt;
		this.shootPercentage = shootPercentage;
		this.shootHit = shootHit;
		this.shootTotal = shootTotal;
		this.threePercentage = threePercentage;
		this.threeHit = threeHit;
		this.threeTotal = threeTotal;
		this.freeThrowPercentage = freeThrowPercentage;
		this.freeThrowHit = freeThrowHit;
		this.freeThrowTotal = freeThrowTotal;
		this.rebound = rebound;
		this.offensiveRebound = offensiveRebound;
		this.defensiveRebound = defensiveRebound;
		this.assistance = assistance;
		this.grab = grab;
		this.block = block;
		this.mistake = mistake;
		this.foul = foul;
		this.score = score;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSeasonID() {
		return seasonID;
	}

	public void setSeasonID(String seasonID) {
		this.seasonID = seasonID;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getGameCnt() {
		return gameCnt;
	}

	public void setGameCnt(String gameCnt) {
		this.gameCnt = gameCnt;
	}

	public String getWinCnt() {
		return winCnt;
	}

	public void setWinCnt(String winCnt) {
		this.winCnt = winCnt;
	}

	public String getLoseCnt() {
		return loseCnt;
	}

	public void setLoseCnt(String loseCnt) {
		this.loseCnt = loseCnt;
	}

	public String getShootPercentage() {
		return shootPercentage;
	}

	public void setShootPercentage(String shootPercentage) {
		this.shootPercentage = shootPercentage;
	}

	public int getShootHit() {
		return shootHit;
	}

	public void setShootHit(int shootHit) {
		this.shootHit = shootHit;
	}

	public int getShootTotal() {
		return shootTotal;
	}

	public void setShootTotal(int shootTotal) {
		this.shootTotal = shootTotal;
	}

	public String getThreePercentage() {
		return threePercentage;
	}

	public void setThreePercentage(String threePercentage) {
		this.threePercentage = threePercentage;
	}

	public int getThreeHit() {
		return threeHit;
	}

	public void setThreeHit(int threeHit) {
		this.threeHit = threeHit;
	}

	public int getThreeTotal() {
		return threeTotal;
	}

	public void setThreeTotal(int threeTotal) {
		this.threeTotal = threeTotal;
	}

	public String getFreeThrowPercentage() {
		return freeThrowPercentage;
	}

	public void setFreeThrowPercentage(String freeThrowPercentage) {
		this.freeThrowPercentage = freeThrowPercentage;
	}

	public String getFreeThrowHit() {
		return freeThrowHit;
	}

	public void setFreeThrowHit(String freeThrowHit) {
		this.freeThrowHit = freeThrowHit;
	}

	public String getFreeThrowTotal() {
		return freeThrowTotal;
	}

	public void setFreeThrowTotal(String freeThrowTotal) {
		this.freeThrowTotal = freeThrowTotal;
	}

	public String getRebound() {
		return rebound;
	}

	public void setRebound(String rebound) {
		this.rebound = rebound;
	}

	public String getOffensiveRebound() {
		return offensiveRebound;
	}

	public void setOffensiveRebound(String offensiveRebound) {
		this.offensiveRebound = offensiveRebound;
	}

	public String getDefensiveRebound() {
		return defensiveRebound;
	}

	public void setDefensiveRebound(String defensiveRebound) {
		this.defensiveRebound = defensiveRebound;
	}

	public String getAssistance() {
		return assistance;
	}

	public void setAssistance(String assistance) {
		this.assistance = assistance;
	}

	public String getGrab() {
		return grab;
	}

	public void setGrab(String grab) {
		this.grab = grab;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getMistake() {
		return mistake;
	}

	public void setMistake(String mistake) {
		this.mistake = mistake;
	}

	public String getFoul() {
		return foul;
	}

	public void setFoul(String foul) {
		this.foul = foul;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

	public String toString(){
		return "team: "+team+" seasonID： "+seasonID+" score: "+score;
		
	}

}
