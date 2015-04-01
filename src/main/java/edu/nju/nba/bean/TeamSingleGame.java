package edu.nju.nba.bean;

/**
 * @className TeamSingleGame
 * @description 球队单场数据类
 * @author 作者 :fenghao
 * @date 创建时间：2015年3月31日 下午4:36:26
 */

public class TeamSingleGame {

	// 球队ID
	private Integer teamID;
	// 赛季ID
	private Integer seasonID;
	// 得分
	private double Score;
	// 助攻
	private double Assistance;
	// 篮板
	private double Rebound;
	// 出手
	private int numOfShoot;
	// 命中
	private int numOfHit;
	// 命中率
	private String shootPercentage;
	// 三分出手
	private int numOfThreeShoot;
	// 三分命中
	private int numOfThreeHit;
	// 三分命中率
	private String threeShootPercentage;
	// 罚球命中率
	private String freeThrowPercentage;
	// 盖帽
	private double block;
	// 抢断
	private double steal;
	// 失误次数
	private int mistake;
	// 犯规次数
	private int foul;

	public Integer getTeamID() {
		return teamID;
	}

	public void setTeamID(Integer teamID) {
		this.teamID = teamID;
	}

	public Integer getSeasonID() {
		return seasonID;
	}

	public void setSeasonID(Integer seasonID) {
		this.seasonID = seasonID;
	}

	public double getScore() {
		return Score;
	}

	public void setScore(double score) {
		Score = score;
	}

	public double getAssistance() {
		return Assistance;
	}

	public void setAssistance(double assistance) {
		Assistance = assistance;
	}

	public double getRebound() {
		return Rebound;
	}

	public void setRebound(double rebound) {
		Rebound = rebound;
	}

	public int getNumOfShoot() {
		return numOfShoot;
	}

	public void setNumOfShoot(int numOfShoot) {
		this.numOfShoot = numOfShoot;
	}

	public int getNumOfHit() {
		return numOfHit;
	}

	public void setNumOfHit(int numOfHit) {
		this.numOfHit = numOfHit;
	}

	public String getShootPercentage() {
		return shootPercentage;
	}

	public void setShootPercentage(String shootPercentage) {
		this.shootPercentage = shootPercentage;
	}

	public int getNumOfThreeShoot() {
		return numOfThreeShoot;
	}

	public void setNumOfThreeShoot(int numOfThreeShoot) {
		this.numOfThreeShoot = numOfThreeShoot;
	}

	public int getNumOfThreeHit() {
		return numOfThreeHit;
	}

	public void setNumOfThreeHit(int numOfThreeHit) {
		this.numOfThreeHit = numOfThreeHit;
	}

	public String getThreeShootPercentage() {
		return threeShootPercentage;
	}

	public void setThreeShootPercentage(String threeShootPercentage) {
		this.threeShootPercentage = threeShootPercentage;
	}

	public String getFreeThrowPercentage() {
		return freeThrowPercentage;
	}

	public void setFreeThrowPercentage(String freeThrowPercentage) {
		this.freeThrowPercentage = freeThrowPercentage;
	}

	public double getBlock() {
		return block;
	}

	public void setBlock(double block) {
		this.block = block;
	}

	public double getSteal() {
		return steal;
	}

	public void setSteal(double steal) {
		this.steal = steal;
	}

	public int getMistake() {
		return mistake;
	}

	public void setMistake(int mistake) {
		this.mistake = mistake;
	}

	public int getFoul() {
		return foul;
	}

	public void setFoul(int foul) {
		this.foul = foul;
	}
}
