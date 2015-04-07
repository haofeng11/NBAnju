package edu.nju.nba.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.nju.nba.bean.Player;
import edu.nju.nba.bean.Team;
import edu.nju.nba.service.ITeamService;

@Controller
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private ITeamService teamService;

	private Map<String, Team> teams = new HashMap<String, Team>();

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
	@RequestMapping(value="/{teamName}",method=RequestMethod.GET)
	public String show(@PathVariable String teamName,Model model){
		
        Team team=teamService.show(teamName);
        
	    System.out.println(team.toString());       
		return "";
	}
	
//	//添加一支球队
//	public String add(){
////		Team team =new Team(1, "金州勇士", "太平洋区", "1946", "加利福尼亚州奥克兰市", "甲骨文球馆（Oracle Arena ）", "乔-拉科布、皮特-古伯", "史蒂夫·科尔", "威尔特-张伯伦、里克-巴里、克里斯-穆林、斯蒂芬-库里", 20, 5, 3, 18, "70/13");
////		teamService.add(team);
//		return "";
//	}

	
	
}
