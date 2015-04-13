package edu.nju.nba.service.impl;


import java.util.List;









import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		return (Player)generalDao.find("from edu.nju.nba.bean.Player where p.cName=?", playerName);
	}

	// 查找所有球员基本信息
	public List<Player> list() {
		return generalDao.findAll(Player.class);
	}

	// 添加一名球员
	@Transactional(readOnly = false)
	public boolean addPlayer(Player player) {
		generalDao.save(player);
		return true;
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
			String playerName) {
		// TODO Auto-generated method stub
		return null;
	}

	public PlayerDataAnalysis getDataAnalysis(String seasonID, String playerName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PlayerDataStatistics> getAllDataStatistics(String seasonID) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PlayerDataAnalysis> getAllDataAnalysis(String seasonID) {
		// TODO Auto-generated method stub
		return null;
	}

}
