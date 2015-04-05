package edu.nju.nba.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.nju.nba.bean.Player;
import edu.nju.nba.service.IPlayerService;

@Controller
@RequestMapping("/player")
public class PlayerController {
	
	@Autowired
	private IPlayerService playerService;

	//private Map<String, Player> players=new HashMap<String, Player>();
	private List<Player> players=new ArrayList<Player>();
	
	public PlayerController() {
		//测试，手动添加数据
		System.out.println("初始化......");
		//players.put("科比", new Player(1, "科比", "1978-08-23", "1.98米 / 6尺6", "96公斤 / 212磅", "洛杉矶湖人", "1996年第一轮第 13 顺位", "美国", "G/F ( 24号 )", " 2350万美元", " 2年4860万, 2013/11/25续签, 2014夏生效,2016年到期★合同包括15%交易保证金★拥有不可交易条款", " NBA最有价值球员、两届NBA总决赛最有价值球员、四届NBA全明星赛最有价值球员、五届NBA总冠军"));
		//players.put("麦迪", new Player(1, "麦迪", "1978-08-23", "1.98米 / 6尺6", "96公斤 / 212磅", "洛杉矶湖人", "1996年第一轮第 13 顺位", "美国", "G/F ( 24号 )", " 2350万美元", " 2年4860万, 2013/11/25续签, 2014夏生效,2016年到期★合同包括15%交易保证金★拥有不可交易条款", " NBA最有价值球员、两届NBA总决赛最有价值球员、四届NBA全明星赛最有价值球员、五届NBA总冠军"));
		//players.put("乔丹", new Player(1, "乔丹", "1978-08-23", "1.98米 / 6尺6", "96公斤 / 212磅", "洛杉矶湖人", "1996年第一轮第 13 顺位", "美国", "G/F ( 24号 )", " 2350万美元", " 2年4860万, 2013/11/25续签, 2014夏生效,2016年到期★合同包括15%交易保证金★拥有不可交易条款", " NBA最有价值球员、两届NBA总决赛最有价值球员、四届NBA全明星赛最有价值球员、五届NBA总冠军"));
		//players.put("邓肯", new Player(1, "邓肯", "1978-08-23", "1.98米 / 6尺6", "96公斤 / 212磅", "洛杉矶湖人", "1996年第一轮第 13 顺位", "美国", "G/F ( 24号 )", " 2350万美元", " 2年4860万, 2013/11/25续签, 2014夏生效,2016年到期★合同包括15%交易保证金★拥有不可交易条款", " NBA最有价值球员、两届NBA总决赛最有价值球员、四届NBA全明星赛最有价值球员、五届NBA总冠军"));

		//加载数据库数据到players中
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
	public String show(@PathVariable String playername,Model model){
        
	
		//实际调用playerService方法
		//Player player=playerService.show(playername);
		//System.out.println(player.toString());
		//model.addAttribute(player);
		return "";
	}
	
	//添加一名球员
	public String add(){
		Player p=new Player(1, "科比", "1978-08-23", "1.98米 / 6尺6", "96公斤 / 212磅", "洛杉矶湖人", "1996年第一轮第 13 顺位", "美国", "G/F ( 24号 )", " 2350万美元", " 2年4860万, 2013/11/25续签, 2014夏生效,2016年到期★合同包括15%交易保证金★拥有不可交易条款", " NBA最有价值球员、两届NBA总决赛最有价值球员、四届NBA全明星赛最有价值球员、五届NBA总冠军");
		playerService.addPlayer(p);
		return "";
	}
	
	

}
