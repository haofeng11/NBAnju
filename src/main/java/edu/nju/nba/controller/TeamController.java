package edu.nju.nba.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import edu.nju.nba.bean.Team;
import edu.nju.nba.bean.TeamSeasonAverage;
import edu.nju.nba.bean.TeamSingleGame;
import edu.nju.nba.service.ITeamService;

@Controller
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private ITeamService teamService;

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

	// 球队单场比赛数据
	List<TeamSingleGame> teamSingleGames;
	List<TeamSingleGame> teamSingleGamesPO;

	// 球队赛季平均数据
	TeamSeasonAverage teamSA;
	TeamSeasonAverage teamSAPO;


	public TeamController() {

	}

	/**
	 * 根据球队姓名查找球队 return 球队信息 PS：球队姓名唯一
	 */
	@RequestMapping(value = "/find", method = RequestMethod.GET, params = "tt")
	@ResponseBody
	public Team show(@PathVariable String teamName) {
		System.out.println("ttt");
		System.out.println(teamName);
		Team team = teamService.show(teamName);

		System.out.println(team.toString());
		return team;
	}

	// 球队信息介绍
	@RequestMapping(value = "/{teamName}", method = RequestMethod.GET)
	public String show(@PathVariable String teamName, Model model) {

		// 得到球队各个赛季的常规赛平均数据
		teamSA = teamService.getSeasonAverage(teamName, "14-15", "0");
		model.addAttribute("teamSA", teamSA);

		// 得到球队各个赛季的季后赛平均数据
		// teamSAPO= teamService.getSeasonAverage(teamName, "14-15","1");
		// model.addAttribute("teamSAPO", teamSAPO);

		// 得到球队基本信息
		Team team = teamService.show(teamName);
		model.addAttribute(team);

		// 得到球队历任球星
		String[] teamStars = team.getTeamStar().split(":");
		model.addAttribute("teamStars", teamStars);

		List<TeamSeasonAverage> teamSAs = teamService.getSeasonAverageList(
				"14-15", "0");

		// 场均得分联盟排名
		scoreRanking = getScoreRanking(teamSA, teamSAs);
		model.addAttribute("scoreRanking", scoreRanking);
		// 场均助攻联盟排名
		assistanceRanking = getAssistanceRanking(teamSA, teamSAs);
		model.addAttribute("assistanceRanking", assistanceRanking);
		// 场均篮板联盟排名
		reboundRanking = getReboundRanking(teamSA, teamSAs);
		model.addAttribute("reboundRanking", reboundRanking);
		// 场均抢断联盟排名
		grabRanking = getGrabRanking(teamSA, teamSAs);
		model.addAttribute("grabRanking", grabRanking);
		// 场均盖帽联盟排名
		blockRanking = getBlockRanking(teamSA, teamSAs);
		model.addAttribute("blockRanking", blockRanking);
		// 场均失误联盟排名
		mistakeRanking = getMistakeRanking(teamSA, teamSAs);
		model.addAttribute("mistakeRanking", mistakeRanking);

		// 球队最新赛季常规赛单场比赛数据
		teamSingleGames = teamService.getTeamSingleGames(
				teamName.split("队")[0], "14-15", "0");
		model.addAttribute("teamSingleGames", teamSingleGames);

		// 球队最新赛季季后赛单场比赛数据
		 teamSingleGamesPO=teamService.getTeamSingleGames(teamName.split("队")[0],
		 "14-15","1");
		 model.addAttribute("teamSingleGamesPO", teamSingleGamesPO);

		return "TeamInfo";
	}

	// 根据赛季ID返回各个赛季常规赛和季后赛json数据
	@RequestMapping(value = "/{teamName}/{seasonID}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> showSeasonData(@PathVariable String teamName,
			@PathVariable String seasonID) {

		// 得到常规赛和季后赛日期
		teamSingleGames = teamService.getTeamSingleGames(teamName.split("队")[0], seasonID, "0");
		teamSingleGamesPO=teamService.getTeamSingleGames(teamName.split("队")[0],seasonID,"1");
		
		//常规赛每场比赛统计数据
		String regular_date = "";
		String score="";
		String 	shootTotal="";
		String shootPercentage="";
		String threeHit="";//三分得分
		String threeTotal="";
		String threePercentage="";
		String assistance="";
		String rebound="";
		String block="";
		String grab="";
		String foul="";
		String mistake="";
		for (TeamSingleGame t : teamSingleGames) {
			regular_date += t.getGameDate() + ",";
			score+=t.getScore()+ ",";
			shootTotal+=t.getShootTotal()+ ",";
			shootPercentage+=t.getShootPercentage()+ ",";
			threeHit+=String.valueOf((Double.parseDouble(t.getThreeHit())*3))+ ",";
			threeTotal+=t.getThreeTotal()+ ",";
			threePercentage+=t.getThreePercentage()+ ",";
			assistance+=t.getAssistance()+ ",";
			rebound+=t.getRebound()+ ",";
			block+=t.getBlock()+ ",";
			grab+=t.getGrab()+ ",";
			foul+=t.getFoul()+ ",";
			mistake+=t.getMistake()+ ",";
		}
		regular_date = regular_date.substring(0, regular_date.length() - 1);
		score = score.substring(0, score.length() - 1);
		score=score.replace("\r", "");
		shootTotal = shootTotal.substring(0, shootTotal.length() - 1);
		shootPercentage = shootPercentage.substring(0, shootPercentage.length() - 1);
		threeHit = threeHit.substring(0, threeHit.length() - 1);
		threeTotal = threeTotal.substring(0, threeTotal.length() - 1);
		threePercentage = threePercentage.substring(0, threePercentage.length() - 1);
		assistance = assistance.substring(0, assistance.length() - 1);
		rebound = rebound.substring(0, rebound.length() - 1);
		block = block.substring(0, block.length() - 1);
		grab = grab.substring(0, grab.length() - 1);
		foul = foul.substring(0, foul.length() - 1);
		mistake = mistake.substring(0, mistake.length() - 1);
		//季后赛每场比赛统计
		String playoff_date = "";
		String scorePO="";
		String 	shootTotalPO="";
		String shootPercentagePO="";
		String threeHitPO="";//三分得分
		String threeTotalPO="";
		String threePercentagePO="";
		String assistancePO="";
		String reboundPO="";
		String blockPO="";
		String grabPO="";
		String foulPO="";
		String mistakePO="";
		if(teamSingleGamesPO.size()!=0){
			for (TeamSingleGame t : teamSingleGamesPO) {
				playoff_date += t.getGameDate() + ",";
				scorePO+=t.getScore()+ ",";
				shootTotalPO+=t.getShootTotal()+ ",";
				shootPercentagePO+=t.getShootPercentage()+ ",";
				threeHitPO+=String.valueOf((Double.parseDouble(t.getThreeHit())*3))+ ",";
				threeTotalPO+=t.getThreeTotal()+ ",";
				threePercentagePO+=t.getThreePercentage()+ ",";
				assistancePO+=t.getAssistance()+ ",";
				reboundPO+=t.getRebound()+ ",";
				blockPO+=t.getBlock()+ ",";
				grabPO+=t.getGrab()+ ",";
				foulPO+=t.getFoul()+ ",";
				mistakePO+=t.getMistake()+ ",";
			}
			playoff_date = playoff_date.substring(0, playoff_date.length() - 1);
			scorePO = scorePO.substring(0, scorePO.length() - 1);
			scorePO=scorePO.replace("\r", "");
			System.out.println(scorePO);
			shootTotalPO = shootTotalPO.substring(0, shootTotalPO.length() - 1);
			shootPercentagePO = shootPercentagePO.substring(0, shootPercentagePO.length() - 1);
			threeHitPO = threeHitPO.substring(0, threeHitPO.length() - 1);
			threeTotalPO = threeTotalPO.substring(0, threeTotalPO.length() - 1);
			threePercentagePO = threePercentagePO.substring(0, threePercentagePO.length() - 1);
			assistancePO = assistancePO.substring(0, assistancePO.length() - 1);
			reboundPO = reboundPO.substring(0, reboundPO.length() - 1);
			blockPO = blockPO.substring(0, blockPO.length() - 1);
			grabPO = grabPO.substring(0, grabPO.length() - 1);
			foulPO = foulPO.substring(0, foulPO.length() - 1);
			mistakePO = mistakePO.substring(0, mistakePO.length() - 1);
		}
		
		
		//每场比赛数据
		List<Statistics> data=new ArrayList<Statistics>();
		data.add(new Statistics(score, scorePO));
		data.add(new Statistics(shootTotal, shootTotalPO));
		data.add(new Statistics(shootPercentage, shootPercentagePO));
		data.add(new Statistics(threeHit, threeHitPO));
		data.add(new Statistics(threeTotal, threeTotalPO));
		data.add(new Statistics(threePercentage, threePercentagePO));
		data.add(new Statistics(assistance, assistancePO));
		data.add(new Statistics(rebound, reboundPO));
		data.add(new Statistics(block, blockPO));
		data.add(new Statistics(grab, grabPO));
		data.add(new Statistics(foul, foulPO));
		data.add(new Statistics(mistake, mistakePO));
		

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("season", seasonID);
		map.put("regular_date", regular_date);
		map.put("playoff_date", playoff_date);// 季后赛数据没有，暂时用常规赛数据代替
		map.put("data", data);

		return map;
	}

	//用来转json对象
	class Statistics {

		private String regular;
		private String playoff;

		public Statistics(String regular, String playoff) {
			super();
			this.regular = regular;
			this.playoff = playoff;
		}

		public String getRegular() {
			return regular;
		}

		public void setRegular(String regular) {
			this.regular = regular;
		}

		public String getPlayoff() {
			return playoff;
		}

		public void setPlayoff(String playoff) {
			this.playoff = playoff;
		}

	}

	// 场均得分联盟排名
	@SuppressWarnings("unchecked")
	private int getScoreRanking(TeamSeasonAverage teamSA,
			List<TeamSeasonAverage> teamSAs) {
		Collections.sort(teamSAs, new sortByScore());
		int scoreRanking = 0;
		for (TeamSeasonAverage t : teamSAs) {
			if (t.getTeam().equals(teamSA.getTeam())) {
				scoreRanking = (teamSAs.indexOf(t) + 1);
			}
		}
		return scoreRanking;
	}

	// 场均助攻联盟排名
	@SuppressWarnings("unchecked")
	private int getAssistanceRanking(TeamSeasonAverage teamSA,
			List<TeamSeasonAverage> teamSAs) {
		Collections.sort(teamSAs, new sortByAssistance());
		int assistanceRanking = 0;
		for (TeamSeasonAverage t : teamSAs) {
			if (t.getTeam().equals(teamSA.getTeam())) {
				assistanceRanking = (teamSAs.indexOf(t) + 1);
			}
		}
		return assistanceRanking;
	}

	// 场均篮板联盟排名
	@SuppressWarnings("unchecked")
	private int getReboundRanking(TeamSeasonAverage teamSA,
			List<TeamSeasonAverage> teamSAs) {
		Collections.sort(teamSAs, new sortByRebound());
		int reboundRanking = 0;
		for (TeamSeasonAverage t : teamSAs) {
			if (t.getTeam().equals(teamSA.getTeam())) {
				reboundRanking = (teamSAs.indexOf(t) + 1);
			}
		}
		return reboundRanking;
	}

	// 场均抢断联盟排名
	@SuppressWarnings("unchecked")
	private int getGrabRanking(TeamSeasonAverage teamSA,
			List<TeamSeasonAverage> teamSAs) {
		Collections.sort(teamSAs, new sortByGrab());
		int grabRanking = 0;
		for (TeamSeasonAverage t : teamSAs) {
			if (t.getTeam().equals(teamSA.getTeam())) {
				grabRanking = (teamSAs.indexOf(t) + 1);
			}
		}
		return grabRanking;
	}

	// 场均盖帽联盟排名
	@SuppressWarnings("unchecked")
	private int getBlockRanking(TeamSeasonAverage teamSA,
			List<TeamSeasonAverage> teamSAs) {
		Collections.sort(teamSAs, new sortByBlock());
		int blockRanking = 0;
		for (TeamSeasonAverage t : teamSAs) {
			if (t.getTeam().equals(teamSA.getTeam())) {
				blockRanking = (teamSAs.indexOf(t) + 1);
			}
		}
		return blockRanking;
	}

	// 场均失误联盟排名
	@SuppressWarnings("unchecked")
	private int getMistakeRanking(TeamSeasonAverage teamSA,
			List<TeamSeasonAverage> teamSAs) {
		Collections.sort(teamSAs, new sortByMistake());
		int mistakeRanking = 0;
		for (TeamSeasonAverage t : teamSAs) {
			if (t.getTeam().equals(teamSA.getTeam())) {
				mistakeRanking = (teamSAs.indexOf(t) + 1);
			}
		}
		return mistakeRanking;
	}

	// 场均得分排序
	@SuppressWarnings("rawtypes")
	class sortByScore implements Comparator {

		public int compare(Object o1, Object o2) {
			TeamSeasonAverage t1 = (TeamSeasonAverage) o1;
			TeamSeasonAverage t2 = (TeamSeasonAverage) o2;
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

	// 场均助攻排序
	@SuppressWarnings("rawtypes")
	class sortByAssistance implements Comparator {

		public int compare(Object o1, Object o2) {
			TeamSeasonAverage t1 = (TeamSeasonAverage) o1;
			TeamSeasonAverage t2 = (TeamSeasonAverage) o2;
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

	// 场均篮板排序
	@SuppressWarnings("rawtypes")
	class sortByRebound implements Comparator {

		public int compare(Object o1, Object o2) {
			TeamSeasonAverage t1 = (TeamSeasonAverage) o1;
			TeamSeasonAverage t2 = (TeamSeasonAverage) o2;
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

	// 场均抢断排序
	@SuppressWarnings("rawtypes")
	class sortByGrab implements Comparator {

		public int compare(Object o1, Object o2) {
			TeamSeasonAverage t1 = (TeamSeasonAverage) o1;
			TeamSeasonAverage t2 = (TeamSeasonAverage) o2;
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

	// 场均盖帽排序
	@SuppressWarnings("rawtypes")
	class sortByBlock implements Comparator {

		public int compare(Object o1, Object o2) {
			TeamSeasonAverage t1 = (TeamSeasonAverage) o1;
			TeamSeasonAverage t2 = (TeamSeasonAverage) o2;
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

	// 场均失误排序
	@SuppressWarnings("rawtypes")
	class sortByMistake implements Comparator {

		public int compare(Object o1, Object o2) {
			TeamSeasonAverage t1 = (TeamSeasonAverage) o1;
			TeamSeasonAverage t2 = (TeamSeasonAverage) o2;
			if (Double.parseDouble(t1.getMistake()) < Double.parseDouble(t2
					.getMistake())) {
				return 1;
			} else if (Double.parseDouble(t1.getMistake()) == Double
					.parseDouble(t2.getScore())) {
				return 0;
			}
			return -1;
		}

	}

}
