package edu.nju.nba.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @className GameDataStatistics
 * @description 球队单场比赛数据
 * @author 作者 : haofeng
 */

@Entity
@Table
public class GameDataStatistics {

	// 球队比赛id
	private Integer teamgameid;
	// 比赛时间
	private String gameDate;
	// 比赛总体信息
	private String gameinfo;
	// 主客场
	private String hostOrGuest;
	// 投篮命中率
	private String percentage;
	// 命中数
	private int hitNum;
	// 出手数
	private int shootingNum;
	// 三分命中率
	private String threePercentage;
	// 三分命中
	private int threeHitNum;
	// 三分出手数
	private int threeShootingNum;
	// 罚球命中率
	private String freePercentage;
	// 罚球命中
	private int freeHitNum;
	// 罚球出手数
	private int freeShootingNum;
	// 篮板
	private int rebound;
	// 前场板
	private int offensiveRebound;
	// 后场板
	private int defensiveRebound;
	// 助攻
	private int assistance;
	// 抢断
	private int steal;
	// 盖帽
	private int block;
	// 失误
	private int mistake;
	// 犯规
	private int fault;

	// 总得分
	public GameDataStatistics() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GameDataStatistics(Integer teamgameid, String gameDate,
			String gameinfo, String hostOrGuest, String percentage, int hitNum,
			int shootingNum, String threePercentage, int threeHitNum,
			int threeShootingNum, String freePercentage, int freeHitNum,
			int freeShootingNum, int rebound, int offensiveRebound,
			int defensiveRebound, int assistance, int steal, int block,
			int mistake, int fault) {
		super();
		this.teamgameid = teamgameid;
		this.gameDate = gameDate;
		this.gameinfo = gameinfo;
		this.hostOrGuest = hostOrGuest;
		this.percentage = percentage;
		this.hitNum = hitNum;
		this.shootingNum = shootingNum;
		this.threePercentage = threePercentage;
		this.threeHitNum = threeHitNum;
		this.threeShootingNum = threeShootingNum;
		this.freePercentage = freePercentage;
		this.freeHitNum = freeHitNum;
		this.freeShootingNum = freeShootingNum;
		this.rebound = rebound;
		this.offensiveRebound = offensiveRebound;
		this.defensiveRebound = defensiveRebound;
		this.assistance = assistance;
		this.steal = steal;
		this.block = block;
		this.mistake = mistake;
		this.fault = fault;
	}

	@Id
	@GeneratedValue
	public Integer getTeamgameid() {
		return teamgameid;
	}

	public void setTeamgameid(Integer teamgameid) {
		this.teamgameid = teamgameid;
	}

	public String getGameDate() {
		return gameDate;
	}

	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}

	public String getGameinfo() {
		return gameinfo;
	}

	public void setGameinfo(String gameinfo) {
		this.gameinfo = gameinfo;
	}

	public String getHostOrGuest() {
		return hostOrGuest;
	}

	public void setHostOrGuest(String hostOrGuest) {
		this.hostOrGuest = hostOrGuest;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public int getHitNum() {
		return hitNum;
	}

	public void setHitNum(int hitNum) {
		this.hitNum = hitNum;
	}

	public int getShootingNum() {
		return shootingNum;
	}

	public void setShootingNum(int shootingNum) {
		this.shootingNum = shootingNum;
	}

	public String getThreePercentage() {
		return threePercentage;
	}

	public void setThreePercentage(String threePercentage) {
		this.threePercentage = threePercentage;
	}

	public int getThreeHitNum() {
		return threeHitNum;
	}

	public void setThreeHitNum(int threeHitNum) {
		this.threeHitNum = threeHitNum;
	}

	public int getThreeShootingNum() {
		return threeShootingNum;
	}

	public void setThreeShootingNum(int threeShootingNum) {
		this.threeShootingNum = threeShootingNum;
	}

	public String getFreePercentage() {
		return freePercentage;
	}

	public void setFreePercentage(String freePercentage) {
		this.freePercentage = freePercentage;
	}

	public int getFreeHitNum() {
		return freeHitNum;
	}

	public void setFreeHitNum(int freeHitNum) {
		this.freeHitNum = freeHitNum;
	}

	public int getFreeShootingNum() {
		return freeShootingNum;
	}

	public void setFreeShootingNum(int freeShootingNum) {
		this.freeShootingNum = freeShootingNum;
	}

	public int getRebound() {
		return rebound;
	}

	public void setRebound(int rebound) {
		this.rebound = rebound;
	}

	public int getOffensiveRebound() {
		return offensiveRebound;
	}

	public void setOffensiveRebound(int offensiveRebound) {
		this.offensiveRebound = offensiveRebound;
	}

	public int getDefensiveRebound() {
		return defensiveRebound;
	}

	public void setDefensiveRebound(int defensiveRebound) {
		this.defensiveRebound = defensiveRebound;
	}

	public int getAssistance() {
		return assistance;
	}

	public void setAssistance(int assistance) {
		this.assistance = assistance;
	}

	public int getSteal() {
		return steal;
	}

	public void setSteal(int steal) {
		this.steal = steal;
	}

	public int getBlock() {
		return block;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	public int getMistake() {
		return mistake;
	}

	public void setMistake(int mistake) {
		this.mistake = mistake;
	}

	public int getFault() {
		return fault;
	}

	public void setFault(int fault) {
		this.fault = fault;
	}

}
