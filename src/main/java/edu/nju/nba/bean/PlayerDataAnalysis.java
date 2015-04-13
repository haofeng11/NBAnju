package edu.nju.nba.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player_season_analysis")
public class PlayerDataAnalysis implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	// 球员name
	private String player;
	// 赛季ID
	private String seasonID;
	// 所在球队
	private String team;
	private String reboundPercent;
	private String offenReboundPercent;
	private String defenReboundPercent;
	private String assistancePercent;
	private String grabPercent;
	private String blockPercent;
	private String mistakePercent;
	private String usePercent;
	private String offensiveEfficiency;
	private String defensiveEfficiency;
	private String WS;
	private String offensiveWS;
	private String defensiveWS;
	private String PER;
	private String dunk;
	private String andOne;
	private String blocked;
	private String shootDistance;
	private String keyShootPercent;
	private String keyShootHit;
	private String keyShootTotal;
	private String keyProportion;
	private String closeShootPercent;
	private String closeShootHit;
	private String closeShootTotal;
	private String closeProportion;
	private String middleShootPercent;
	private String middleShootHit;
	private String middleShootTotal;
	private String middleProportion;
	private String distantShootPercent;
	private String distantShootHit;
	private String distantShootTotal;
	private String distantProportion;
	private String truePercentage;
	private String shootEfficiency;

	public PlayerDataAnalysis() {
		super();
	}

	public PlayerDataAnalysis(String id, String player, String seasonID,
			String team, String reboundPercent, String offenReboundPercent,
			String defenReboundPercent, String assistancePercent,
			String grabPercent, String blockPercent, String mistakePercent,
			String usePercent, String offensiveEfficiency,
			String defensiveEfficiency, String wS, String offensiveWS,
			String defensiveWS, String pER, String dunk, String andOne,
			String blocked, String shootDistance, String keyShootPercent,
			String keyShootHit, String keyShootTotal, String keyProportion,
			String closeShootPercent, String closeShootHit,
			String closeShootTotal, String closeProportion,
			String middleShootPercent, String middleShootHit,
			String middleShootTotal, String middleProportion,
			String distantShootPercent, String distantShootHit,
			String distantShootTotal, String distantProportion,
			String truePercentage, String shootEfficiency) {
		super();
		this.id = id;
		this.player = player;
		this.seasonID = seasonID;
		this.team = team;
		this.reboundPercent = reboundPercent;
		this.offenReboundPercent = offenReboundPercent;
		this.defenReboundPercent = defenReboundPercent;
		this.assistancePercent = assistancePercent;
		this.grabPercent = grabPercent;
		this.blockPercent = blockPercent;
		this.mistakePercent = mistakePercent;
		this.usePercent = usePercent;
		this.offensiveEfficiency = offensiveEfficiency;
		this.defensiveEfficiency = defensiveEfficiency;
		WS = wS;
		this.offensiveWS = offensiveWS;
		this.defensiveWS = defensiveWS;
		PER = pER;
		this.dunk = dunk;
		this.andOne = andOne;
		this.blocked = blocked;
		this.shootDistance = shootDistance;
		this.keyShootPercent = keyShootPercent;
		this.keyShootHit = keyShootHit;
		this.keyShootTotal = keyShootTotal;
		this.keyProportion = keyProportion;
		this.closeShootPercent = closeShootPercent;
		this.closeShootHit = closeShootHit;
		this.closeShootTotal = closeShootTotal;
		this.closeProportion = closeProportion;
		this.middleShootPercent = middleShootPercent;
		this.middleShootHit = middleShootHit;
		this.middleShootTotal = middleShootTotal;
		this.middleProportion = middleProportion;
		this.distantShootPercent = distantShootPercent;
		this.distantShootHit = distantShootHit;
		this.distantShootTotal = distantShootTotal;
		this.distantProportion = distantProportion;
		this.truePercentage = truePercentage;
		this.shootEfficiency = shootEfficiency;
	}
    
	@GeneratedValue
	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getReboundPercent() {
		return reboundPercent;
	}

	public void setReboundPercent(String reboundPercent) {
		this.reboundPercent = reboundPercent;
	}

	public String getOffenReboundPercent() {
		return offenReboundPercent;
	}

	public void setOffenReboundPercent(String offenReboundPercent) {
		this.offenReboundPercent = offenReboundPercent;
	}

	public String getDefenReboundPercent() {
		return defenReboundPercent;
	}

	public void setDefenReboundPercent(String defenReboundPercent) {
		this.defenReboundPercent = defenReboundPercent;
	}

	public String getAssistancePercent() {
		return assistancePercent;
	}

	public void setAssistancePercent(String assistancePercent) {
		this.assistancePercent = assistancePercent;
	}

	public String getGrabPercent() {
		return grabPercent;
	}

	public void setGrabPercent(String grabPercent) {
		this.grabPercent = grabPercent;
	}

	public String getBlockPercent() {
		return blockPercent;
	}

	public void setBlockPercent(String blockPercent) {
		this.blockPercent = blockPercent;
	}

	public String getMistakePercent() {
		return mistakePercent;
	}

	public void setMistakePercent(String mistakePercent) {
		this.mistakePercent = mistakePercent;
	}

	public String getUsePercent() {
		return usePercent;
	}

	public void setUsePercent(String usePercent) {
		this.usePercent = usePercent;
	}

	public String getOffensiveEfficiency() {
		return offensiveEfficiency;
	}

	public void setOffensiveEfficiency(String offensiveEfficiency) {
		this.offensiveEfficiency = offensiveEfficiency;
	}

	public String getDefensiveEfficiency() {
		return defensiveEfficiency;
	}

	public void setDefensiveEfficiency(String defensiveEfficiency) {
		this.defensiveEfficiency = defensiveEfficiency;
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

	public String getDunk() {
		return dunk;
	}

	public void setDunk(String dunk) {
		this.dunk = dunk;
	}

	public String getAndOne() {
		return andOne;
	}

	public void setAndOne(String andOne) {
		this.andOne = andOne;
	}

	public String getBlocked() {
		return blocked;
	}

	public void setBlocked(String blocked) {
		this.blocked = blocked;
	}

	public String getShootDistance() {
		return shootDistance;
	}

	public void setShootDistance(String shootDistance) {
		this.shootDistance = shootDistance;
	}

	public String getKeyShootPercent() {
		return keyShootPercent;
	}

	public void setKeyShootPercent(String keyShootPercent) {
		this.keyShootPercent = keyShootPercent;
	}

	public String getKeyShootHit() {
		return keyShootHit;
	}

	public void setKeyShootHit(String keyShootHit) {
		this.keyShootHit = keyShootHit;
	}

	public String getKeyShootTotal() {
		return keyShootTotal;
	}

	public void setKeyShootTotal(String keyShootTotal) {
		this.keyShootTotal = keyShootTotal;
	}

	public String getKeyProportion() {
		return keyProportion;
	}

	public void setKeyProportion(String keyProportion) {
		this.keyProportion = keyProportion;
	}

	public String getCloseShootPercent() {
		return closeShootPercent;
	}

	public void setCloseShootPercent(String closeShootPercent) {
		this.closeShootPercent = closeShootPercent;
	}

	public String getCloseShootHit() {
		return closeShootHit;
	}

	public void setCloseShootHit(String closeShootHit) {
		this.closeShootHit = closeShootHit;
	}

	public String getCloseShootTotal() {
		return closeShootTotal;
	}

	public void setCloseShootTotal(String closeShootTotal) {
		this.closeShootTotal = closeShootTotal;
	}

	public String getCloseProportion() {
		return closeProportion;
	}

	public void setCloseProportion(String closeProportion) {
		this.closeProportion = closeProportion;
	}

	public String getMiddleShootPercent() {
		return middleShootPercent;
	}

	public void setMiddleShootPercent(String middleShootPercent) {
		this.middleShootPercent = middleShootPercent;
	}

	public String getMiddleShootHit() {
		return middleShootHit;
	}

	public void setMiddleShootHit(String middleShootHit) {
		this.middleShootHit = middleShootHit;
	}

	public String getMiddleShootTotal() {
		return middleShootTotal;
	}

	public void setMiddleShootTotal(String middleShootTotal) {
		this.middleShootTotal = middleShootTotal;
	}

	public String getMiddleProportion() {
		return middleProportion;
	}

	public void setMiddleProportion(String middleProportion) {
		this.middleProportion = middleProportion;
	}

	public String getDistantShootPercent() {
		return distantShootPercent;
	}

	public void setDistantShootPercent(String distantShootPercent) {
		this.distantShootPercent = distantShootPercent;
	}

	public String getDistantShootHit() {
		return distantShootHit;
	}

	public void setDistantShootHit(String distantShootHit) {
		this.distantShootHit = distantShootHit;
	}

	public String getDistantShootTotal() {
		return distantShootTotal;
	}

	public void setDistantShootTotal(String distantShootTotal) {
		this.distantShootTotal = distantShootTotal;
	}

	public String getDistantProportion() {
		return distantProportion;
	}

	public void setDistantProportion(String distantProportion) {
		this.distantProportion = distantProportion;
	}

	public String getTruePercentage() {
		return truePercentage;
	}

	public void setTruePercentage(String truePercentage) {
		this.truePercentage = truePercentage;
	}

	public String getShootEfficiency() {
		return shootEfficiency;
	}

	public void setShootEfficiency(String shootEfficiency) {
		this.shootEfficiency = shootEfficiency;
	}

	public String toString() {
		return "赛季ID：" + seasonID + " 球员name： " + player + " PER：" + PER;
	}

}
