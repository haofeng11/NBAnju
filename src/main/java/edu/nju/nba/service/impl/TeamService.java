package edu.nju.nba.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nju.nba.bean.Team;
import edu.nju.nba.bean.TeamSeasonAverage;
import edu.nju.nba.bean.TeamSingleGame;
import edu.nju.nba.dao.IGeneralDao;
import edu.nju.nba.service.ITeamService;

@Service
public class TeamService implements ITeamService {

	@Autowired
	private IGeneralDao generalDao;
	
	DecimalFormat    df   = new DecimalFormat("######0.00");   
	
	
	public Team show(String teamName) {
		teamName="%"+teamName+"%";
		return (Team) generalDao.find(
				"from edu.nju.nba.bean.Team t where t.cName like ?", teamName);
	}

	public List<Team> list() {
		return generalDao.findAll(Team.class);
	}

	public TeamSeasonAverage getSeasonAverage(String teamName, String seasonID,
			String tag) {
		teamName="%"+teamName+"%";
		seasonID="%"+seasonID+"%";
		tag="%"+tag+"%";
		return (TeamSeasonAverage) generalDao
				.find3("from edu.nju.nba.bean.TeamSeasonAverage t where t.team like ? and t.seasonID like ? and tag like ?",
						teamName, seasonID, tag);
	}

	@SuppressWarnings("unchecked")
	public List<TeamSeasonAverage> getSeasonAverageList(String seasonID,
			String tag) {
		seasonID="%"+seasonID+"%";
		tag="%"+tag+"%";
		return (List<TeamSeasonAverage>) generalDao
				.findList2(
						"from edu.nju.nba.bean.TeamSeasonAverage t where t.seasonID like ? and tag like ?",
						seasonID, tag);
	}

	@SuppressWarnings("unchecked")
	public List<TeamSingleGame> getTeamSingleGames(String teamName,
			String seasonID, String tag) {
		teamName="%"+teamName+"%";
		seasonID="%"+seasonID+"%";
		tag="%"+tag+"%";
		return (List<TeamSingleGame>) generalDao
				.findList3(
						"from edu.nju.nba.bean.TeamSingleGame t where t.team like ? and t.seasonID like ? and tag like ?",
						teamName, seasonID, tag);
	}

	public TeamSingleGame getTeamSingleGame(String teamName, String seasonID,
			String gameDate, String tag) {
		teamName="%"+teamName+"%";
		seasonID="%"+seasonID+"%";
		tag="%"+tag+"%";
		return (TeamSingleGame) generalDao
				.find4("from edu.nju.nba.bean.TeamSingleGame t where t.team like ? and t.seasonID like ? and t.gameDate like ? and tag like ?",
						teamName, seasonID, gameDate, tag);
	}


	public TeamSeasonAverage getDistrictSeasonAverages(String seasonID,
			String district) {
		// 某赛季分区平均数据
		TeamSeasonAverage districSeasonAverage=new TeamSeasonAverage();
		// 某赛季分区赛季平均list
		List<TeamSeasonAverage> districtSeasonAverages = new ArrayList<TeamSeasonAverage>();
		// 某赛季所有球队平均数据
		@SuppressWarnings("unchecked")
		List<TeamSeasonAverage> teamSeasonAverages = (List<TeamSeasonAverage>) generalDao
				.findList(
						"from edu.nju.nba.bean.TeamSeasonAverage tsa where tsa.tag='0' and tsa.seasonID=?",
						seasonID);
				
		for (int i = 0; i < teamSeasonAverages.size(); i++) {
			String teamName = teamSeasonAverages.get(i).getTeam();
			System.out.println(teamName+"-------teamName-----");
			String value="%"+teamName+"%";
			Team team = (Team) generalDao.find(
					"from edu.nju.nba.bean.Team t where t.cName like ?", value);
			String tempTeamDistrict = team.getTeamDistrict().substring(0, 2);
			
			if (tempTeamDistrict.equals(district)) {
				districtSeasonAverages.add(teamSeasonAverages.get(i));
			}

		}

		double totalRebound=0.0;
		double totalAssistance=0.0;
		double totalGrab=0.0;
		double totalBlock=0.0;
		double totalScore=0.0;
		double totalMistake=0.0;
		double totalFoul=0.0;
		
		for (int j = 0; j < districtSeasonAverages.size(); j++) {
			totalScore+=Double.valueOf(districtSeasonAverages.get(j).getScore());
			totalRebound+=Double.valueOf(districtSeasonAverages.get(j).getRebound());
			totalAssistance+=Double.valueOf(districtSeasonAverages.get(j).getAssistance());
			totalGrab+=Double.valueOf(districtSeasonAverages.get(j).getGrab());
			totalBlock+=Double.valueOf(districtSeasonAverages.get(j).getBlock());
			totalMistake+=Double.valueOf(districtSeasonAverages.get(j).getMistake());
			totalFoul+=Double.valueOf(districtSeasonAverages.get(j).getFoul());
		}
		
		int NumOfTeams=districtSeasonAverages.size();
		
		
		districSeasonAverage.setSeasonID(seasonID);
		districSeasonAverage.setScore(df.format(totalScore/NumOfTeams)+"");
		districSeasonAverage.setRebound(df.format(totalRebound/NumOfTeams)+"");
		districSeasonAverage.setAssistance(df.format(totalAssistance/NumOfTeams)+"");
		districSeasonAverage.setGrab(df.format(totalGrab/NumOfTeams)+"");
		districSeasonAverage.setBlock(df.format(totalBlock/NumOfTeams)+"");
		districSeasonAverage.setMistake(df.format(totalMistake/NumOfTeams)+"");
		districSeasonAverage.setFoul(df.format(totalFoul/NumOfTeams)+"");
		
		return districSeasonAverage;
	}

	@SuppressWarnings("unchecked")
	public List<Team> searchTeam(String name) {
		String value="%"+name+"%";
		return (List<Team>)generalDao.findList("from edu.nju.nba.bean.Team t where t.cName like ?", value);
	}

}
