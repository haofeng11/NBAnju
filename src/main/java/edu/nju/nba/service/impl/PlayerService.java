package edu.nju.nba.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nju.nba.bean.Player;
import edu.nju.nba.dao.IGeneralDao;
import edu.nju.nba.service.IPlayerService;

@Service
public class PlayerService implements IPlayerService{
	
	@Autowired
	private IGeneralDao generalDao;

	//根据球员姓名查找球员，返回球员信息
	public Map<String,Player> show(String playername) {
		return null;
	}




}
