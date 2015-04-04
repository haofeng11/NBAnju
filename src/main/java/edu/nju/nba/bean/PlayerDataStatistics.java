package edu.nju.nba.bean;

import java.io.Serializable;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @className PlayerDataStatistics
 * @description 球员赛季场均基本数据
 * @author 作者 : wxd
 * @date 创建时间：2015年3月31日 下午3:29:17
 */

@Entity
@Table
public class PlayerDataStatistics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
    private Integer ID;
	// 球员ID
	private Integer playerID;
	// 赛季ID
	private String seasonID;
	//所在球队
	private String teamName;
	//出场次数
	private String appearances;
	//首发次数
	private String numOfStarting;
	//时间
	private String time;
	// 得分
	private String score;
	// 助攻
	private String assistance;
	// 篮板
	private String rebound;
	//进攻篮板
	private String offensiveRebound;
	//防守篮板
	private String defensiveRebound;
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
	//罚球出手
	private String numOfFreThrow;
	//罚球命中
	private String numOfFreeThrowHit;
	// 盖帽
	private String block;
	// 抢断
	private String steal;
	// 失误次数
	private String mistake;
	// 犯规次数
	private String foul;
	//胜场
	private String numOfWin;
	//负场
	private String numOfLoss;
	//用来标记是常规赛数据还是季后赛数据
	//tag=1表示常规赛；tag=2表示季后赛
	private String tag;

	public PlayerDataStatistics() {
		super();
	}

	
   
    public PlayerDataStatistics(Integer iD, Integer playerID, String seasonID,
			String teamName, String appearances, String numOfStarting,
			String time, String score, String assistance, String rebound,
			String offensiveRebound, String defensiveRebound,
			String numOfShoot, String numOfHit, String shootPercentage,
			String numOfThreeShoot, String numOfThreeHit,
			String threeShootPercentage, String trueShootingPercentage,
			String freeThrowPercentage, String numOfFreThrow,
			String numOfFreeThrowHit, String block, String steal,
			String mistake, String foul, String numOfWin, String numOfLoss,
			String tag) {
		super();
		ID = iD;
		this.playerID = playerID;
		this.seasonID = seasonID;
		this.teamName = teamName;
		this.appearances = appearances;
		this.numOfStarting = numOfStarting;
		this.time = time;
		this.score = score;
		this.assistance = assistance;
		this.rebound = rebound;
		this.offensiveRebound = offensiveRebound;
		this.defensiveRebound = defensiveRebound;
		this.numOfShoot = numOfShoot;
		this.numOfHit = numOfHit;
		this.shootPercentage = shootPercentage;
		this.numOfThreeShoot = numOfThreeShoot;
		this.numOfThreeHit = numOfThreeHit;
		this.threeShootPercentage = threeShootPercentage;
		this.trueShootingPercentage = trueShootingPercentage;
		this.freeThrowPercentage = freeThrowPercentage;
		this.numOfFreThrow = numOfFreThrow;
		this.numOfFreeThrowHit = numOfFreeThrowHit;
		this.block = block;
		this.steal = steal;
		this.mistake = mistake;
		this.foul = foul;
		this.numOfWin = numOfWin;
		this.numOfLoss = numOfLoss;
		this.tag = tag;
	}



	@Id
    @GeneratedValue
	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getPlayerID() {
		return playerID;
	}

	public void setPlayerID(Integer playerID) {
		this.playerID = playerID;
	}

	public String getSeasonID() {
		return seasonID;
	}

	public void setSeasonID(String seasonID) {
		this.seasonID = seasonID;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
	
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getAppearances() {
		return appearances;
	}

	public void setAppearances(String appearances) {
		this.appearances = appearances;
	}

	public String getNumOfStarting() {
		return numOfStarting;
	}

	public void setNumOfStarting(String numOfStarting) {
		this.numOfStarting = numOfStarting;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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

	public String getNumOfFreThrow() {
		return numOfFreThrow;
	}

	public void setNumOfFreThrow(String numOfFreThrow) {
		this.numOfFreThrow = numOfFreThrow;
	}

	public String getNumOfFreeThrowHit() {
		return numOfFreeThrowHit;
	}

	public void setNumOfFreeThrowHit(String numOfFreeThrowHit) {
		this.numOfFreeThrowHit = numOfFreeThrowHit;
	}

	public String getNumOfWin() {
		return numOfWin;
	}

	public void setNumOfWin(String numOfWin) {
		this.numOfWin = numOfWin;
	}

	public String getNumOfLoss() {
		return numOfLoss;
	}

	public void setNumOfLoss(String numOfLoss) {
		this.numOfLoss = numOfLoss;
	}

	public String toString(){
		return "赛季ID："+seasonID+" 球员ID： "+playerID+" 得分："+score;
	}

	
}
