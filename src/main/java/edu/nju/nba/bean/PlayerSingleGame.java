package edu.nju.nba.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @className PlayerSingleGame
 * @description 球员单场数据
 * @author 作者 : haofeng
 * @date 创建时间：2015年3月31日 下午3:29:17
 */

@Entity
@Table
public class PlayerSingleGame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 球员ID
	private Integer playerID;
	// 赛季ID
	private Integer seasonID;
	// 球队
	private String team;
	// 得分
	private String score;
	// 助攻
	private String assistance;
	// 篮板
	private String rebound;
	// 出手
	private String numOfShoot;
	// 命中
	private String numOfHit;
	// 命中率
	private String shootPercentage;
	// 三分出手
	private String numOfThreeShoot;
	// 三分命中
	private String numOfThreeHit;
	// 三分命中率
	private String threeShootPercentage;
	// 真实命中率
	private String trueShootingPercentage;
	// 罚球命中率
	private String freeThrowPercentage;
	// 盖帽
	private String block;
	// 抢断
	private String steal;
	// 失误次数
	private String mistake;
	// 犯规次数
	private String foul;

	public PlayerSingleGame() {
		super();
	}

	public PlayerSingleGame(Integer playerID, Integer seasonID, String team,
			String score, String assistance, String rebound, String numOfShoot,
			String numOfHit, String shootPercentage, String numOfThreeShoot,
			String numOfThreeHit, String threeShootPercentage,
			String trueShootingPercentage, String freeThrowPercentage,
			String block, String steal, String mistake, String foul) {
		super();
		this.playerID = playerID;
		this.seasonID = seasonID;
		this.team = team;
		this.score = score;
		this.assistance = assistance;
		this.rebound = rebound;
		this.numOfShoot = numOfShoot;
		this.numOfHit = numOfHit;
		this.shootPercentage = shootPercentage;
		this.numOfThreeShoot = numOfThreeShoot;
		this.numOfThreeHit = numOfThreeHit;
		this.threeShootPercentage = threeShootPercentage;
		this.trueShootingPercentage = trueShootingPercentage;
		this.freeThrowPercentage = freeThrowPercentage;
		this.block = block;
		this.steal = steal;
		this.mistake = mistake;
		this.foul = foul;
	}

	public Integer getPlayerID() {
		return playerID;
	}
   
	public void setPlayerID(Integer playerID) {
		this.playerID = playerID;
	}
	
	@Id
	@GeneratedValue
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

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getAssistance() {
		return assistance;
	}

	public void setAssistance(String assistance) {
		this.assistance = assistance;
	}

	public String getRebound() {
		return rebound;
	}

	public void setRebound(String rebound) {
		this.rebound = rebound;
	}

	public String getNumOfShoot() {
		return numOfShoot;
	}

	public void setNumOfShoot(String numOfShoot) {
		this.numOfShoot = numOfShoot;
	}

	public String getNumOfHit() {
		return numOfHit;
	}

	public void setNumOfHit(String numOfHit) {
		this.numOfHit = numOfHit;
	}

	public String getShootPercentage() {
		return shootPercentage;
	}

	public void setShootPercentage(String shootPercentage) {
		this.shootPercentage = shootPercentage;
	}

	public String getNumOfThreeShoot() {
		return numOfThreeShoot;
	}

	public void setNumOfThreeShoot(String numOfThreeShoot) {
		this.numOfThreeShoot = numOfThreeShoot;
	}

	public String getNumOfThreeHit() {
		return numOfThreeHit;
	}

	public void setNumOfThreeHit(String numOfThreeHit) {
		this.numOfThreeHit = numOfThreeHit;
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

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getSteal() {
		return steal;
	}

	public void setSteal(String steal) {
		this.steal = steal;
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

}
