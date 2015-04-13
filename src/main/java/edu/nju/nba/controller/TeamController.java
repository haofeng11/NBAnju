package edu.nju.nba.controller;

import java.io.IOException;

import java.io.PrintWriter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
	int scoreRanking ;
	// 场均助攻联盟排名
	int assistanceRanking ;
	// 场均篮板联盟排名
	int reboundRanking ;
	// 场均抢断联盟排名
	int grabRanking ;
	// 场均盖帽联盟排名
	int blockRanking ;
	// 场均失误联盟排名
	int mistakeRanking ;

	// private Map<String, Team> teams = new HashMap<String, Team>();
	private List<Team> teams = new ArrayList<Team>();

	public TeamController() {

	}

	/**
	 * 得到所有球队基本信息
	 */
	@RequestMapping(value = "/teams", method = RequestMethod.GET)
	public String list(Model model) {
		System.out.println("test");
		List<Team> teamList = teamService.list();
		for (int i = 0; i < teamList.size(); i++) {
			System.out.println(teamList.get(i).toString());
		}
		model.addAttribute("teams", teams);
		return "/teams.jsp";
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
        System.out.println(teamName);
		// 得到球队最新赛季的平均数据
		TeamSeasonAverage teamSA = getSeasonAverage(teamName, "14-15");
		model.addAttribute("teamSA", teamSA);
		List<TeamSeasonAverage> teamSAs = teamService
				.getSeasonAverageList("14-15");

		// 场均得分联盟排名
		scoreRanking = getScoreRanking(teamSA, teamSAs);
		model.addAttribute("scoreRanking", scoreRanking);
		// 场均助攻联盟排名
		assistanceRanking = getAssistance(teamSA, teamSAs);
		model.addAttribute("assistanceRanking", assistanceRanking);
		// 场均篮板联盟排名
		reboundRanking = getRebound(teamSA, teamSAs);
		model.addAttribute("reboundRanking", reboundRanking);
		// 场均抢断联盟排名
		grabRanking = getGrab(teamSA, teamSAs);
		model.addAttribute("grabRanking", grabRanking);
		// 场均盖帽联盟排名
		blockRanking = getBlock(teamSA, teamSAs);
		model.addAttribute("blockRanking", blockRanking);
		// 场均失误联盟排名
		mistakeRanking = getMistake(teamSA, teamSAs);
		model.addAttribute("mistakeRanking", mistakeRanking);

		// 得到球队基本信息
		Team team = teamService.show(teamName);
		model.addAttribute(team);

		// 得到球队历任球星
		String[] teamStars = team.getTeamStar().split(":");
		model.addAttribute("teamStars", teamStars);
		
		//球队本赛季数据
		List<TeamSingleGame> teamSingleGames=teamService.getTeamSingleGames(teamName.split("队")[0], "14-15");
//		for (TeamSingleGame t:teamSingleGames) {
//			System.out.println(t.getGameDate());
//		}
        model.addAttribute("teamSingleGames", teamSingleGames);
  
        double scoreSum=0;//总得分
        double shootSum=0;//总出手数
        double shootPercentageSum=0;//总命中率
        double threeScoreSum=0;//总三分得分
        double threeSum=0;//总三分出手
        double threePercentageSum=0;//总三分命中率
		for (TeamSingleGame t:teamSingleGames) {
			scoreSum+=Double.parseDouble(t.getScore());
			shootSum+=Double.parseDouble(t.getShootTotal());			
			shootPercentageSum+=(Double.parseDouble(t.getShootPercentage().replace("%",""))*0.01);
			threeScoreSum+=(Double.parseDouble(t.getThreeHit())*3);
			threeSum+=Double.parseDouble(t.getThreeTotal());
			threePercentageSum+=(Double.parseDouble(t.getThreePercentage().replace("%",""))*0.01);
	    }
		 DecimalFormat df = new DecimalFormat("#.00");
	    //平均得分
		String scoreAverage=df.format(scoreSum/teamSingleGames.size());
		model.addAttribute("scoreAverage", scoreAverage);
        //平均出手数
		String shootAverage=df.format(shootSum/teamSingleGames.size());
		model.addAttribute("shootAverage", shootAverage);
        //平均命中率
		NumberFormat fmt = NumberFormat.getPercentInstance();  
		fmt.setMaximumFractionDigits(2);//最多两位百分小数，如25.23%  
		String shootPercentageAverage=fmt.format(shootPercentageSum/teamSingleGames.size());
		model.addAttribute("shootPercentageAverage", shootPercentageAverage);
        //平均三分得分
		String threeScoreAverage=df.format(threeScoreSum/teamSingleGames.size());
		model.addAttribute("threeScoreAverage", threeScoreAverage);
        //平均三分出手
		String threeAverage=df.format(threeSum/teamSingleGames.size());
		model.addAttribute("threeAverage", threeAverage);
        //平均三分命中率
		String threePercentageAverage=fmt.format(threePercentageSum/teamSingleGames.size());
		model.addAttribute("threePercentageAverage", threePercentageAverage);
		
//		System.out.println(scoreSum);
//		System.out.println(shootSum);
//		System.out.println(shootPercentageSum);
//		System.out.println(threeScoreSum);
//		System.out.println(threeSum);
//		System.out.println(threePercentageSum);
//		System.out.println(scoreAverage);
//		System.out.println(shootAverage);
//		System.out.println(shootPercentageAverage);
//		System.out.println(threeScoreAverage);
//		System.out.println(threeAverage);
//		System.out.println(threePercentageAverage);
		return "TeamInfo";
	}

	// 得到球队赛季平均数据
	public TeamSeasonAverage getSeasonAverage(String teamName, String seasonID) {
		TeamSeasonAverage seasonAverage = teamService.getSeasonAverage(
				teamName, seasonID);
		return seasonAverage;

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
	private int getAssistance(TeamSeasonAverage teamSA,
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
	private int getRebound(TeamSeasonAverage teamSA,
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
	private int getGrab(TeamSeasonAverage teamSA,
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
	private int getBlock(TeamSeasonAverage teamSA,
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
	private int getMistake(TeamSeasonAverage teamSA,
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
