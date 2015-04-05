package edu.nju.nba.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PlayerDataAnalysis implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer ID;
	// 球员ID
	private Integer playerID;
	// 赛季ID
	private String seasonID;
	// 所在球队
	private String teamName;
	// 出场次数
	private String appearances;
	// 首发次数
	private String numOfStarting;
	// 时间
	private String time;
	// 真实命中率
	private String realHitRatio;
	// 投篮效率
	private String shootEfficiency;
	//篮板率
	private String reboundsRatio;
	// 进攻篮板率
	private String offensiveReboundsRatio;
	// 使用率
	private String usageRatio;
	// 进攻效率
	private String offensiveEfficiency;
	// 失误率
	private String mistakeRatio;
	// 防守篮板率
	private String defensiveReboundsRatio;
	// 抢断率
	private String stealRatio;
	// 盖帽率
	private String block;
	// 防守效率
	private String defensiveEfficiency;
	// 助攻率
	private String assistanceRatio;
	// 助攻失误比
	private String ATR;
	// WS
	private String WS;
	// 进攻WS
	private String offensiveWS;
	// 防守WS
	private String defensiveWS;
	// PER
	private String PER;
	//扣篮次数
	private String numOfDunk;
	//2/3+1次数
	private String and1;
	//被冒次数
	private String fgablkd;
	// 用来标记是常规赛数据还是季后赛数据
	// tag=1表示常规赛；tag=2表示季后赛
	private String tag;

	public PlayerDataAnalysis() {
		super();
	}

	public PlayerDataAnalysis(Integer iD, Integer playerID, String seasonID,
			String teamName, String appearances, String numOfStarting,
			String time, String realHitRatio, String shootEfficiency,
			String reboundsRatio, String offensiveReboundsRatio,
			String usageRatio, String offensiveEfficiency, String mistakeRatio,
			String defensiveReboundsRatio, String stealRatio, String block,
			String defensiveEfficiency, String assistanceRatio, String aTR,
			String wS, String offensiveWS, String defensiveWS, String pER,
			String numOfDunk, String and1, String fgablkd, String tag) {
		super();
		ID = iD;
		this.playerID = playerID;
		this.seasonID = seasonID;
		this.teamName = teamName;
		this.appearances = appearances;
		this.numOfStarting = numOfStarting;
		this.time = time;
		this.realHitRatio = realHitRatio;
		this.shootEfficiency = shootEfficiency;
		this.reboundsRatio = reboundsRatio;
		this.offensiveReboundsRatio = offensiveReboundsRatio;
		this.usageRatio = usageRatio;
		this.offensiveEfficiency = offensiveEfficiency;
		this.mistakeRatio = mistakeRatio;
		this.defensiveReboundsRatio = defensiveReboundsRatio;
		this.stealRatio = stealRatio;
		this.block = block;
		this.defensiveEfficiency = defensiveEfficiency;
		this.assistanceRatio = assistanceRatio;
		ATR = aTR;
		WS = wS;
		this.offensiveWS = offensiveWS;
		this.defensiveWS = defensiveWS;
		PER = pER;
		this.numOfDunk = numOfDunk;
		this.and1 = and1;
		this.fgablkd = fgablkd;
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

	public String getRealHitRatio() {
		return realHitRatio;
	}

	public void setRealHitRatio(String realHitRatio) {
		this.realHitRatio = realHitRatio;
	}

	public String getShootEfficiency() {
		return shootEfficiency;
	}

	public void setShootEfficiency(String shootEfficiency) {
		this.shootEfficiency = shootEfficiency;
	}

	public String getOffensiveReboundsRatio() {
		return offensiveReboundsRatio;
	}

	public void setOffensiveReboundsRatio(String offensiveReboundsRatio) {
		this.offensiveReboundsRatio = offensiveReboundsRatio;
	}

	public String getUsageRatio() {
		return usageRatio;
	}

	public void setUsageRatio(String usageRatio) {
		this.usageRatio = usageRatio;
	}

	public String getOffensiveEfficiency() {
		return offensiveEfficiency;
	}

	public void setOffensiveEfficiency(String offensiveEfficiency) {
		this.offensiveEfficiency = offensiveEfficiency;
	}

	public String getMistakeRatio() {
		return mistakeRatio;
	}

	public void setMistakeRatio(String mistakeRatio) {
		this.mistakeRatio = mistakeRatio;
	}

	public String getDefensiveReboundsRatio() {
		return defensiveReboundsRatio;
	}

	public void setDefensiveReboundsRatio(String defensiveReboundsRatio) {
		this.defensiveReboundsRatio = defensiveReboundsRatio;
	}

	public String getStealRatio() {
		return stealRatio;
	}

	public void setStealRatio(String stealRatio) {
		this.stealRatio = stealRatio;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getDefensiveEfficiency() {
		return defensiveEfficiency;
	}

	public void setDefensiveEfficiency(String defensiveEfficiency) {
		this.defensiveEfficiency = defensiveEfficiency;
	}

	public String getAssistanceRatio() {
		return assistanceRatio;
	}

	public void setAssistanceRatio(String assistanceRatio) {
		this.assistanceRatio = assistanceRatio;
	}

	public String getATR() {
		return ATR;
	}

	public void setATR(String aTR) {
		ATR = aTR;
	}

	public String getWS() {
		return WS;
	}

	public void setWS(String wS) {
		WS = wS;
	}

	public String getOffensiveWS() {
		return offensiveWS;
	}

	public void setOffensiveWS(String offensiveWS) {
		this.offensiveWS = offensiveWS;
	}

	public String getDefensiveWS() {
		return defensiveWS;
	}

	public void setDefensiveWS(String defensiveWS) {
		this.defensiveWS = defensiveWS;
	}

	public String getPER() {
		return PER;
	}

	public void setPER(String pER) {
		PER = pER;
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

	public String getReboundsRatio() {
		return reboundsRatio;
	}

	public void setReboundsRatio(String reboundsRatio) {
		this.reboundsRatio = reboundsRatio;
	}

	public String getNumOfDunk() {
		return numOfDunk;
	}

	public void setNumOfDunk(String numOfDunk) {
		this.numOfDunk = numOfDunk;
	}

	public String getAnd1() {
		return and1;
	}

	public void setAnd1(String and1) {
		this.and1 = and1;
	}

	public String getFgablkd() {
		return fgablkd;
	}

	public void setFgablkd(String fgablkd) {
		this.fgablkd = fgablkd;
	}
	
	public String toString(){
		return "赛季ID："+seasonID+" 球员ID： "+playerID+" PER："+PER;
	}

}
