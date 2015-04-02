package edu.nju.nba.service.impl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.nju.nba.bean.Player;
import edu.nju.nba.dao.IGeneralDao;
import edu.nju.nba.service.IPlayerService;

@Service
public class PlayerService implements IPlayerService {

	@Autowired
	private IGeneralDao generalDao;


	// 根据球员ID查找球员，返回球员信息
	public Player show(Player player) {		
		return generalDao.findById(Player.class, player.getId());
	}

	// 查找所有球员基本信息
	public List<Player> list() {
		return generalDao.findAll(Player.class);
	}

	// 添加一名球员
	@Transactional(readOnly = false)
	public boolean add(Player player) {
		generalDao.save(player);
		return true;
	}

}
