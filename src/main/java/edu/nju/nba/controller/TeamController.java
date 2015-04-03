package edu.nju.nba.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.nju.nba.bean.Player;
import edu.nju.nba.bean.Team;
import edu.nju.nba.service.ITeamService;

@Controller
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private ITeamService teamService;
	
	private Map<String, Team> players=new HashMap<String, Team>();
	
	
	
	
	
	
	
}
