package edu.nju.nba.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @className GameSingleDataStatistics
 * @description 球队单场比赛数据
 * @author 作者 : haofeng
 */

@Entity
@Table (name="team_single_game")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class TeamSingleGame implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	// 赛季ID
	private String seasonID;
	// 比赛日期
	private String gameDate;
	// 球队名
	private String team;
	// 出场人数
	private String appearPlayerCnt;
	// 投篮命中率
	private String shootPercentage;
	// 命中数
	private String shootHit;
	// 出手数
	private String shootTotal;
	// 三分命中率
	private String threePercentage;
	// 三分命中
	private String threeHit;
	// 三分出手数
	private String threeTotal;
	// 罚球命中率
	private String freeThrowPercentage;
	// 罚球命中
	private String freeThrowHit;
	// 罚球出手数
	private String freeThrowTotal;
	// 真实命中率
	private String truePercentage;
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

	public TeamSingleGame() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeamSingleGame(Integer id, String seasonId, String gameDate,
			String team, String appearPlayerCnt, String shootPercentage,
			String shootHit, String shootTotal, String threePercentage,
			String threeHit, String threeTotal, String freeThrowPercentage,
			String freeThrowHit, String freeThrowTotal, String truePercentage,
			String rebound, String offensiveRebound, String defensiveRebound,
			String assistance, String grab, String block, String mistake,
			String foul, String score) {
		super();
		this.id = id;
		this.seasonID = seasonId;
		this.gameDate = gameDate;
		this.team = team;
		this.appearPlayerCnt = appearPlayerCnt;
		this.shootPercentage = shootPercentage;
		this.shootHit = shootHit;
		this.shootTotal = shootTotal;
		this.threePercentage = threePercentage;
		this.threeHit = threeHit;
		this.threeTotal = threeTotal;
		this.freeThrowPercentage = freeThrowPercentage;
		this.freeThrowHit = freeThrowHit;
		this.freeThrowTotal = freeThrowTotal;
		this.truePercentage = truePercentage;
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

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getSeasonID() {
		return seasonID;
	}

	public void setSeasonID(String seasonId) {
		this.seasonID= seasonId;
	}

	public String getGameDate() {
		return gameDate;
	}

	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}

	public String getAppearPlayerCnt() {
		return appearPlayerCnt;
	}

	public void setAppearPlayerCnt(String appearPlayerCnt) {
		this.appearPlayerCnt = appearPlayerCnt;
	}

	public String getShootPercentage() {
		return shootPercentage;
	}

	public void setShootPercentage(String shootPercentage) {
		this.shootPercentage = shootPercentage;
	}

	public String getShootHit() {
		return shootHit;
	}

	public void setShootHit(String shootHit) {
		this.shootHit = shootHit;
	}

	public String getShootTotal() {
		return shootTotal;
	}

	public void setShootTotal(String shootTotal) {
		this.shootTotal = shootTotal;
	}

	public String getThreePercentage() {
		return threePercentage;
	}

	public void setThreePercentage(String threePercentage) {
		this.threePercentage = threePercentage;
	}

	public String getThreeHit() {
		return threeHit;
	}

	public void setThreeHit(String threeHit) {
		this.threeHit = threeHit;
	}

	public String getThreeTotal() {
		return threeTotal;
	}

	public void setThreeTotal(String threeTotal) {
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

	public String getTruePercentage() {
		return truePercentage;
	}

	public void setTruePercentage(String truePercentage) {
		this.truePercentage = truePercentage;
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

}
