package edu.nju.nba.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.nju.nba.bean.Game;
import edu.nju.nba.bean.Player;
import edu.nju.nba.bean.PlayerCareerHigh;
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
	
	List<PlayerSingleGame> playerSingleGamesP1 = new ArrayList<PlayerSingleGame>();
	List<PlayerSingleGame> playerSingleGamesP2 = new ArrayList<PlayerSingleGame>();

	public PlayerController() {

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
		model.addAttribute("playerDataStatistics14", playerDataStatistics14);
		List<PlayerDataStatistics> playerDataStatisticsList = playerService
				.getAllDataStatistics("14-15", "0");

		// 得到球员场均数据排名
		// 场均得分联盟排名
		scoreRanking = getScoreRanking(playerDataStatistics14,
				playerDataStatisticsList);
		model.addAttribute("scoreRanking", scoreRanking);
		// 场均助攻联盟排名
		assistanceRanking = getAssistanceRanking(playerDataStatistics14,
				playerDataStatisticsList);
		model.addAttribute("assistanceRanking", assistanceRanking);
		// 场均篮板联盟排名
		reboundRanking = getReboundRanking(playerDataStatistics14,
				playerDataStatisticsList);
		model.addAttribute("reboundRanking", reboundRanking);
		// 场均抢断联盟排名
		grabRanking = getGrabRanking(playerDataStatistics14,
				playerDataStatisticsList);
		model.addAttribute("grabRanking", grabRanking);
		// 场均盖帽联盟排名
		blockRanking = getBlockRanking(playerDataStatistics14,
				playerDataStatisticsList);
		model.addAttribute("blockRanking", blockRanking);
		// 场均失误联盟排名
		mistakeRanking = getMistakeRanking(playerDataStatistics14,
				playerDataStatisticsList);
		model.addAttribute("mistakeRanking", mistakeRanking);
		// 场均命中率联盟排名
		shootPercentageRanking = getShootPercentageRanking(
				playerDataStatistics14, playerDataStatisticsList);
		model.addAttribute("shootPercentageRanking", shootPercentageRanking);
		// 场均三分命中率联盟排名
		threePercentageRanking = getThreePercentageRanking(
				playerDataStatistics14, playerDataStatisticsList);
		model.addAttribute("threePercentageRanking", threePercentageRanking);
		// 场均罚球命中率联盟排名
		freeThrowPercentageRanking = getFreeThrowPercentageRanking(
				playerDataStatistics14, playerDataStatisticsList);
		model.addAttribute("freeThrowPercentageRanking",
				freeThrowPercentageRanking);

		// 球员生涯表现
		List<PlayerDataStatistics> list = playerService
				.getDataStatisticsByName(playerName, "0");
		List<PlayerDataStatistics> dataStatistics=new ArrayList<PlayerDataStatistics>();
		List<PlayerDataStatistics> listPO = playerService
				.getDataStatisticsByName(playerName, "1");
		List<PlayerDataStatistics> dataStatisticsPO=new ArrayList<PlayerDataStatistics>();
		
		for(int i=list.size()-1;i>=0;i--){
			dataStatistics.add(list.get(i));
		}
		
		for(int i=listPO.size()-1;i>=0;i--){
			dataStatisticsPO.add(listPO.get(i));
		}
		
		for (PlayerDataStatistics PD : dataStatisticsPO) {
			System.out.println(PD.toString());
		}
		model.addAttribute("dataStatistics", dataStatistics);
		model.addAttribute("dataStatisticsPO", dataStatisticsPO);

		
		//球员生涯平均统计数据
		//球员生涯平均进阶数据
		 Map<String, Object> dataAverageList=careerDataStatistics(dataStatistics);
		 model.addAttribute("dataAverageList", dataAverageList);
		 
		 List<PlayerDataAnalysis> dataAnalysis=playerService.getDataAnalysisByName(playerName, "0");
		 Map<String, Object> analysisAverageList=careerDataAnalysis(dataAnalysis);
		 
		//真实命中率
		 int truePercentage=Integer.parseInt(analysisAverageList.get("truePercentageAverage").toString());
		 model.addAttribute("truePercentage", truePercentage);
		 //投篮效率
		 int shootEfficiency=Integer.parseInt(analysisAverageList.get("shootEfficiencyAverage").toString());
		 model.addAttribute("shootEfficiency", shootEfficiency);
		 //进攻篮板率
		 int offenReboundPercent=Integer.parseInt(analysisAverageList.get("offenReboundPercentAverage").toString());
		 model.addAttribute("offenReboundPercent", offenReboundPercent);
		 //使用率
		 int usePercent=Integer.parseInt(analysisAverageList.get("usePercentAverage").toString());
		 model.addAttribute("usePercent", usePercent);
		 //进攻效率
		 int offensiveEfficiency=Integer.parseInt(analysisAverageList.get("offensiveEfficiencyAverage").toString());
		 model.addAttribute("offensiveEfficiency", offensiveEfficiency);
		 //失误率
		 int mistakePercent=Integer.parseInt(analysisAverageList.get("mistakePercentAverage").toString());
		 model.addAttribute("mistakePercent", mistakePercent);
		 //防守篮板率
		 int defenReboundPercent=Integer.parseInt(analysisAverageList.get("defenReboundPercentAverage").toString());
		 model.addAttribute("defenReboundPercent", defenReboundPercent);
		 //抢断率
		 int grabPercent=Integer.parseInt(analysisAverageList.get("grabPercentAverage").toString());
		 model.addAttribute("grabPercent", grabPercent);
		 //盖帽率
		 int blockPercent=Integer.parseInt(analysisAverageList.get("blockPercentAverage").toString());
		 model.addAttribute("blockPercent", blockPercent);
		 //防守效率
		 int defensiveEfficiency=Integer.parseInt(analysisAverageList.get("defensiveEfficiencyAverage").toString());
		 model.addAttribute("defensiveEfficiency", defensiveEfficiency);
		 //助攻率
		 int assistancePercent=Integer.parseInt(analysisAverageList.get("assistancePercentAverage").toString());
		 model.addAttribute("assistancePercent", assistancePercent);
		 //助攻失误比
		 int ATR=Integer.parseInt(dataAverageList.get("ATRAverage").toString());
		 model.addAttribute("ATR", ATR);
		 /*
		  * 综合能力
		  */
		 //PER
		 int PER=Integer.parseInt(analysisAverageList.get("PERAverage").toString());
		 model.addAttribute("PER", PER);
		 //WS
		 int WS=Integer.parseInt(analysisAverageList.get("WSAverage").toString());
		 model.addAttribute("WS", WS);
		 //进攻能力 计算公式：进攻能力=真实命中率*0.2+投篮效率*0.2+进攻篮板率*0.1+使用率*0.2+进攻效率*0.2+失误率*0.1
		 int OffensiveCapability=(int)(truePercentage*0.2+shootEfficiency*0.2+offenReboundPercent*0.1+usePercent*0.2+offensiveEfficiency*0.2+mistakePercent*0.1);
		 model.addAttribute("OffensiveCapability", OffensiveCapability);
		 //防守能力 计算公式：防守能力=(防守篮板率+抢断率+盖帽率+防守效率)/4
		 int DefensiveCapability=(int)((defenReboundPercent+grabPercent+blockPercent+defensiveEfficiency)/4);
		 model.addAttribute("DefensiveCapability", DefensiveCapability);
		 //策应能力 计算公式：策应能力=助攻率*0.4+助攻失误比*0.6
		 int AssistanceCapability=(int)(assistancePercent*0.4+ATR*0.6);
		 model.addAttribute("AssistanceCapability", AssistanceCapability);
		 
		 
		 System.out.println("truePercentage: "+truePercentage);
		 System.out.println("shootEfficiency: "+shootEfficiency);
		 System.out.println("offenReboundPercent: "+offenReboundPercent);
		 System.out.println("usePercent: "+usePercent);
		 System.out.println("offensiveEfficiency: "+offensiveEfficiency);
		 System.out.println("mistakePercent: "+mistakePercent); 
		 
		 
		 //球员生涯之最数据
		 List<PlayerCareerHigh> playerCareerHighList=playerService.getPlayerCareerHighList(playerName);
		 
		 for (int i = 0; i < playerCareerHighList.size(); i++) {
			 for (int j = i+1; j < playerCareerHighList.size(); j++) {
				if (playerCareerHighList.get(i).getYear().equals(playerCareerHighList.get(j).getYear())) {
					playerCareerHighList.get(i).setCareerHighData(playerCareerHighList.get(i).getCareerHighData()+" "+playerCareerHighList.get(j).getCareerHighData());
					playerCareerHighList.remove(j);
				}
			}

		}		 
		 model.addAttribute("playerCareerHighList", playerCareerHighList);
		 for (PlayerCareerHigh playerCareerHigh : playerCareerHighList) {
			System.out.println(playerCareerHigh.toString());
		}


		return "PlayerInfo";
	}
	
	//跳转到球员对比界面
	@RequestMapping(value = "/comparison", method = RequestMethod.GET)
	public String showCompare(HttpSession session){
		session.setAttribute("picture1", "PlayersBigAvatar/jordon.jpg");
		session.setAttribute("picture2", "PlayersBigAvatar/kobe.jpg");
		
		//初始界面
		 session.setAttribute("scoreAverageP1", 100);
		 session.setAttribute("assistanceAverageP1", 90);
		 session.setAttribute("reboundAverageP1", 70);
		 session.setAttribute("grabAverageP1", 66);
		 session.setAttribute("blockAverageP1", 87);
		 session.setAttribute("mistakeAverageP1", 96);
		 session.setAttribute("shootPercentageAverageP1", 77);
		 session.setAttribute("PERAverageP1", 89);
		 
		 session.setAttribute("scoreAverageP2", 100);
		 session.setAttribute("assistanceAverageP2", 88);
		 session.setAttribute("reboundAverageP2", 75);
		 session.setAttribute("grabAverageP2", 91);
		 session.setAttribute("blockAverageP2", 69);
		 session.setAttribute("mistakeAverageP2", 86);
		 session.setAttribute("shootPercentageAverageP2", 90);
		 session.setAttribute("PERAverageP2", 77);
		 
		 List<PlayerSingleGame> playerSingleGames1=playerService.getPlayerSingleGameByName("科比-布莱恩特"); 
		 List<PlayerSingleGame> playerSingleGames2=playerService.getPlayerSingleGameByName("凯文-加内特"); 
			List<PlayerSingleGame> PSGP1 = new ArrayList<PlayerSingleGame>();
			List<PlayerSingleGame> PSGP2 = new ArrayList<PlayerSingleGame>();
		 for (PlayerSingleGame P1 : playerSingleGames1) {
				for (PlayerSingleGame P2 : playerSingleGames2) {
					if (P1.getGameID().equals(P2.getGameID())) {
						PSGP1.add(P1);
						PSGP2.add(P2);
					}
				}
				
		 }
		 PlayerSingleGame playerSingleGamesAverageP1=calculateComparison(PSGP1);
		 PlayerSingleGame playerSingleGamesAverageP2=calculateComparison(PSGP2);
			
		 session.setAttribute("playerSingleGamesAverageP1", playerSingleGamesAverageP1);
		 session.setAttribute("playerSingleGamesAverageP2", playerSingleGamesAverageP2);
			
		 session.setAttribute("P1Win", 29);
		 session.setAttribute("P2Win", 24);
		 
		 session.setAttribute("P1", PSGP1.get(0));
		 session.setAttribute("P2", PSGP2.get(0));


		
		return "comparison";
	}
	
	//得到球员对比的球员一的图片
	@RequestMapping(value = "/picture1", method = RequestMethod.GET)
	public String getPlayerPictureFirst(@ModelAttribute Player player,HttpSession session){
		System.out.println(player.getcName());
		List<Player> playerList = playerService.searchPlayer(player.getcName());
		session.setAttribute("picture1", playerList.get(0).getPicture());
		session.setAttribute("picture2", session.getAttribute("picture2"));
		session.setAttribute("name1", player.getcName());
		
		return "comparison";
	}
	
	//得到球员对比的球员二的图片
	@RequestMapping(value = "/picture2", method = RequestMethod.GET)
	public String getPlayerPictureSecond(@ModelAttribute Player player,HttpSession session){
		System.out.println(player.getcName());
		List<Player> playerList = playerService.searchPlayer(player.getcName());
		session.setAttribute("picture2", playerList.get(0).getPicture());
		session.setAttribute("picture1", session.getAttribute("picture1"));
		session.setAttribute("name2", player.getcName());
		return "comparison";
	}

	// 球员数据对比
	@RequestMapping(value = "/compare", method = RequestMethod.GET)
	public String compare(String firstName,String secondName, HttpSession session) {
		List<Player> playerList1 = playerService.searchPlayer(firstName);
		List<Player> playerList2 = playerService.searchPlayer(secondName);
		
		firstName=playerList1.get(0).getcName();
		secondName=playerList2.get(0).getcName();
		session.setAttribute("firstName", firstName);
		session.setAttribute("secondName", secondName);
		
		// 球员一所有常规赛场均数据
		List<PlayerDataStatistics> dataStatisticsP1 = playerService
				.getDataStatisticsByName(firstName, "0");
		List<PlayerDataAnalysis> dataAnalysisP1 = playerService
				.getDataAnalysisByName(firstName, "0");
		// 球员二所有常规赛场均数据
		List<PlayerDataStatistics> dataStatisticsP2 = playerService
				.getDataStatisticsByName(secondName, "0");
		List<PlayerDataAnalysis> dataAnalysisP2 = playerService
				.getDataAnalysisByName(secondName, "0");
		
		//球员一生涯常规赛场均数据
		Map<String, Object> dataAverageListP1=careerDataStatistics(dataStatisticsP1);
		Map<String, Object> analysisAverageListP1=careerDataAnalysis(dataAnalysisP1);
		//球员二生涯常规赛场均数据
		Map<String, Object> dataAverageListP2=careerDataStatistics(dataStatisticsP2);
		Map<String, Object> analysisAverageListP2=careerDataAnalysis(dataAnalysisP2);
		
		System.out.println("场均得分："+dataAverageListP1.get("scoreAverage")+"  "+dataAverageListP2.get("scoreAverage"));
		System.out.println("场均助攻："+dataAverageListP1.get("assistanceAverage")+"  "+dataAverageListP2.get("assistanceAverage"));
		System.out.println("场均篮板："+dataAverageListP1.get("reboundAverage")+"  "+dataAverageListP2.get("reboundAverage"));
		System.out.println("场均抢断："+dataAverageListP1.get("grabAverage")+"  "+dataAverageListP2.get("grabAverage"));
		System.out.println("场均盖帽："+dataAverageListP1.get("blockAverage")+"  "+dataAverageListP2.get("blockAverage"));
		System.out.println("场均失误："+dataAverageListP1.get("mistakeAverage")+"  "+dataAverageListP2.get("mistakeAverage"));
		System.out.println("场均命中率："+dataAverageListP1.get("mistakeAverage")+"  "+dataAverageListP2.get("shootPercentageAverage"));
		System.out.println("场均PER："+analysisAverageListP1.get("PERAverage")+"  "+analysisAverageListP2.get("PERAverage"));
		
		 session.setAttribute("scoreAverageP1", dataAverageListP1.get("scoreAverage"));
		 session.setAttribute("assistanceAverageP1", dataAverageListP1.get("assistanceAverage"));
		 session.setAttribute("reboundAverageP1", dataAverageListP1.get("reboundAverage"));
		 session.setAttribute("grabAverageP1", dataAverageListP1.get("grabAverage"));
		 session.setAttribute("blockAverageP1", dataAverageListP1.get("blockAverage"));
		 session.setAttribute("mistakeAverageP1", dataAverageListP1.get("mistakeAverage"));
		 session.setAttribute("shootPercentageAverageP1", dataAverageListP1.get("mistakeAverage"));
		 session.setAttribute("PERAverageP1", analysisAverageListP1.get("PERAverage"));
		 
		 session.setAttribute("scoreAverageP2", dataAverageListP2.get("scoreAverage"));
		 session.setAttribute("assistanceAverageP2", dataAverageListP2.get("assistanceAverage"));
		 session.setAttribute("reboundAverageP2", dataAverageListP2.get("reboundAverage"));
		 session.setAttribute("grabAverageP2", dataAverageListP2.get("grabAverage"));
		 session.setAttribute("blockAverageP2", dataAverageListP2.get("blockAverage"));
		 session.setAttribute("mistakeAverageP2", dataAverageListP2.get("mistakeAverage"));
		 session.setAttribute("shootPercentageAverageP2", dataAverageListP2.get("mistakeAverage"));
		 session.setAttribute("PERAverageP2", analysisAverageListP2.get("PERAverage"));

		// 球员交手数据
		List<PlayerSingleGame> playerSingleGames1=playerService.getPlayerSingleGameByName(firstName); 
		List<PlayerSingleGame> playerSingleGames2=playerService.getPlayerSingleGameByName(secondName); 
		List<Game> gameList=new ArrayList<Game>();
		for (PlayerSingleGame P1 : playerSingleGames1) {
			for (PlayerSingleGame P2 : playerSingleGames2) {
				if (P1.getGameID().equals(P2.getGameID())) {
					playerSingleGamesP1.add(P1);
					playerSingleGamesP2.add(P2);
					gameList.add(gameService.getGameByID(P1.getGameID()));
				}
			}
			
		}
		session.setAttribute("gameList", gameList);
		session.setAttribute("playerSingleGamesP1", analysisAverageListP2.get("playerSingleGamesP1"));
		session.setAttribute("playerSingleGamesP2", analysisAverageListP2.get("playerSingleGamesP2"));
		int P1Win=0;
		int P2Win=0;
		for (int i=0;i<gameList.size();i++) {
			if (playerSingleGamesP1.get(i).getTeam().equals(gameList.get(i).getHomeTeam())) {
				if (Integer.parseInt(gameList.get(i).getHomeScore())>Integer.parseInt(gameList.get(i).getGuestScore())) {
					P1Win++;
				}else {
					P2Win++;
				}
			}else {
				if (Integer.parseInt(gameList.get(i).getHomeScore())>Integer.parseInt(gameList.get(i).getGuestScore())) {
					P2Win++;
				}else {
					P1Win++;
				}
			}
		}
		PlayerSingleGame playerSingleGamesAverageP1=calculateComparison(playerSingleGamesP1);
		PlayerSingleGame playerSingleGamesAverageP2=calculateComparison(playerSingleGamesP2);
		
		session.setAttribute("playerSingleGamesAverageP1", playerSingleGamesAverageP1);
		session.setAttribute("playerSingleGamesAverageP2", playerSingleGamesAverageP2);
		
		session.setAttribute("P1Win", P1Win);
		session.setAttribute("P2Win", P2Win);
		
		System.out.println("P1Win: "+P1Win);
		System.out.println("P2Win: "+P2Win);
		for (PlayerSingleGame p : playerSingleGamesP1) {
			System.out.println(p.toString());
		}
		for (PlayerSingleGame p : playerSingleGamesP2) {
			System.out.println(p.toString());
		}
		
		session.setAttribute("number", playerSingleGamesP1.size());
		System.out.println("playerSingleGamesP1: "+playerSingleGamesP1.size());
		System.out.println("playerSingleGamesP2: "+playerSingleGamesP2.size());
		System.out.println("playerSingleGamesAverageP1: "+playerSingleGamesAverageP1.toString());
		System.out.println("playerSingleGamesAverageP2: "+playerSingleGamesAverageP2.toString());

		return "comparison";
	}
	
	//得到某一场两名球员的交手数据
	@RequestMapping(value = "/singleGame", method = RequestMethod.GET)
	public String SingleGameComparison(@ModelAttribute Game game,HttpSession session){

		Game g=gameService.getGameByID(game.getGameID());
		System.out.println("test:---------------------------");
		System.out.println("gameDate: "+g.getGameDate());
		System.out.println(g.toString());
		session.setAttribute("game", g);
		for (PlayerSingleGame p : playerSingleGamesP1) {
			if (p.getGameDate().equals(g.getGameDate())) {
				session.setAttribute("P1", p);
				System.out.println(p.toString());
			}
		}
		for (PlayerSingleGame p : playerSingleGamesP2) {
			if (p.getGameDate().equals(g.getGameDate())) {
				session.setAttribute("P2", p);
				System.out.println(p.toString());
			}
		}
		return "comparison";
	}
	
	//计算球员场均交手数据
	public PlayerSingleGame calculateComparison(List<PlayerSingleGame> playerSingleGames){
		//各种数据的交手总数据
		double playTimeSum=0;
		double shootPercentageSum=0;
		double shootHitSum=0;
		double shootTotalSum=0;
		double threePercentageSum=0;
		double threeHitSum=0;
		double threeTotalSum=0;
		double freeThrowPercentageSum=0;
		double freeThrowHitSum=0;
		double freeThrowTotalSum=0;
		double reboundSum=0;
		double offensiveReboundSum=0;
		double defensiveReboundSum=0;
		double assistanceSum=0;
		double grabSum=0;
		double blockSum=0;
		double mistakeSum=0;
		double foulSum=0;
		double scoreSum=0;
		for (PlayerSingleGame p : playerSingleGames) {
			scoreSum += Double.parseDouble(p.getScore());
			playTimeSum += Double.parseDouble(p.getPlayTime());
			assistanceSum += Double.parseDouble(p.getAssistance());
			reboundSum += Double.parseDouble(p.getRebound());
			offensiveReboundSum += Double.parseDouble(p.getOffensiveRebound());
			defensiveReboundSum += Double.parseDouble(p.getDefensiveRebound());
			shootTotalSum += Double.parseDouble(p.getShootTotal());
			shootHitSum += Double.parseDouble(p.getShootHit());
			shootPercentageSum += Double.parseDouble(p.getShootPercentage()
					.replace("%", ""));
			threeTotalSum += Double.parseDouble(p.getThreeTotal());
			threeHitSum += Double.parseDouble(p.getThreeHit());
			threePercentageSum += Double.parseDouble(p.getThreePercentage()
					.replace("%", ""));
			freeThrowTotalSum += Double.parseDouble(p.getFreeThrowTotal());
			freeThrowHitSum += Double.parseDouble(p.getFreeThrowHit());
			freeThrowPercentageSum += Double.parseDouble(p
					.getFreeThrowPercentage().replace("%", ""));
			blockSum += Double.parseDouble(p.getBlock());
			grabSum += Double.parseDouble(p.getGrab());
			mistakeSum += Double.parseDouble(p.getMistake());
			foulSum += Double.parseDouble(p.getFoul());
		}
		/*
		 * 场均交手平均数据
		 */
		DecimalFormat df= new DecimalFormat("######0.00");   
		NumberFormat fmt = NumberFormat.getPercentInstance();  
		fmt.setMaximumFractionDigits(2);//最多两位百分小数，如25.23%  
		int length = playerSingleGames.size();
		String scoreAverage = df.format(scoreSum / length);
		String playTimeAverage = df.format(playTimeSum / length);
		String assistanceAverage = df.format(assistanceSum / length);
		String reboundAverage = df.format(reboundSum / length);
		String offensiveReboundAverage = df.format(offensiveReboundSum / length);
		String defensiveReboundAverage = df.format(defensiveReboundSum / length);
		String shootTotalAverage = df.format(shootTotalSum / length);
		String shootHitAverage = df.format(shootHitSum / length);
		String shootPercentageAverage = fmt.format((shootPercentageSum / length)*0.01);
		String threeTotalAverage = df.format(threeTotalSum / length);
		String threeHitAverage = df.format(threeHitSum / length);
		String threePercentageAverage =fmt.format((threePercentageSum / length)*0.01);
		String freeThrowPercentageAverage = df.format(freeThrowPercentageSum / length);
		String freeThrowTotalAverage = df.format(freeThrowTotalSum / length);
		String freeThrowHitAverage = fmt.format((freeThrowHitSum / length)*0.01);
		String blockAverage = df.format(blockSum / length);
		String grabAverage = df.format(grabSum / length);
		String mistakeAverage = df.format(mistakeSum / length);
		String foulAverage = df.format(foulSum / length);
		
		PlayerSingleGame playerSingleGame=new PlayerSingleGame(0, "", "", "", "", "", "", 
				playTimeAverage, shootPercentageAverage, shootHitAverage, 
				shootTotalAverage, threePercentageAverage, threeHitAverage, 
				threeTotalAverage, freeThrowPercentageAverage, freeThrowHitAverage, 
				freeThrowTotalAverage, "", reboundAverage,
				offensiveReboundAverage, defensiveReboundAverage, assistanceAverage, 
				grabAverage,blockAverage,  mistakeAverage, 
				foulAverage, scoreAverage);
		return playerSingleGame;
		
	}

	// 计算球员生涯平均统计数据
	public Map<String, Object> careerDataStatistics(
			List<PlayerDataStatistics> dataStatistics) {
		// 生涯总得分
		double scoreSum = 0;
		// 生涯总出场次数
		double appearCntSum = 0;
		// 生涯总首发次数
		double firstCntSum = 0;
		// 生涯总时间
		double playTimeSum = 0;
		// 生涯总助攻
		double assistanceSum = 0;
		// 生涯总篮板
		double reboundSum = 0;
		// 生涯总进攻篮板
		double offensiveReboundSum = 0;
		// 生涯总防守篮板
		double defensiveReboundSum = 0;
		// 生涯总出手
		double shootTotalSum = 0;
		// 生涯总命中
		double shootHitSum = 0;
		// 生涯总命中率
		double shootPercentageSum = 0;
		// 生涯总三分出手
		double threeTotalSum = 0;
		// 生涯总三分命中
		double threeHitSum = 0;
		// 生涯总三分命中率
		double threePercentageSum = 0;
		// 生涯总罚球命中率
		double freeThrowPercentageSum = 0;
		// 生涯总罚球出手
		double freeThrowTotalSum = 0;
		// 生涯总罚球命中
		double freeThrowHitSum = 0;
		// 生涯总盖帽
		double blockSum = 0;
		// 生涯总抢断
		double grabSum = 0;
		// 生涯总失误次数
		double mistakeSum = 0;
		// 生涯总犯规次数
		double foulSum = 0;
		// 生涯总胜场
		double winCntSum = 0;
		// 生涯总负场
		double loseCntSum = 0;

		for (PlayerDataStatistics p : dataStatistics) {
			scoreSum += Double.parseDouble(p.getScore());
			appearCntSum += Double.parseDouble(p.getAppearCnt());
			firstCntSum += Double.parseDouble(p.getFirstCnt());
			playTimeSum += Double.parseDouble(p.getPlayTime());
			assistanceSum += Double.parseDouble(p.getAssistance());
			reboundSum += Double.parseDouble(p.getRebound());
			offensiveReboundSum += Double.parseDouble(p.getOffensiveRebound());
			defensiveReboundSum += Double.parseDouble(p.getDefensiveRebound());
			shootTotalSum += Double.parseDouble(p.getShootTotal());
			shootHitSum += Double.parseDouble(p.getShootHit());
			shootPercentageSum += Double.parseDouble(p.getShootPercentage()
					.replace("%", ""));
			threeTotalSum += Double.parseDouble(p.getThreeTotal());
			threeHitSum += Double.parseDouble(p.getThreeHit());
			threePercentageSum += Double.parseDouble(p.getThreePercentage()
					.replace("%", ""));
			freeThrowTotalSum += Double.parseDouble(p.getFreeThrowTotal());
			freeThrowHitSum += Double.parseDouble(p.getFreeThrowHit());
			freeThrowPercentageSum += Double.parseDouble(p
					.getFreeThrowPercentage().replace("%", ""));
			blockSum += Double.parseDouble(p.getBlock());
			grabSum += Double.parseDouble(p.getGrab());
			mistakeSum += Double.parseDouble(p.getMistake());
			foulSum += Double.parseDouble(p.getFoul());
			winCntSum += Double.parseDouble(p.getWinCnt());
			loseCntSum += Double.parseDouble(p.getLoseCnt());
		}

		/*
		 * 生涯平均数据
		 */
		int length = dataStatistics.size();
		NumberFormat fmt = NumberFormat.getPercentInstance();
		fmt.setMaximumFractionDigits(2);// 最多两位百分小数，如25.23%
		// 生涯平均得分 28分算100
		String scoreAverage = String
				.valueOf(new BigDecimal(((scoreSum / length) / 28)*100).setScale(0, BigDecimal.ROUND_HALF_UP));
		// 生涯平均出场次数
		double appearCntAverage = appearCntSum / length;
		// 生涯平均首发次数
		double firstCntAverage = firstCntSum / length;
		// 生涯平均时间
		double playTimeAverage = playTimeSum / length;
		// 生涯平均助攻   10个算100分
		String assistanceAverage = String.valueOf(new BigDecimal(((assistanceSum / length) / 10)*100).setScale(0, BigDecimal.ROUND_HALF_UP));
		// 生涯平均篮板 10个算100分
		String reboundAverage = String.valueOf(new BigDecimal(((reboundSum / length) / 10)*100).setScale(0, BigDecimal.ROUND_HALF_UP));
		// 生涯平均进攻篮板
		double offensiveReboundAverage = offensiveReboundSum / length;
		// 生涯平均防守篮板
		double defensiveReboundAverage = defensiveReboundSum / length;
		// 生涯平均出手
		double shootTotalAverage = shootTotalSum / length;
		// 生涯平均命中
		double shootHitAverage = shootHitSum / length;
		// 生涯平均命中率  58%算100分
		String shootPercentageAverage = String.valueOf(new BigDecimal(((shootPercentageSum / length) / 58)*100).setScale(0, BigDecimal.ROUND_HALF_UP));
		// 生涯平均三分出手
		double threeTotalAverage = threeTotalSum / length;
		// 生涯平均三分命中
		double threeHitAverage = threeHitSum / length;
		// 生涯平均三分命中率
		String threePercentageAverage = fmt
				.format((threePercentageSum / length) * 0.01);
		// 生涯平均罚球命中率
		String freeThrowPercentageAverage = fmt
				.format((freeThrowPercentageSum / length) * 0.01);
		// 生涯平均罚球出手
		double freeThrowTotalAverage = freeThrowTotalSum / length;
		// 生涯平均罚球命中
		double freeThrowHitAverage = freeThrowHitSum / length;
		// 生涯平均盖帽  3.5个算100分
		String blockAverage = String.valueOf(new BigDecimal(((blockSum / length) / 3.5)*100).setScale(0, BigDecimal.ROUND_HALF_UP));
		// 生涯平均抢断  3.5个算100分
		String grabAverage = String.valueOf(new BigDecimal(((grabSum / length) / 3.5)*100).setScale(0, BigDecimal.ROUND_HALF_UP));
		// 生涯平均失误次数  5次算100分
		String mistakeAverage = String.valueOf(new BigDecimal(((mistakeSum / length)/5)*100).setScale(0, BigDecimal.ROUND_HALF_UP));
		// 生涯平均犯规次数
		double foulAverage = foulSum / length;
		// 生涯平均胜场
		double winCntAverage = winCntSum / length;
		// 生涯平均负场
		double loseCntAverage = loseCntSum / length;
		// 生涯平均助攻失误比，一般4.5算100分
		String ATRAverage = String.valueOf(new BigDecimal(((Double.parseDouble(assistanceAverage) / Double.parseDouble(mistakeAverage))/ 4.5)*100).setScale(0, BigDecimal.ROUND_HALF_UP));

		Map<String, Object> dataAverageList = new HashMap<String, Object>();
		dataAverageList.put("scoreAverage", scoreAverage);
		dataAverageList.put("appearCntAverage", appearCntAverage);
		dataAverageList.put("firstCntAverage", firstCntAverage);
		dataAverageList.put("playTimeAverage", playTimeAverage);
		dataAverageList.put("assistanceAverage", assistanceAverage);
		dataAverageList.put("reboundAverage", reboundAverage);
		dataAverageList.put("offensiveReboundAverage", offensiveReboundAverage);
		dataAverageList.put("defensiveReboundAverage", defensiveReboundAverage);
		dataAverageList.put("shootTotalAverage", shootTotalAverage);
		dataAverageList.put("shootHitAverage", shootHitAverage);
		dataAverageList.put("shootPercentageAverage", shootPercentageAverage);
		dataAverageList.put("threeTotalAverage", threeTotalAverage);
		dataAverageList.put("threeHitAverage", threeHitAverage);
		dataAverageList.put("threePercentageAverage", threePercentageAverage);
		dataAverageList.put("freeThrowPercentageAverage",
				freeThrowPercentageAverage);
		dataAverageList.put("freeThrowTotalAverage", freeThrowTotalAverage);
		dataAverageList.put("freeThrowHitAverage", freeThrowHitAverage);
		dataAverageList.put("blockAverage", blockAverage);
		dataAverageList.put("grabAverage", grabAverage);
		dataAverageList.put("mistakeAverage", mistakeAverage);
		dataAverageList.put("foulAverage", foulAverage);
		dataAverageList.put("winCntAverage", winCntAverage);
		dataAverageList.put("loseCntAverage", loseCntAverage);
		dataAverageList.put("ATRAverage", ATRAverage);

		return dataAverageList;
	}

	// 计算球员生涯平均分析数据
	public Map<String, Object> careerDataAnalysis(
			List<PlayerDataAnalysis> dataAnalysis) {
		// 生涯总真实命中率
		double truePercentageSum = 0;
		// 生涯总投篮效率
		double shootEfficiencySum = 0;
		// 生涯总进攻篮板率
		double offenReboundPercentSum = 0;
		// 生涯总使用率
		double usePercentSum = 0;
		// 生涯总进攻效率
		double offensiveEfficiencySum = 0;
		// 生涯总失误率
		double mistakePercentSum = 0;
		// 生涯总防守篮板率
		double defenReboundPercentSum = 0;
		// 生涯总抢断率
		double grabPercentSum = 0;
		// 生涯总盖帽率
		double blockPercentSum = 0;
		// 生涯总防守效率
		double defensiveEfficiencySum = 0;
		// 生涯总助攻率
		double assistancePercentSum = 0;
		// 生涯总PER
		double PERSum = 0;
		// 生涯总WS
		double WSSum = 0;

		for (PlayerDataAnalysis p : dataAnalysis) {
			truePercentageSum += Double.parseDouble(p.getTruePercentage()
					.replace("%", ""));
			shootEfficiencySum += Double.parseDouble(p.getShootEfficiency()
					.replace("%", ""));
			offenReboundPercentSum += Double.parseDouble(p
					.getOffenReboundPercent().replace("%", ""));
			usePercentSum += Double.parseDouble(p.getUsePercent().replace("%",
					""));
			offensiveEfficiencySum += Double.parseDouble(p
					.getOffensiveEfficiency());
			mistakePercentSum += Double.parseDouble(p.getMistakePercent()
					.replace("%", ""));
			defenReboundPercentSum += Double.parseDouble(p
					.getDefenReboundPercent().replace("%", ""));
			grabPercentSum += Double.parseDouble(p.getGrabPercent().replace(
					"%", ""));
			blockPercentSum += Double.parseDouble(p.getBlockPercent().replace(
					"%", ""));
			defensiveEfficiencySum += Double.parseDouble(p
					.getDefensiveEfficiency());
			assistancePercentSum += Double.parseDouble(p.getAssistancePercent()
					.replace("%", ""));
			PERSum += Double.parseDouble(p.getPER());
			WSSum += Double.parseDouble(p.getWS());
		}
		/*
		 * 生涯平均进阶数据 转换成统一的评分
		 */
		int length = dataAnalysis.size();
		// 真实命中率一般70%算100分
		String truePercentageAverage = String
				.valueOf(new BigDecimal(((truePercentageSum / length) / 70)*100).setScale(0, BigDecimal.ROUND_HALF_UP));
		//投篮效率 一般68%算100分
		String shootEfficiencyAverage=String
				.valueOf(new BigDecimal(((shootEfficiencySum / length) / 68)*100).setScale(0, BigDecimal.ROUND_HALF_UP));
		//进攻篮板率一般30%算100分
		String offenReboundPercentAverage=String
				.valueOf(new BigDecimal(((offenReboundPercentSum / length) / 30)*100).setScale(0, BigDecimal.ROUND_HALF_UP));
        //使用率一般40%算100分
		String usePercentAverage=String
				.valueOf(new BigDecimal(((usePercentSum / length) / 40)*100).setScale(0, BigDecimal.ROUND_HALF_UP));
        //生涯进攻效率一般120算100分
		String offensiveEfficiencyAverage=String
				.valueOf(new BigDecimal(((offensiveEfficiencySum / length) / 120)*100).setScale(0, BigDecimal.ROUND_HALF_UP));
		//生涯失误率一般30%算100分
		String mistakePercentAverage=String
				.valueOf(new BigDecimal(((mistakePercentSum / length) / 30)*100).setScale(0, BigDecimal.ROUND_HALF_UP));
		//生涯防守篮板率一般40%算100分
		String defenReboundPercentAverage=String
				.valueOf(new BigDecimal(((defenReboundPercentSum / length) / 40)*100).setScale(0, BigDecimal.ROUND_HALF_UP));
		//生涯抢断率一般3%算100分
		String grabPercentAverage=String
				.valueOf(new BigDecimal(((grabPercentSum / length) / 3)*100).setScale(0, BigDecimal.ROUND_HALF_UP));
		//生涯盖帽率一般10%算100分
		String blockPercentAverage=String
				.valueOf(new BigDecimal(((blockPercentSum / length) / 10)*100).setScale(0, BigDecimal.ROUND_HALF_UP));
		//生涯防守效率一般120算100分
		String defensiveEfficiencyAverage=String
				.valueOf(new BigDecimal(((defensiveEfficiencySum / length) / 120)*100).setScale(0, BigDecimal.ROUND_HALF_UP));
		//生涯助攻率一般65%算100分
		String assistancePercentAverage=String
				.valueOf(new BigDecimal(((assistancePercentSum / length) / 65)*100).setScale(0, BigDecimal.ROUND_HALF_UP));
		//生涯PER一般40算100分
		String PERAverage=String
				.valueOf(new BigDecimal(((PERSum / length) / 40)*100).setScale(0, BigDecimal.ROUND_HALF_UP));
		//生涯WS一般25算100分
		String WSAverage=String
				.valueOf(new BigDecimal(((WSSum / length) / 25)*100).setScale(0, BigDecimal.ROUND_HALF_UP));	
		
		Map<String, Object> dataAnalysisAverageList = new HashMap<String, Object>();
		dataAnalysisAverageList.put("truePercentageAverage", truePercentageAverage);
		dataAnalysisAverageList.put("shootEfficiencyAverage", shootEfficiencyAverage);
		dataAnalysisAverageList.put("offenReboundPercentAverage", offenReboundPercentAverage);
		dataAnalysisAverageList.put("usePercentAverage", usePercentAverage);
		dataAnalysisAverageList.put("offensiveEfficiencyAverage", offensiveEfficiencyAverage);
		dataAnalysisAverageList.put("mistakePercentAverage", mistakePercentAverage);
		dataAnalysisAverageList.put("defenReboundPercentAverage", defenReboundPercentAverage);
		dataAnalysisAverageList.put("grabPercentAverage", grabPercentAverage);
		dataAnalysisAverageList.put("blockPercentAverage", blockPercentAverage);
		dataAnalysisAverageList.put("defensiveEfficiencyAverage", defensiveEfficiencyAverage);
		dataAnalysisAverageList.put("assistancePercentAverage", assistancePercentAverage);
		dataAnalysisAverageList.put("PERAverage", PERAverage);
		dataAnalysisAverageList.put("WSAverage", WSAverage);
		
		return dataAnalysisAverageList;
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
