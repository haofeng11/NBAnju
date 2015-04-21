package edu.nju.nba.service.impl;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;












import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nju.nba.bean.Player;
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
		return (List<PlayerDataStatistics>)generalDao.find3("from edu.nju.nba.bean.PlayerDataStatistics p where p.seasonID=? and p.team=? and p.tag=?", seasonID, teamName, tag);
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
		return scoreList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataStatistics> getPlayerReboundRankingList(
			String seasonId) {
		List<PlayerDataStatistics> reboundList = getAllDataStatistics(seasonId,"0");
		Collections.sort(reboundList,new sortByRebound());
		return reboundList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataStatistics> getPlayerAssistanceRankingList(
			String seasonId) {
		List<PlayerDataStatistics> assistanceList = getAllDataStatistics(seasonId,"0");
		Collections.sort(assistanceList,new sortByAssistance());
		return assistanceList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataStatistics> getPlayerGrabRankingList(String seasonId) {
		List<PlayerDataStatistics> grabList = getAllDataStatistics(seasonId,"0");
		Collections.sort(grabList,new sortByGrab());
		return grabList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataStatistics> getPlayerThreehitRankingList(
			String seasonId) {
		List<PlayerDataStatistics> threehitList = getAllDataStatistics(seasonId,"0");
		Collections.sort(threehitList,new sortByThreeehit());
		return threehitList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerDataStatistics> getPlayerBlockRankingList(String seasonId) {
		List<PlayerDataStatistics> blockList = getAllDataStatistics(seasonId,"0");
		Collections.sort(blockList,new sortByBlock());
		return blockList;
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





}
