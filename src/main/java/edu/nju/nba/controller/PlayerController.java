package edu.nju.nba.controller;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
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
		List<PlayerDataStatistics> dataStatistics = playerService
				.getDataStatisticsByName(playerName, "0");
		model.addAttribute("dataStatistics", dataStatistics);
		for (PlayerDataStatistics PD : dataStatistics) {
			System.out.println(PD.toString());
		}
		
		//球员生涯平均统计数据
		 Map<String, Object> dataAverageList=careerDataStatistics(dataStatistics);
		 model.addAttribute("dataAverageList", dataAverageList);
		 
		//球员生涯平均进阶数据
		// 进攻能力分析：真实命中率，投篮效率，进攻篮板率，使用率，进攻效率、失误率
		// 防守能力分析：防守篮板率、抢断率、盖帽率、防守效率
		// 策应能力分析：助攻率、助攻失误比
		// 综合能力分析：WS，PER，进攻能力、防守能力、策应能力
		 List<PlayerDataAnalysis> dataAnalysis=playerService.getDataAnalysisByName(playerName, "0");
		 Map<String, Object> analysisAverageList=careerDataAnalysis(dataAnalysis);

		return "PlayerInfo";
	}

	// 球员数据对比
	@RequestMapping(value = "/{firstName}/{secondName}", method = RequestMethod.GET)
	public String compare(@PathVariable String firstName,
			@PathVariable String secondName, Model model) {
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

		// 球员交手数据
		// 根据球员所在球队找到game数据，再根据game找到PlayerSingleGame
		Player p1 = playerService.show(firstName);
		Player p2 = playerService.show(secondName);
		List<Game> games = gameService.getGames(p1.getTeam(), p2.getTeam());
		List<PlayerSingleGame> playerSingleGames = new ArrayList<PlayerSingleGame>();
		for (Game g : games) {
			playerSingleGames.add(playerService.getPlayerSingleGameByID(
					g.getGameID()).get(0));
			playerSingleGames.add(playerService.getPlayerSingleGameByID(
					g.getGameID()).get(1));
		}
		return "comparison";
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
		// 生涯平均得分
		double scoreAverage = scoreSum / length;
		// 生涯平均出场次数
		double appearCntAverage = appearCntSum / length;
		// 生涯平均首发次数
		double firstCntAverage = firstCntSum / length;
		// 生涯平均时间
		double playTimeAverage = playTimeSum / length;
		// 生涯平均助攻
		double assistanceAverage = assistanceSum / length;
		// 生涯平均篮板
		double reboundAverage = reboundSum / length;
		// 生涯平均进攻篮板
		double offensiveReboundAverage = offensiveReboundSum / length;
		// 生涯平均防守篮板
		double defensiveReboundAverage = defensiveReboundSum / length;
		// 生涯平均出手
		double shootTotalAverage = shootTotalSum / length;
		// 生涯平均命中
		double shootHitAverage = shootHitSum / length;
		// 生涯平均命中率
		String shootPercentageAverage = fmt
				.format((shootPercentageSum / length) * 0.01);
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
		// 生涯平均盖帽
		double blockAverage = blockSum / length;
		// 生涯平均抢断
		double grabAverage = grabSum / length;
		// 生涯平均失误次数
		double mistakeAverage = mistakeSum / length;
		// 生涯平均犯规次数
		double foulAverage = foulSum / length;
		// 生涯平均胜场
		double winCntAverage = winCntSum / length;
		// 生涯平均负场
		double loseCntAverage = loseCntSum / length;
		// 生涯平均助攻失误比
		double ATRAverage = assistanceAverage / mistakeAverage;

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
		
		System.out.println("truePercentageAverage: "+truePercentageAverage);
		System.out.println("shootEfficiencyAverage: "+shootEfficiencyAverage);
		System.out.println("offenReboundPercentAverage: "+offenReboundPercentAverage);
		System.out.println("offensiveEfficiencySum: "+offensiveEfficiencySum);
		System.out.println("offensiveEfficiencyAverage: "+offensiveEfficiencyAverage);
		System.out.println("mistakePercentAverage: "+mistakePercentAverage);
		System.out.println("defenReboundPercentAverage: "+defenReboundPercentAverage);
		System.out.println("grabPercentAverage: "+grabPercentAverage);
		System.out.println("blockPercentAverage: "+blockPercentAverage);
		System.out.println("defensiveEfficiencyAverage: "+defensiveEfficiencyAverage);
		System.out.println("assistancePercentAverage: "+assistancePercentAverage);
		System.out.println("PERAverage: "+PERAverage);
		System.out.println("WSAverage: "+WSAverage);
		
		
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

	// 得到球队阵容
	public String team(String teamName, Model model) {
		List<PlayerDataStatistics> PD = playerService.findTeam(teamName,
				"14-15", "0");
		List<Player> playerList = new ArrayList<Player>();
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
