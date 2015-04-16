package edu.nju.nba.controller;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.nju.nba.bean.Player;
import edu.nju.nba.bean.PlayerDataAnalysis;
import edu.nju.nba.bean.PlayerDataStatistics;
import edu.nju.nba.service.IPlayerService;

@Controller
@RequestMapping("/player")
public class PlayerController {
	
	@Autowired
	private IPlayerService playerService;

	private List<Player> players=new ArrayList<Player>();
	
	public PlayerController() {
		
	}
	
	/*
	 * 得到所有球员基本信息
	 */
	@RequestMapping(value="/players",method=RequestMethod.GET)
	public String list(Model model){
		System.out.println("test");
		players=playerService.list();
		for (int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).toString());
		}
		model.addAttribute("players", players);
		return "/players.jsp";		
	}
	
	/*
	 * 根据球员姓名查找球员
	 * return 球员信息
	 * PS：球员姓名唯一
	 */
	@RequestMapping(value="/{playername}",method=RequestMethod.GET)
	public String show(@PathVariable String playerName,Model model){
        
	
		//球员基本信息
		//根据球员的中文名字
		Player player=playerService.show(playerName);
		model.addAttribute("player",player);
		
		//球员赛季场均基本数据
		//PlayerDataStatistics playerDataStatistics=playerService.getDataStatistics("14-15", playerName);
		//List<PlayerDataStatistics> playerDataStatisticsList=playerService.getAllDataStatistics("14-15");
		
		//model.addAttribute("playerDataStatistics",playerDataStatistics);
		//球员赛季场均分析数据
		//PlayerDataAnalysis playerDataAnalysis=playerService.getDataAnalysis("14-15", playerName);
		//model.addAttribute("playerDataAnalysis",playerDataAnalysis);
		
		// 进攻能力分析：真实命中率，投篮效率，进攻篮板率，使用率，进攻效率、失误率
		// 防守能力分析：防守篮板率、抢断率、盖帽率、防守效率
		// 策应能力分析：助攻率、助攻失误比
		// 综合能力分析：WS，PER，进攻能力、防守能力、策应能力
		
		return "PlayerInfo";
	}
	

	
	

}
