package edu.nju.bossfeng.nba.bean;

/**
 * @className PlayerSingleGame
 * @description 球员单场数据
 * @author 作者 : haofeng
 * @date 创建时间：2015年3月31日 下午3:29:17
 */

public class PlayerSingleGame {

	// 球员ID
	private Integer playerID;
	// 赛季ID
	private Integer seasonID;
	// 球队
	private String team;
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
	// 真实命中率
	private String trueShootingPercentage;
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

	public Integer getPlayerID() {
		return playerID;
	}

	public void setPlayerID(Integer playerID) {
		this.playerID = playerID;
	}

	public Integer getSeasonID() {
		return seasonID;
	}

	public void setSeasonID(Integer seasonID) {
		this.seasonID = seasonID;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
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

	public String getShootPercentage() {
		return shootPercentage;
	}

	public void setShootPercentage(String shootPercentage) {
		this.shootPercentage = shootPercentage;
	}

	public String getThreeShootPercentage() {
		return threeShootPercentage;
	}

	public void setThreeShootPercentage(String threeShootPercentage) {
		this.threeShootPercentage = threeShootPercentage;
	}

	public String getTrueShootingPercentage() {
		return trueShootingPercentage;
	}

	public void setTrueShootingPercentage(String trueShootingPercentage) {
		this.trueShootingPercentage = trueShootingPercentage;
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

}
