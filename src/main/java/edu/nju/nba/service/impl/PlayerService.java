package edu.nju.nba.service.impl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;








































import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nju.nba.bean.Player;
import edu.nju.nba.bean.PlayerCareerHigh;
import edu.nju.nba.bean.PlayerDataAnalysis;
import edu.nju.nba.bean.PlayerDataStatistics;
import edu.nju.nba.bean.PlayerSingleGame;
import edu.nju.nba.dao.IGeneralDao;
import edu.nju.nba.service.IPlayerService;

@Service
public class PlayerService implements IPlayerService {

	@Autowired
	private IGeneralDao generalDao;


	// 根据球员姓名查找球员，返回球员信息
	public Player show(String playerName) {		
		return (Player)generalDao.find("from edu.nju.nba.bean.Player p where p.cName=?", playerName);
	}

	// 查找所有球员基本信息
	public List<Player> list() {
		return generalDao.findAll(Player.class);
	}

	public PlayerSingleGame getPlayerSingleGame(String playerName,
			String seasonID, String gameDate) {
		
		return (PlayerSingleGame)generalDao.find3("from edu.nju.nba.bean.PlayerSingleGame p where p.player=? and p.seasonID=? and p.gameDate=?", playerName, seasonID, gameDate);
	}

	@SuppressWarnings("unchecked")
	public List<PlayerSingleGame> getPlayerSingleGames(String teamName,
			String seasonID, String gameDate) {
		return (List<PlayerSingleGame>)generalDao.findList3("from edu.nju.nba.bean.PlayerSingleGame p where p.team=? and p.seasonID=? and p.gameDate=?", teamName, seasonID, gameDate);
	}

	public PlayerDataStatistics getDataStatistics(String seasonID,
			String playerName,String tag) {
		return (PlayerDataStatistics)generalDao.find3("from edu.nju.nba.bean.PlayerDataStatistics p where p.seasonID=? and p.player=? and p.tag=?", seasonID, playerName, tag);
	}

	public PlayerDataAnalysis getDataAnalysis(String seasonID, String playerName,String tag) {
		return (PlayerDataAnalysis)generalDao.find3("from edu.nju.nba.bean.getDataAnalysis p where p.seasonID=? and p.player=? and p.tag=?", seasonID, playerName, tag);
	}

	@SuppressWarnings("unchecked")
	public List<PlayerDataStatistics> getAllDataStatistics(String seasonID,String tag) {
		return (List<PlayerDataStatistics>)generalDao.findList2("from edu.nju.nba.bean.PlayerDataStatistics p where p.seasonID=? and p.tag=?", seasonID, tag);
	}

	@SuppressWarnings("unchecked")
	public List<PlayerDataAnalysis> getAllDataAnalysis(String seasonID,String tag) {
		return (List<PlayerDataAnalysis>)generalDao.findList2("from edu.nju.nba.bean.PlayerDataAnalysis p where p.seasonID=? and p.tag=?", seasonID, tag);
	}
	
	@SuppressWarnings("unchecked")
	public List<PlayerDataStatistics> getDataStatisticsByName(
			String playerName, String tag) {	
		return (List<PlayerDataStatistics>)generalDao.findList2("from edu.nju.nba.bean.PlayerDataStatistics p where p.player=? and p.tag=?", playerName, tag);
	}

	@SuppressWarnings("unchecked")
	public List<PlayerDataAnalysis> getDataAnalysisByName(String playerName,
			String tag) {
		return (List<PlayerDataAnalysis>)generalDao.findList2("from edu.nju.nba.bean.PlayerDataAnalysis p where p.player=? and p.tag=?", playerName, tag);
	}
	
	@SuppressWarnings("unchecked")
	public List<PlayerDataStatistics> findTeam(String teamName, String seasonID, String tag) {
		return (List<PlayerDataStatistics>)generalDao.findList3("from edu.nju.nba.bean.PlayerDataStatistics p where p.seasonID=? and p.team=? and p.tag=?", seasonID, teamName, tag);
	}
	
