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
@Table(name = "player_season_average")
public class PlayerDataStatistics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer ID;
	// 球员姓名
	private String player;
	// 赛季ID
	private String seasonID;
	// 所在球队
	private String team;
	// 出场次数
	private String appearCnt;
	// 首发次数
	private String firstCnt;
	// 时间
	private String playTime;
	// 得分
	private String score;
	// 助攻
	private String assistance;
	// 篮板
	private String rebound;
	// 进攻篮板
	private String offensiveRebound;
	// 防守篮板
	private String defensiveRebound;
	// 出手
	private String shootTotal;
	// 命中
	private String shootHit;
	// 命中率
	private String shootPercentage;
	// 三分出手
	private String threeTotal;
	// 三分命中
	private String threeHit;
	// 三分命中率
	private String threePercentage;
	// 罚球命中率
	private String freeThrowPercentage;
	// 罚球出手
	private String freeThrowTotal;
	// 罚球命中
	private String freeThrowHit;
	// 盖帽
	private String block;
	// 抢断
	private String grab;
	// 失误次数
	private String mistake;
	// 犯规次数
	private String foul;
	// 胜场
	private String winCnt;
	// 负场
	private String loseCnt;
	// 标识，0代表常规赛，1代表季后赛
	private String tag;

	public PlayerDataStatistics() {
		super();
	}

	public PlayerDataStatistics(Integer iD, String player, String seasonID,
			String team, String appearCnt, String firstCnt, String playTime,
			String score, String assistance, String rebound,
			String offensiveRebound, String defensiveRebound,
			String shootTotal, String shootHit, String shootPercentage,
			String threeTotal, String threeHit, String threePercentage,
			String freeThrowPercentage, String freeThrowTotal,
			String freeThrowHit, String block, String grab, String mistake,
			String foul, String winCnt, String loseCnt, String tag) {
		super();
		ID = iD;
		this.player = player;
		this.seasonID = seasonID;
		this.team = team;
		this.appearCnt = appearCnt;
		this.firstCnt = firstCnt;
		this.playTime = playTime;
		this.score = score;
		this.assistance = assistance;
		this.rebound = rebound;
		this.offensiveRebound = offensiveRebound;
		this.defensiveRebound = defensiveRebound;
		this.shootTotal = shootTotal;
		this.shootHit = shootHit;
		this.shootPercentage = shootPercentage;
		this.threeTotal = threeTotal;
		this.threeHit = threeHit;
		this.threePercentage = threePercentage;
		this.freeThrowPercentage = freeThrowPercentage;
		this.freeThrowTotal = freeThrowTotal;
		this.freeThrowHit = freeThrowHit;
		this.block = block;
		this.grab = grab;
		this.mistake = mistake;
		this.foul = foul;
		this.winCnt = winCnt;
		this.loseCnt = loseCnt;
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

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
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

	public String getAppearCnt() {
		return appearCnt;
	}

	public void setAppearCnt(String appearCnt) {
		this.appearCnt = appearCnt;
	}

	public String getFirstCnt() {
		return firstCnt;
	}

	public void setFirstCnt(String firstCnt) {
		this.firstCnt = firstCnt;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
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

	public String getShootTotal() {
		return shootTotal;
	}

	public void setShootTotal(String shootTotal) {
		this.shootTotal = shootTotal;
	}

	public String getShootHit() {
		return shootHit;
	}

	public void setShootHit(String shootHit) {
		this.shootHit = shootHit;
	}

	public String getShootPercentage() {
		return shootPercentage;
	}

	public void setShootPercentage(String shootPercentage) {
		this.shootPercentage = shootPercentage;
	}

	public String getThreeTotal() {
		return threeTotal;
	}

	public void setThreeTotal(String threeTotal) {
		this.threeTotal = threeTotal;
	}

	public String getThreeHit() {
		return threeHit;
	}

	public void setThreeHit(String threeHit) {
		this.threeHit = threeHit;
	}

	public String getThreePercentage() {
		return threePercentage;
	}

	public void setThreePercentage(String threePercentage) {
		this.threePercentage = threePercentage;
	}

	public String getFreeThrowPercentage() {
		return freeThrowPercentage;
	}

	public void setFreeThrowPercentage(String freeThrowPercentage) {
		this.freeThrowPercentage = freeThrowPercentage;
	}

	public String getFreeThrowTotal() {
		return freeThrowTotal;
	}

	public void setFreeThrowTotal(String freeThrowTotal) {
		this.freeThrowTotal = freeThrowTotal;
	}

	public String getFreeThrowHit() {
		return freeThrowHit;
	}

	public void setFreeThrowHit(String freeThrowHit) {
		this.freeThrowHit = freeThrowHit;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getGrab() {
		return grab;
	}

	public void setGrab(String grab) {
		this.grab = grab;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String toString() {
		return "赛季ID：" + seasonID + " 球员： " + player + " 得分：" + score;
	}

}
