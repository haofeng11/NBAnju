package edu.nju.nba.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.nju.nba.bean.Game;
import edu.nju.nba.bean.Player;
import edu.nju.nba.bean.PlayerDataAnalysis;
import edu.nju.nba.bean.PlayerDataStatistics;
import edu.nju.nba.bean.PlayerSingleGame;
import edu.nju.nba.service.IGameService;
import edu.nju.nba.service.IPlayerService;

@Controller
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	private IPlayerService playerService;
	@Autowired
	private IGameService gameService;

	// 场均得分联盟排名
	int scoreRanking;
	// 场均助攻联盟排名
	int assistanceRanking;
	// 场均篮板联盟排名
	int reboundRanking;
	// 场均抢断联盟排名
	int grabRanking;
	// 场均盖帽联盟排名
	int blockRanking;
	// 场均失误联盟排名
	int mistakeRanking;
	// 场均命中率联盟排名
	int shootPercentageRanking;
	// 场均三分命中率联盟排名
	int threePercentageRanking;
	// 场均罚球命中率联盟排名
	int freeThrowPercentageRanking;

	private List<Player> players = new ArrayList<Player>();

	public PlayerController() {

	}

	/*
	 * 得到所有球员基本信息
	 */
	@RequestMapping(value = "/players", method = RequestMethod.GET)
	public String list(Model model) {
		System.out.println("test");
		players = playerService.list();
		for (int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).toString());
		}
		model.addAttribute("players", players);
		return "/players.jsp";
	}

	/*
	 * 根据球员姓名查找球员 return 球员信息 PS：球员姓名唯一
	 */
	@RequestMapping(value = "/{playerName}", method = RequestMethod.GET)
	public String show(@PathVariable String playerName, Model model) {

		// 球员基本信息
		// 根据球员的中文名字
		Player player = playerService.show(playerName);
		model.addAttribute("player", player);

		// 球员赛季常规赛场均基本数据
		PlayerDataStatistics playerDataStatistics14 = playerService
				.getDataStatistics("14-15", playerName, "0");
		List<PlayerDataStatistics> playerDataStatisticsList = playerService
				.getAllDataStatistics("14-15", "0");

		// 得到球员场均数据排名
		// 场均得分联盟排名
		scoreRanking = getScoreRanking(playerDataStatistics14,playerDataStatisticsList);
		model.addAttribute("scoreRanking", scoreRanking);
		// 场均助攻联盟排名
		assistanceRanking = getAssistanceRanking(playerDataStatistics14, playerDataStatisticsList);
		model.addAttribute("assistanceRanking", assistanceRanking);
		// 场均篮板联盟排名
		reboundRanking = getReboundRanking(playerDataStatistics14, playerDataStatisticsList);
		model.addAttribute("reboundRanking", reboundRanking);
		// 场均抢断联盟排名
		grabRanking = getGrabRanking(playerDataStatistics14, playerDataStatisticsList);
		model.addAttribute("grabRanking", grabRanking);
		// 场均盖帽联盟排名
		blockRanking = getBlockRanking(playerDataStatistics14, playerDataStatisticsList);
		model.addAttribute("blockRanking", blockRanking);
		// 场均失误联盟排名
		mistakeRanking = getMistakeRanking(playerDataStatistics14, playerDataStatisticsList);
		model.addAttribute("mistakeRanking", mistakeRanking);
		// 场均命中率联盟排名
		shootPercentageRanking=getShootPercentageRanking(playerDataStatistics14, playerDataStatisticsList);
		model.addAttribute("shootPercentageRanking", shootPercentageRanking);
		// 场均三分命中率联盟排名
		threePercentageRanking=getThreePercentageRanking(playerDataStatistics14, playerDataStatisticsList);
		model.addAttribute("threePercentageRanking", threePercentageRanking);
		// 场均罚球命中率联盟排名
		freeThrowPercentageRanking=getThreePercentageRanking(playerDataStatistics14, playerDataStatisticsList);
		model.addAttribute("freeThrowPercentageRanking", freeThrowPercentageRanking);
		
		System.out.println(playerDataStatistics14.toString());
		System.out.println(playerDataStatisticsList.size());
		System.out.println(scoreRanking);
		System.out.println(assistanceRanking);
		System.out.println(reboundRanking);
		System.out.println(grabRanking);
		System.out.println(blockRanking);
		System.out.println(mistakeRanking);
		System.out.println(shootPercentageRanking);
		System.out.println(threePercentageRanking);
		System.out.println(freeThrowPercentageRanking);

		// model.addAttribute("playerDataStatistics",playerDataStatistics);
		// 球员赛季场均分析数据
		// PlayerDataAnalysis
		// playerDataAnalysis=playerService.getDataAnalysis("14-15",
		// playerName);
		// model.addAttribute("playerDataAnalysis",playerDataAnalysis);

		// 进攻能力分析：真实命中率，投篮效率，进攻篮板率，使用率，进攻效率、失误率
		// 防守能力分析：防守篮板率、抢断率、盖帽率、防守效率
		// 策应能力分析：助攻率、助攻失误比
		// 综合能力分析：WS，PER，进攻能力、防守能力、策应能力

		return "PlayerInfo";
	}
	
	//球员数据对比
	@RequestMapping(value = "/{firstName}/{secondName}", method = RequestMethod.GET)
	public String compare(@PathVariable String firstName,@PathVariable String secondName,Model model){
		//球员一所有常规赛场均数据
		List<PlayerDataStatistics> dataStatisticsP1=playerService.getDataStatisticsByName(firstName, "0");
		List<PlayerDataAnalysis> dataAnalysisP1=playerService.getDataAnalysisByName(firstName, "0");
		//球员二所有常规赛场均数据
		List<PlayerDataStatistics> dataStatisticsP2=playerService.getDataStatisticsByName(secondName, "0");
		List<PlayerDataAnalysis> dataAnalysisP2=playerService.getDataAnalysisByName(secondName, "0");
		
		//球员交手数据
		//根据球员所在球队找到game数据，再根据game找到PlayerSingleGame
		Player p1=playerService.show(firstName);
		Player p2=playerService.show(secondName);
		List<Game> games=gameService.getGames(p1.getTeam(), p2.getTeam());
		List<PlayerSingleGame> playerSingleGames=new ArrayList<PlayerSingleGame>();
        for (Game g : games) {
        	playerSingleGames.add(playerService.getPlayerSingleGameByID(g.getGameID()).get(0));
        	playerSingleGames.add(playerService.getPlayerSingleGameByID(g.getGameID()).get(1));
		}
		return "comparison";
	}
	
	//计算球员生涯平均统计数据
	public Map<String,Object> careerDataStatistics(List<PlayerDataStatistics> dataStatistics){
		
		
		
		for (PlayerDataStatistics p:dataStatistics) {
						
		}
		return null;	
	}
	
	//计算球员生涯平均分析数据
	public Map<String,Object> careerDataAnalysis(){
		return null;		
	}
	
	//得到球队阵容
	public String team(String teamName,Model model){
		List<PlayerDataStatistics> PD=playerService.findTeam(teamName, "14-15", "0");
		List<Player> playerList=new ArrayList<Player>();
		for (PlayerDataStatistics p : PD) {
			playerList.add(playerService.show(p.getPlayer()));
		}
		model.addAttribute("playerList", playerList);
		return null;		
	}
	
	

	// 场均得分联盟排名
	@SuppressWarnings("unchecked")
	private int getScoreRanking(PlayerDataStatistics playerDataStatistics,
			List<PlayerDataStatistics> playerDataStatisticsList) {
		Collections.sort(playerDataStatisticsList, new sortByScore());
		int scoreRanking = 0;
		for (PlayerDataStatistics p : playerDataStatisticsList) {
			if (p.getPlayer().equals(playerDataStatistics.getPlayer())) {
				scoreRanking = (playerDataStatisticsList.indexOf(p) + 1);
			}
		}
		return scoreRanking;
	}

	// 场均助攻联盟排名
	@SuppressWarnings("unchecked")
	private int getAssistanceRanking(PlayerDataStatistics playerDataStatistics,
			List<PlayerDataStatistics> playerDataStatisticsList) {
		Collections.sort(playerDataStatisticsList, new sortByAssistance());
		int assistanceRanking = 0;
		for (PlayerDataStatistics p : playerDataStatisticsList) {
			if (p.getPlayer().equals(playerDataStatistics.getPlayer())) {
				assistanceRanking = (playerDataStatisticsList.indexOf(p) + 1);
			}
		}
		return assistanceRanking;
	}

	// 场均篮板联盟排名
	@SuppressWarnings("unchecked")
	private int getReboundRanking(PlayerDataStatistics playerDataStatistics,
			List<PlayerDataStatistics> playerDataStatisticsList) {
		Collections.sort(playerDataStatisticsList, new sortByRebound());
		int reboundRanking = 0;
		for (PlayerDataStatistics p : playerDataStatisticsList) {
			if (p.getPlayer().equals(playerDataStatistics.getPlayer())) {
				reboundRanking = (playerDataStatisticsList.indexOf(p) + 1);
			}
		}
		return reboundRanking;
	}

	// 场均抢断联盟排名
	@SuppressWarnings("unchecked")
	private int getGrabRanking(PlayerDataStatistics playerDataStatistics,
			List<PlayerDataStatistics> playerDataStatisticsList) {
		Collections.sort(playerDataStatisticsList, new sortByGrab());
		int grabRanking = 0;
		for (PlayerDataStatistics p : playerDataStatisticsList) {
			if (p.getPlayer().equals(playerDataStatistics.getPlayer())) {
				grabRanking = (playerDataStatisticsList.indexOf(p) + 1);
			}
		}
		return grabRanking;
	}

	// 场均盖帽联盟排名
	@SuppressWarnings("unchecked")
	private int getBlockRanking(PlayerDataStatistics playerDataStatistics,
			List<PlayerDataStatistics> playerDataStatisticsList) {
		Collections.sort(playerDataStatisticsList, new sortByBlock());
		int blockRanking = 0;
		for (PlayerDataStatistics p : playerDataStatisticsList) {
			if (p.getPlayer().equals(playerDataStatistics.getPlayer())) {
				blockRanking = (playerDataStatisticsList.indexOf(p) + 1);
			}
		}
		return blockRanking;
	}

	// 场均失误联盟排名
	@SuppressWarnings("unchecked")
	private int getMistakeRanking(PlayerDataStatistics playerDataStatistics,
			List<PlayerDataStatistics> playerDataStatisticsList) {
		Collections.sort(playerDataStatisticsList, new sortByMistake());
		int mistakeRanking = 0;
		for (PlayerDataStatistics p : playerDataStatisticsList) {
			if (p.getPlayer().equals(playerDataStatistics.getPlayer())) {
				mistakeRanking = (playerDataStatisticsList.indexOf(p) + 1);
			}
		}
		return mistakeRanking;
	}

	// 场均命中率联盟排名
	@SuppressWarnings("unchecked")
	private int getShootPercentageRanking(
			PlayerDataStatistics playerDataStatistics,
			List<PlayerDataStatistics> playerDataStatisticsList) {
		Collections.sort(playerDataStatisticsList, new sortByShootPercentage());
		int shootPercentageRanking = 0;
		for (PlayerDataStatistics p : playerDataStatisticsList) {
			if (p.getPlayer().equals(playerDataStatistics.getPlayer())) {
				shootPercentageRanking = (playerDataStatisticsList.indexOf(p) + 1);
			}
		}
		return shootPercentageRanking;
	}

	// 场均三分命中率联盟排名
	@SuppressWarnings("unchecked")
	private int getThreePercentageRanking(
			PlayerDataStatistics playerDataStatistics,
			List<PlayerDataStatistics> playerDataStatisticsList) {
		Collections.sort(playerDataStatisticsList, new sortByThreePercentage());
		int threePercentageRanking = 0;
		for (PlayerDataStatistics p : playerDataStatisticsList) {
			if (p.getPlayer().equals(playerDataStatistics.getPlayer())) {
				threePercentageRanking = (playerDataStatisticsList.indexOf(p) + 1);
			}
		}
		return threePercentageRanking;
	}

	// 场均罚球命中率联盟排名
	@SuppressWarnings("unchecked")
	private int getFreeThrowPercentageRanking(
			PlayerDataStatistics playerDataStatistics,
			List<PlayerDataStatistics> playerDataStatisticsList) {
		Collections.sort(playerDataStatisticsList,
				new sortByFreeThrowPercentage());
		int freeThrowPercentageRanking = 0;
		for (PlayerDataStatistics p : playerDataStatisticsList) {
			if (p.getPlayer().equals(playerDataStatistics.getPlayer())) {
				freeThrowPercentageRanking = (playerDataStatisticsList
						.indexOf(p) + 1);
			}
		}
		return freeThrowPercentageRanking;
	}

	// 场均得分排序
	@SuppressWarnings("rawtypes")
	class sortByScore implements Comparator {

		public int compare(Object o1, Object o2) {
			PlayerDataStatistics p1 = (PlayerDataStatistics) o1;
			PlayerDataStatistics p2 = (PlayerDataStatistics) o2;
			if (Double.parseDouble(p1.getScore()) < Double.parseDouble(p2
					.getScore())) {
				return 1;
			} else if (Double.parseDouble(p1.getScore()) == Double
					.parseDouble(p2.getScore())) {
				return 0;
			}
			return -1;
		}

	}

	// 场均助攻排序
	@SuppressWarnings("rawtypes")
	class sortByAssistance implements Comparator {

		public int compare(Object o1, Object o2) {
			PlayerDataStatistics p1 = (PlayerDataStatistics) o1;
			PlayerDataStatistics p2 = (PlayerDataStatistics) o2;
			if (Double.parseDouble(p1.getAssistance()) < Double.parseDouble(p2
					.getAssistance())) {
				return 1;
			} else if (Double.parseDouble(p1.getAssistance()) == Double
					.parseDouble(p2.getAssistance())) {
				return 0;
			}
			return -1;
		}

	}

	// 场均篮板排序
	@SuppressWarnings("rawtypes")
	class sortByRebound implements Comparator {

		public int compare(Object o1, Object o2) {
			PlayerDataStatistics p1 = (PlayerDataStatistics) o1;
			PlayerDataStatistics p2 = (PlayerDataStatistics) o2;
			if (Double.parseDouble(p1.getRebound()) < Double.parseDouble(p2
					.getRebound())) {
				return 1;
			} else if (Double.parseDouble(p1.getRebound()) == Double
					.parseDouble(p2.getRebound())) {
				return 0;
			}
			return -1;
		}

	}

	// 场均抢断排序
	@SuppressWarnings("rawtypes")
	class sortByGrab implements Comparator {

		public int compare(Object o1, Object o2) {
			PlayerDataStatistics p1 = (PlayerDataStatistics) o1;
			PlayerDataStatistics p2 = (PlayerDataStatistics) o2;
			if (Double.parseDouble(p1.getGrab()) < Double.parseDouble(p2
					.getGrab())) {
				return 1;
			} else if (Double.parseDouble(p1.getGrab()) == Double
					.parseDouble(p2.getGrab())) {
				return 0;
			}
			return -1;
		}

	}

	// 场均盖帽排序
	@SuppressWarnings("rawtypes")
	class sortByBlock implements Comparator {

		public int compare(Object o1, Object o2) {
			PlayerDataStatistics p1 = (PlayerDataStatistics) o1;
			PlayerDataStatistics p2 = (PlayerDataStatistics) o2;
			if (Double.parseDouble(p1.getBlock()) < Double.parseDouble(p2
					.getBlock())) {
				return 1;
			} else if (Double.parseDouble(p1.getBlock()) == Double
					.parseDouble(p2.getBlock())) {
				return 0;
			}
			return -1;
		}

	}

	// 场均失误排序
	@SuppressWarnings("rawtypes")
	class sortByMistake implements Comparator {

		public int compare(Object o1, Object o2) {
			PlayerDataStatistics p1 = (PlayerDataStatistics) o1;
			PlayerDataStatistics p2 = (PlayerDataStatistics) o2;
			if (Double.parseDouble(p1.getMistake()) < Double.parseDouble(p2
					.getMistake())) {
				return 1;
			} else if (Double.parseDouble(p1.getMistake()) == Double
					.parseDouble(p2.getMistake())) {
				return 0;
			}
			return -1;
		}

	}

	// 场均命中率排序
	@SuppressWarnings("rawtypes")
	class sortByShootPercentage implements Comparator {

		public int compare(Object o1, Object o2) {
			PlayerDataStatistics p1 = (PlayerDataStatistics) o1;
			PlayerDataStatistics p2 = (PlayerDataStatistics) o2;
			if (Double.parseDouble(p1.getShootPercentage().replace("%", "")) < Double
					.parseDouble(p2.getShootPercentage().replace("%", ""))) {
				return 1;
			} else if (Double.parseDouble(p1.getShootPercentage().replace("%",
					"")) == Double.parseDouble(p2.getShootPercentage().replace(
					"%", ""))) {
				return 0;
			}
			return -1;
		}

	}

	// 场均三分命中率排序
	@SuppressWarnings("rawtypes")
	class sortByThreePercentage implements Comparator {

		public int compare(Object o1, Object o2) {
			PlayerDataStatistics p1 = (PlayerDataStatistics) o1;
			PlayerDataStatistics p2 = (PlayerDataStatistics) o2;
			if (Double.parseDouble(p1.getThreePercentage().replace("%", "")) < Double
					.parseDouble(p2.getThreePercentage().replace("%", ""))) {
				return 1;
			} else if (Double.parseDouble(p1.getThreePercentage().replace("%",
					"")) == Double.parseDouble(p2.getThreePercentage().replace(
					"%", ""))) {
				return 0;
			}
			return -1;
		}

	}

	// 场均罚球命中率排序
	@SuppressWarnings("rawtypes")
	class sortByFreeThrowPercentage implements Comparator {

		public int compare(Object o1, Object o2) {
			PlayerDataStatistics p1 = (PlayerDataStatistics) o1;
			PlayerDataStatistics p2 = (PlayerDataStatistics) o2;
			if (Double
					.parseDouble(p1.getFreeThrowPercentage().replace("%", "")) < Double
					.parseDouble(p2.getFreeThrowPercentage().replace("%", ""))) {
				return 1;
			} else if (Double.parseDouble(p1.getFreeThrowPercentage().replace(
					"%", "")) == Double.parseDouble(p2.getFreeThrowPercentage()
					.replace("%", ""))) {
				return 0;
			}
			return -1;
		}

	}

}
