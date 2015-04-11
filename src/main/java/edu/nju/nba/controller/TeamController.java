package edu.nju.nba.controller;



import java.util.ArrayList;
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
import edu.nju.nba.service.ITeamService;

@Controller
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private ITeamService teamService;

	//private Map<String, Team> teams = new HashMap<String, Team>();
	private List<Team> teams=new ArrayList<Team>();

	public TeamController() {

	}
	
	/**
	 * 得到所有球队基本信息
	 */
	@RequestMapping(value="/teams",method=RequestMethod.GET)
	public String list(Model model){
		System.out.println("test");
		List<Team> teamList=teamService.list();
		for (int i = 0; i < teamList.size(); i++) {
			System.out.println(teamList.get(i).toString());
		}
		model.addAttribute("teams", teams);
		return "/teams.jsp";		
	}
	
	/**
	 * 根据球队姓名查找球队
	 * return 球队信息
	 * PS：球队姓名唯一
	 */
	@RequestMapping(value="/find",method=RequestMethod.GET,params="tt")
	@ResponseBody
	public Team show(@PathVariable String teamName){
		System.out.println("ttt");
		System.out.println(teamName);
        Team team=teamService.show(teamName);
        
	    System.out.println(team.toString());       
		return team;
	}
	
	@RequestMapping(value="/{teamName}",method=RequestMethod.GET)
    public String show(@PathVariable String teamName,Model model){
		
		//得到球队最新赛季的平均数据
		TeamSeasonAverage teamSA=getSeasonAverage(teamName,"14-15");
		System.out.println(teamSA.toString());
	    
		model.addAttribute("teamSA",teamSA);
		//得到球队基本信息
		Team team=teamService.show(teamName);
		model.addAttribute(team);

    	return "TeamInfo";
    }
	
	//得到球队赛季平均数据
	public TeamSeasonAverage getSeasonAverage(String teamName,String seasonID){
		TeamSeasonAverage seasonAverage=teamService.getSeasonAverage(teamName, seasonID);
		return seasonAverage;
		
	}

	
	
}