	@SuppressWarnings("unchecked")
	public List<PlayerSingleGame> getPlayerSingleGameByID(String gameID) {
		return (List<PlayerSingleGame>)generalDao.findList("from edu.nju.nba.bean.PlayerSingleGame p where p.gameID=?", gameID);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataStatistics> getPlayerScoreRankingList(String seasonId) {
		List<PlayerDataStatistics> scoreList = getAllDataStatistics(seasonId,"0");
		Collections.sort(scoreList,new sortByScore());
		List<PlayerDataStatistics> Topten = new ArrayList<PlayerDataStatistics>(); 
		for (int i = 0; i < 3; i++) {
			Topten.add(scoreList.get(i));
		}
		return Topten;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataStatistics> getPlayerReboundRankingList(
			String seasonId) {
		List<PlayerDataStatistics> reboundList = getAllDataStatistics(seasonId,"0");
		Collections.sort(reboundList,new sortByRebound());
		List<PlayerDataStatistics> Topten = new ArrayList<PlayerDataStatistics>(); 
		for (int i = 0; i < 3; i++) {
			Topten.add(reboundList.get(i));
		}
		return Topten;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataStatistics> getPlayerAssistanceRankingList(
			String seasonId) {
		List<PlayerDataStatistics> assistanceList = getAllDataStatistics(seasonId,"0");
		Collections.sort(assistanceList,new sortByAssistance());
		List<PlayerDataStatistics> Topten = new ArrayList<PlayerDataStatistics>(); 
		for (int i = 0; i < 3; i++) {
			Topten.add(assistanceList.get(i));
		}
		return Topten;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataStatistics> getPlayerGrabRankingList(String seasonId) {
		List<PlayerDataStatistics> grabList = getAllDataStatistics(seasonId,"0");
		Collections.sort(grabList,new sortByGrab());
		List<PlayerDataStatistics> Topten = new ArrayList<PlayerDataStatistics>(); 
		for (int i = 0; i < 3; i++) {
			Topten.add(grabList.get(i));
		}
		return Topten;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataStatistics> getPlayerThreehitRankingList(
			String seasonId) {
		List<PlayerDataStatistics> threehitList = getAllDataStatistics(seasonId,"0");
		Collections.sort(threehitList,new sortByThreeehit());
		List<PlayerDataStatistics> Topten = new ArrayList<PlayerDataStatistics>(); 
		for (int i = 0; i < 3; i++) {
			Topten.add(threehitList.get(i));
		}
		return Topten;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataStatistics> getPlayerBlockRankingList(String seasonId) {
		List<PlayerDataStatistics> blockList = getAllDataStatistics(seasonId,"0");
		Collections.sort(blockList,new sortByBlock());
		List<PlayerDataStatistics> Topten = new ArrayList<PlayerDataStatistics>(); 
		for (int i = 0; i < 3; i++) {
			Topten.add(blockList.get(i));
		}
		return Topten;
	}


	@SuppressWarnings("rawtypes")
	class sortByScore implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			PlayerDataStatistics t1 = (PlayerDataStatistics) o1;
			PlayerDataStatistics t2 = (PlayerDataStatistics) o2;
			if (Double.parseDouble(t1.getScore()) < Double.parseDouble(t2
					.getScore())) {
				return 1;
			} else if (Double.parseDouble(t1.getScore()) == Double
					.parseDouble(t2.getScore())) {
				return 0;
			}
			return -1;
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	class sortByRebound implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			PlayerDataStatistics t1 = (PlayerDataStatistics) o1;
			PlayerDataStatistics t2 = (PlayerDataStatistics) o2;
			if (Double.parseDouble(t1.getRebound()) < Double.parseDouble(t2
					.getRebound())) {
				return 1;
			} else if (Double.parseDouble(t1.getRebound()) == Double
					.parseDouble(t2.getRebound())) {
				return 0;
			}
			return -1;
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	class sortByAssistance implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			PlayerDataStatistics t1 = (PlayerDataStatistics) o1;
			PlayerDataStatistics t2 = (PlayerDataStatistics) o2;
			if (Double.parseDouble(t1.getAssistance()) < Double.parseDouble(t2
					.getAssistance())) {
				return 1;
			} else if (Double.parseDouble(t1.getAssistance()) == Double
					.parseDouble(t2.getAssistance())) {
				return 0;
			}
			return -1;
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	class sortByGrab implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			PlayerDataStatistics t1 = (PlayerDataStatistics) o1;
			PlayerDataStatistics t2 = (PlayerDataStatistics) o2;
			if (Double.parseDouble(t1.getGrab()) < Double.parseDouble(t2
					.getGrab())) {
				return 1;
			} else if (Double.parseDouble(t1.getGrab()) == Double
					.parseDouble(t2.getGrab())) {
				return 0;
			}
			return -1;
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	class sortByThreeehit implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			PlayerDataStatistics t1 = (PlayerDataStatistics) o1;
			PlayerDataStatistics t2 = (PlayerDataStatistics) o2;
			if (Double.parseDouble(t1.getThreeHit()) < Double.parseDouble(t2
					.getThreeHit())) {
				return 1;
			} else if (Double.parseDouble(t1.getThreeHit()) == Double
					.parseDouble(t2.getThreeHit())) {
				return 0;
			}
			return -1;
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	class sortByBlock implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			PlayerDataStatistics t1 = (PlayerDataStatistics) o1;
			PlayerDataStatistics t2 = (PlayerDataStatistics) o2;
			if (Double.parseDouble(t1.getBlock()) < Double.parseDouble(t2
					.getBlock())) {
				return 1;
			} else if (Double.parseDouble(t1.getBlock()) == Double
					.parseDouble(t2.getBlock())) {
				return 0;
			}
			return -1;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataStatistics> getPlayerScoreRankingOffList(
			String seasonId) {
		List<PlayerDataStatistics> scoreList = getAllDataStatistics(seasonId,"1");
		Collections.sort(scoreList,new sortByScore());
		List<PlayerDataStatistics> Topten = new ArrayList<PlayerDataStatistics>(); 
		for (int i = 0; i < 3; i++) {
			Topten.add(scoreList.get(i));
		}
		return Topten;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataStatistics> getPlayerReboundRankingOffList(
			String seasonId) {
		List<PlayerDataStatistics> reboundList = getAllDataStatistics(seasonId,"1");
		Collections.sort(reboundList,new sortByRebound());
		List<PlayerDataStatistics> Topten = new ArrayList<PlayerDataStatistics>(); 
		for (int i = 0; i < 3; i++) {
			Topten.add(reboundList.get(i));
		}
		return Topten;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataStatistics> getPlayerAssistanceRankingOffList(
			String seasonId) {
		List<PlayerDataStatistics> assistanceList = getAllDataStatistics(seasonId,"1");
		Collections.sort(assistanceList,new sortByAssistance());
		List<PlayerDataStatistics> Topten = new ArrayList<PlayerDataStatistics>(); 
		for (int i = 0; i < 3; i++) {
			Topten.add(assistanceList.get(i));
		}
		return Topten;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataStatistics> getPlayerGrabRankingOffList(
			String seasonId) {
		List<PlayerDataStatistics> grabList = getAllDataStatistics(seasonId,"1");
		Collections.sort(grabList,new sortByGrab());
		List<PlayerDataStatistics> Topten = new ArrayList<PlayerDataStatistics>(); 
		for (int i = 0; i < 3; i++) {
			Topten.add(grabList.get(i));
		}
		return Topten;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataStatistics> getPlayerThreehitRankingOffList(
			String seasonId) {
		List<PlayerDataStatistics> threehitList = getAllDataStatistics(seasonId,"1");
		Collections.sort(threehitList,new sortByThreeehit());
		List<PlayerDataStatistics> Topten = new ArrayList<PlayerDataStatistics>(); 
		for (int i = 0; i < 3; i++) {
			Topten.add(threehitList.get(i));
		}
		return Topten;
	}

	@SuppressWarnings("unchecked")
	public List<PlayerDataStatistics> getPlayerBlockRankingOffList(
			String seasonId) {
		List<PlayerDataStatistics> blockList = getAllDataStatistics(seasonId,"1");
		Collections.sort(blockList,new sortByBlock());
		List<PlayerDataStatistics> Topten = new ArrayList<PlayerDataStatistics>(); 
		for (int i = 0; i < 3; i++) {
			Topten.add(blockList.get(i));
		}
		return Topten;
	}

	@SuppressWarnings("unchecked")
	public List<Player> searchPlayer(String name) {
		String value="%"+name+"%";
		return (List<Player>)generalDao.findList("from edu.nju.nba.bean.Player p where p.cName like ?", value);
	}

	@SuppressWarnings("unchecked")
	public List<PlayerSingleGame> getPlayerSingleGameByName(String cName) {
		return (List<PlayerSingleGame>)generalDao.findList("from edu.nju.nba.bean.PlayerSingleGame p where p.player=?", cName);
	}

	@SuppressWarnings("unchecked")
	public List<PlayerCareerHigh> getPlayerCareerHighList(String playerName) {	
		String value="%"+playerName+"%";
		return (List<PlayerCareerHigh>)generalDao.findList("from edu.nju.nba.bean.PlayerCareerHigh p where p.playerName like ?", value);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataAnalysis> getPlayerTruePercentRanking(String seasonId) {
		List<PlayerDataAnalysis> TruePercentageList = getAllDataAnalysis(seasonId,"0");
		Collections.sort(TruePercentageList,new sortByTruePercent());
		List<PlayerDataAnalysis> TopThreee = new ArrayList<PlayerDataAnalysis>(); 
		for (int i = 0; i < 3; i++) {
			TopThreee.add(TruePercentageList.get(i));
		}
		return TopThreee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataAnalysis> getPlayerShootEfficiencyRanking(
			String seasonId) {
		List<PlayerDataAnalysis> ShootEfficiencyList = getAllDataAnalysis(seasonId,"0");
		Collections.sort(ShootEfficiencyList,new sortByShootEfficiency());
		List<PlayerDataAnalysis> TopThreee = new ArrayList<PlayerDataAnalysis>(); 
		for (int i = 0; i < 3; i++) {
			TopThreee.add(ShootEfficiencyList.get(i));
		}
		return TopThreee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataAnalysis> getPlayerReboundPercentRanking(
			String seasonId) {
		List<PlayerDataAnalysis> ReboundPercentList = getAllDataAnalysis(seasonId,"0");
		Collections.sort(ReboundPercentList,new sortByReboundPercent());
		List<PlayerDataAnalysis> TopThreee = new ArrayList<PlayerDataAnalysis>(); 
		for (int i = 0; i < 3; i++) {
			TopThreee.add(ReboundPercentList.get(i));
		}
		return TopThreee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataAnalysis> getPlayerAssistancePercentRanking(
			String seasonId) {
		List<PlayerDataAnalysis> AssistancePercentList = getAllDataAnalysis(seasonId,"0");
		Collections.sort(AssistancePercentList,new sortByAssistancePercent());
		List<PlayerDataAnalysis> TopThreee = new ArrayList<PlayerDataAnalysis>(); 
		for (int i = 0; i < 3; i++) {
			TopThreee.add(AssistancePercentList.get(i));
		}
		return TopThreee;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataAnalysis> getPlayerGrabPercentRanking(String seasonId) {
		List<PlayerDataAnalysis> GrabPercentList = getAllDataAnalysis(seasonId,"0");
		Collections.sort(GrabPercentList,new sortByGrabPercent());
		List<PlayerDataAnalysis> TopThreee = new ArrayList<PlayerDataAnalysis>(); 
		for (int i = 0; i < 3; i++) {
			TopThreee.add(GrabPercentList.get(i));
		}
		return TopThreee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataAnalysis> getPlayerBlockPercentRanking(String seasonId) {
		List<PlayerDataAnalysis> BlockPercentList = getAllDataAnalysis(seasonId,"0");
		Collections.sort(BlockPercentList,new sortByBlockPercent());
		List<PlayerDataAnalysis> TopThreee = new ArrayList<PlayerDataAnalysis>(); 
		for (int i = 0; i < 3; i++) {
			TopThreee.add(BlockPercentList.get(i));
		}
		return TopThreee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataAnalysis> getPlayerTruePercentOffRanking(
			String seasonId) {
		List<PlayerDataAnalysis> TruePercentageList = getAllDataAnalysis(seasonId,"1");
		Collections.sort(TruePercentageList,new sortByTruePercent());
		List<PlayerDataAnalysis> TopThreee = new ArrayList<PlayerDataAnalysis>(); 
		for (int i = 0; i < 3; i++) {
			TopThreee.add(TruePercentageList.get(i));
		}
		return TopThreee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataAnalysis> getPlayerShootEfficiencyOffRanking(
			String seasonId) {
		List<PlayerDataAnalysis> ShootEfficiencyList = getAllDataAnalysis(seasonId,"1");
		Collections.sort(ShootEfficiencyList,new sortByShootEfficiency());
		List<PlayerDataAnalysis> TopThreee = new ArrayList<PlayerDataAnalysis>(); 
		for (int i = 0; i < 3; i++) {
			TopThreee.add(ShootEfficiencyList.get(i));
		}
		return TopThreee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataAnalysis> getPlayerReboundPercentOffRanking(
			String seasonId) {
		List<PlayerDataAnalysis> ReboundPercentList = getAllDataAnalysis(seasonId,"1");
		Collections.sort(ReboundPercentList,new sortByReboundPercent());
		List<PlayerDataAnalysis> TopThreee = new ArrayList<PlayerDataAnalysis>(); 
		for (int i = 0; i < 3; i++) {
			TopThreee.add(ReboundPercentList.get(i));
		}
		return TopThreee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataAnalysis> getPlayerAssistancePercentOffRanking(
			String seasonId) {
		List<PlayerDataAnalysis> AssistancePercentList = getAllDataAnalysis(seasonId,"1");
		Collections.sort(AssistancePercentList,new sortByAssistancePercent());
		List<PlayerDataAnalysis> TopThreee = new ArrayList<PlayerDataAnalysis>(); 
		for (int i = 0; i < 3; i++) {
			TopThreee.add(AssistancePercentList.get(i));
		}
		return TopThreee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataAnalysis> getPlayerGrabPercentOffRanking(
			String seasonId) {
		List<PlayerDataAnalysis> GrabPercentList = getAllDataAnalysis(seasonId,"1");
		Collections.sort(GrabPercentList,new sortByGrabPercent());
		List<PlayerDataAnalysis> TopThreee = new ArrayList<PlayerDataAnalysis>(); 
		for (int i = 0; i < 3; i++) {
			TopThreee.add(GrabPercentList.get(i));
		}
		return TopThreee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataAnalysis> getPlayerBlockPercentOffRanking(
			String seasonId) {
		List<PlayerDataAnalysis> BlockPercentList = getAllDataAnalysis(seasonId,"1");
		Collections.sort(BlockPercentList,new sortByBlockPercent());
		List<PlayerDataAnalysis> TopThreee = new ArrayList<PlayerDataAnalysis>(); 
		for (int i = 0; i < 3; i++) {
			TopThreee.add(BlockPercentList.get(i));
		}
		return TopThreee;
	}

	@SuppressWarnings("rawtypes")
	class sortByTruePercent implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			PlayerDataAnalysis t1 = (PlayerDataAnalysis) o1;
			PlayerDataAnalysis t2 = (PlayerDataAnalysis) o2;
			if (Double.parseDouble(t1.getTruePercentage().replace("%", "")) < Double.parseDouble(t2
					.getTruePercentage().replace("%", ""))) {
				return 1;
			} else if (Double.parseDouble(t1.getTruePercentage().replace("%", "")) == Double
					.parseDouble(t2.getTruePercentage().replace("%", ""))) {
				return 0;
			}
			return -1;
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	class sortByShootEfficiency implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			PlayerDataAnalysis t1 = (PlayerDataAnalysis) o1;
			PlayerDataAnalysis t2 = (PlayerDataAnalysis) o2;
			if (Double.parseDouble(t1.getShootEfficiency().replace("%", "")) < Double.parseDouble(t2
					.getShootEfficiency().replace("%", ""))) {
				return 1;
			} else if (Double.parseDouble(t1.getShootEfficiency().replace("%", "")) == Double
					.parseDouble(t2.getShootEfficiency().replace("%", ""))) {
				return 0;
			}
			return -1;
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	class sortByReboundPercent implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			PlayerDataAnalysis t1 = (PlayerDataAnalysis) o1;
			PlayerDataAnalysis t2 = (PlayerDataAnalysis) o2;
			if (Double.parseDouble(t1.getReboundPercent().replace("%", "")) < Double.parseDouble(t2
					.getReboundPercent().replace("%", ""))) {
				return 1;
			} else if (Double.parseDouble(t1.getReboundPercent().replace("%", "")) == Double
					.parseDouble(t2.getReboundPercent().replace("%", ""))) {
				return 0;
			}
			return -1;
		}
		
	}

	@SuppressWarnings("rawtypes")
	class sortByAssistancePercent implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			PlayerDataAnalysis t1 = (PlayerDataAnalysis) o1;
			PlayerDataAnalysis t2 = (PlayerDataAnalysis) o2;
			if (Double.parseDouble(t1.getAssistancePercent().replace("%", "")) < Double.parseDouble(t2
					.getAssistancePercent().replace("%", ""))) {
				return 1;
			} else if (Double.parseDouble(t1.getAssistancePercent().replace("%", "")) == Double
					.parseDouble(t2.getAssistancePercent().replace("%", ""))) {
				return 0;
			}
			return -1;
		}
		
	}

	@SuppressWarnings("rawtypes")
	class sortByGrabPercent implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			PlayerDataAnalysis t1 = (PlayerDataAnalysis) o1;
			PlayerDataAnalysis t2 = (PlayerDataAnalysis) o2;
			if (Double.parseDouble(t1.getGrabPercent().replace("%", "")) < Double.parseDouble(t2
					.getGrabPercent().replace("%", ""))) {
				return 1;
			} else if (Double.parseDouble(t1.getGrabPercent().replace("%", "")) == Double
					.parseDouble(t2.getGrabPercent().replace("%", ""))) {
				return 0;
			}
			return -1;
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	class sortByBlockPercent implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			PlayerDataAnalysis t1 = (PlayerDataAnalysis) o1;
			PlayerDataAnalysis t2 = (PlayerDataAnalysis) o2;
			if (Double.parseDouble(t1.getBlockPercent().replace("%", "")) < Double.parseDouble(t2
					.getBlockPercent().replace("%", ""))) {
				return 1;
			} else if (Double.parseDouble(t1.getBlockPercent().replace("%", "")) == Double
					.parseDouble(t2.getBlockPercent().replace("%", ""))) {
				return 0;
			}
			return -1;
		}
		
	}



}
