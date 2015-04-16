package edu.nju.nba.controller;

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

		//得到球队各个赛季的常规赛平均数据
		TeamSeasonAverage teamSA14 = teamService.getSeasonAverage(teamName, "14-15","0");
		TeamSeasonAverage teamSA13 = teamService.getSeasonAverage(teamName, "13-14","0");
		TeamSeasonAverage teamSA12 = teamService.getSeasonAverage(teamName, "12-13","0");
		TeamSeasonAverage teamSA11 = teamService.getSeasonAverage(teamName, "11-12","0");
		TeamSeasonAverage teamSA10 = teamService.getSeasonAverage(teamName, "10-11","0");
		TeamSeasonAverage teamSA09 = teamService.getSeasonAverage(teamName, "09-10","0");
		TeamSeasonAverage teamSA08 = teamService.getSeasonAverage(teamName, "08-09","0");
		TeamSeasonAverage teamSA07 = teamService.getSeasonAverage(teamName, "07-08","0");
		TeamSeasonAverage teamSA06 = teamService.getSeasonAverage(teamName, "06-07","0");
		TeamSeasonAverage teamSA05 = teamService.getSeasonAverage(teamName, "05-06","0");
		TeamSeasonAverage teamSA04 = teamService.getSeasonAverage(teamName, "04-05","0");
		TeamSeasonAverage teamSA03 = teamService.getSeasonAverage(teamName, "03-04","0");
		TeamSeasonAverage teamSA02 = teamService.getSeasonAverage(teamName, "02-03","0");
		model.addAttribute("teamSA14", teamSA14);
		model.addAttribute("teamSA13", teamSA13);
		model.addAttribute("teamSA12", teamSA12);
		model.addAttribute("teamSA11", teamSA11);
		model.addAttribute("teamSA10", teamSA10);
		model.addAttribute("teamSA09", teamSA09);
		model.addAttribute("teamSA08", teamSA08);
		model.addAttribute("teamSA07", teamSA07);
		model.addAttribute("teamSA06", teamSA06);
		model.addAttribute("teamSA05", teamSA05);
		model.addAttribute("teamSA04", teamSA04);
		model.addAttribute("teamSA03", teamSA03);
		model.addAttribute("teamSA02", teamSA02);

		//得到球队各个赛季的季后赛平均数据
		TeamSeasonAverage teamSA14PO= teamService.getSeasonAverage(teamName, "14-15","1");
		TeamSeasonAverage teamSA13PO= teamService.getSeasonAverage(teamName, "13-14","1");
		TeamSeasonAverage teamSA12PO= teamService.getSeasonAverage(teamName, "12-13","1");
		TeamSeasonAverage teamSA11PO= teamService.getSeasonAverage(teamName, "11-12","1");
		TeamSeasonAverage teamSA10PO= teamService.getSeasonAverage(teamName, "10-11","1");
		TeamSeasonAverage teamSA09PO= teamService.getSeasonAverage(teamName, "09-10","1");
		TeamSeasonAverage teamSA08PO= teamService.getSeasonAverage(teamName, "08-09","1");
		TeamSeasonAverage teamSA07PO= teamService.getSeasonAverage(teamName, "07-08","1");
		TeamSeasonAverage teamSA06PO= teamService.getSeasonAverage(teamName, "06-07","1");
		TeamSeasonAverage teamSA05PO= teamService.getSeasonAverage(teamName, "05-06","1");
		TeamSeasonAverage teamSA04PO= teamService.getSeasonAverage(teamName, "04-05","1");
		TeamSeasonAverage teamSA03PO= teamService.getSeasonAverage(teamName, "03-04","1");
		TeamSeasonAverage teamSA02PO= teamService.getSeasonAverage(teamName, "02-03","1");
		model.addAttribute("teamSA14PO", teamSA14PO);
		model.addAttribute("teamSA13PO", teamSA13PO);
		model.addAttribute("teamSA12PO", teamSA12PO);
		model.addAttribute("teamSA11PO", teamSA11PO);
		model.addAttribute("teamSA10PO", teamSA10PO);
		model.addAttribute("teamSA09PO", teamSA09PO);
		model.addAttribute("teamSA08PO", teamSA08PO);
		model.addAttribute("teamSA07PO", teamSA07PO);
		model.addAttribute("teamSA06PO", teamSA06PO);
		model.addAttribute("teamSA05PO", teamSA05PO);
		model.addAttribute("teamSA04PO", teamSA04PO);
		model.addAttribute("teamSA03PO", teamSA03PO);
		model.addAttribute("teamSA02PO", teamSA02PO);

		// 得到球队基本信息
		Team team = teamService.show(teamName);
		model.addAttribute(team);

		// 得到球队历任球星
		String[] teamStars = team.getTeamStar().split(":");
		model.addAttribute("teamStars", teamStars);
		
		List<TeamSeasonAverage> teamSAs = teamService.getSeasonAverageList("14-15","0");

		// 场均得分联盟排名
		scoreRanking = getScoreRanking(teamSA14, teamSAs);
		model.addAttribute("scoreRanking", scoreRanking);
		// 场均助攻联盟排名
		assistanceRanking = getAssistance(teamSA14, teamSAs);
		model.addAttribute("assistanceRanking", assistanceRanking);
		// 场均篮板联盟排名
		reboundRanking = getRebound(teamSA14, teamSAs);
		model.addAttribute("reboundRanking", reboundRanking);
		// 场均抢断联盟排名
		grabRanking = getGrab(teamSA14, teamSAs);
		model.addAttribute("grabRanking", grabRanking);
		// 场均盖帽联盟排名
		blockRanking = getBlock(teamSA14, teamSAs);
		model.addAttribute("blockRanking", blockRanking);
		// 场均失误联盟排名
		mistakeRanking = getMistake(teamSA14, teamSAs);
		model.addAttribute("mistakeRanking", mistakeRanking);
		
		//球队各个赛季常规赛单场比赛数据
		List<TeamSingleGame> teamSingleGames14=teamService.getTeamSingleGames(teamName.split("队")[0], "14-15","0");
        List<TeamSingleGame> teamSingleGames02=teamService.getTeamSingleGames(teamName.split("队")[0], "02-03","0");
        List<TeamSingleGame> teamSingleGames03=teamService.getTeamSingleGames(teamName.split("队")[0], "03-04","0");
        List<TeamSingleGame> teamSingleGames04=teamService.getTeamSingleGames(teamName.split("队")[0], "04-05","0");
        List<TeamSingleGame> teamSingleGames05=teamService.getTeamSingleGames(teamName.split("队")[0], "05-06","0");
        List<TeamSingleGame> teamSingleGames06=teamService.getTeamSingleGames(teamName.split("队")[0], "06-07","0");
        List<TeamSingleGame> teamSingleGames07=teamService.getTeamSingleGames(teamName.split("队")[0], "07-08","0");
        List<TeamSingleGame> teamSingleGames08=teamService.getTeamSingleGames(teamName.split("队")[0], "08-09","0");
        List<TeamSingleGame> teamSingleGames09=teamService.getTeamSingleGames(teamName.split("队")[0], "09-10","0");
        List<TeamSingleGame> teamSingleGames10=teamService.getTeamSingleGames(teamName.split("队")[0], "10-11","0");
        List<TeamSingleGame> teamSingleGames11=teamService.getTeamSingleGames(teamName.split("队")[0], "11-12","0");
        List<TeamSingleGame> teamSingleGames12=teamService.getTeamSingleGames(teamName.split("队")[0], "12-13","0");
        List<TeamSingleGame> teamSingleGames13=teamService.getTeamSingleGames(teamName.split("队")[0], "13-14","0");
        model.addAttribute("teamSingleGames14", teamSingleGames14);
        model.addAttribute("teamSingleGames02", teamSingleGames02);
        model.addAttribute("teamSingleGames03", teamSingleGames03);
        model.addAttribute("teamSingleGames04", teamSingleGames04);
        model.addAttribute("teamSingleGames05", teamSingleGames05);
        model.addAttribute("teamSingleGames06", teamSingleGames06);
        model.addAttribute("teamSingleGames07", teamSingleGames07);
        model.addAttribute("teamSingleGames08", teamSingleGames08);
        model.addAttribute("teamSingleGames09", teamSingleGames09);
        model.addAttribute("teamSingleGames10", teamSingleGames10);
        model.addAttribute("teamSingleGames11", teamSingleGames11);
        model.addAttribute("teamSingleGames12", teamSingleGames12);
        model.addAttribute("teamSingleGames13", teamSingleGames13);
        
        //球队各个赛季季后赛单场比赛数据
		List<TeamSingleGame> teamSingleGames14PO=teamService.getTeamSingleGames(teamName.split("队")[0], "14-15","1");
        List<TeamSingleGame> teamSingleGames02PO=teamService.getTeamSingleGames(teamName.split("队")[0], "02-03","1");
        List<TeamSingleGame> teamSingleGames03PO=teamService.getTeamSingleGames(teamName.split("队")[0], "03-04","1");
        List<TeamSingleGame> teamSingleGames04PO=teamService.getTeamSingleGames(teamName.split("队")[0], "04-05","1");
        List<TeamSingleGame> teamSingleGames05PO=teamService.getTeamSingleGames(teamName.split("队")[0], "05-06","1");
        List<TeamSingleGame> teamSingleGames06PO=teamService.getTeamSingleGames(teamName.split("队")[0], "06-07","1");
        List<TeamSingleGame> teamSingleGames07PO=teamService.getTeamSingleGames(teamName.split("队")[0], "07-08","1");
        List<TeamSingleGame> teamSingleGames08PO=teamService.getTeamSingleGames(teamName.split("队")[0], "08-09","1");
        List<TeamSingleGame> teamSingleGames09PO=teamService.getTeamSingleGames(teamName.split("队")[0], "09-10","1");
        List<TeamSingleGame> teamSingleGames10PO=teamService.getTeamSingleGames(teamName.split("队")[0], "10-11","1");
        List<TeamSingleGame> teamSingleGames11PO=teamService.getTeamSingleGames(teamName.split("队")[0], "11-12","1");
        List<TeamSingleGame> teamSingleGames12PO=teamService.getTeamSingleGames(teamName.split("队")[0], "12-13","1");
        List<TeamSingleGame> teamSingleGames13PO=teamService.getTeamSingleGames(teamName.split("队")[0], "13-14","1");
        model.addAttribute("teamSingleGames14PO", teamSingleGames14PO);
        model.addAttribute("teamSingleGames02PO", teamSingleGames02PO);
        model.addAttribute("teamSingleGames03PO", teamSingleGames03PO);
        model.addAttribute("teamSingleGames04PO", teamSingleGames04PO);
        model.addAttribute("teamSingleGames05PO", teamSingleGames05PO);
        model.addAttribute("teamSingleGames06PO", teamSingleGames06PO);
        model.addAttribute("teamSingleGames07PO", teamSingleGames07PO);
        model.addAttribute("teamSingleGames08PO", teamSingleGames08PO);
        model.addAttribute("teamSingleGames09PO", teamSingleGames09PO);
        model.addAttribute("teamSingleGames10PO", teamSingleGames10PO);
        model.addAttribute("teamSingleGames11PO", teamSingleGames11PO);
        model.addAttribute("teamSingleGames12PO", teamSingleGames12PO);
        model.addAttribute("teamSingleGames13PO", teamSingleGames13PO);
        
//		for (TeamSingleGame t:teamSingleGames) {
//		System.out.println(t.getGameDate());
//	}
  

		return "TeamInfo";
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
