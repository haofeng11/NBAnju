package edu.nju.nba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.nju.nba.service.IGameService;
import edu.nju.nba.service.ITeamService;

@Controller
@RequestMapping("/game")
public class GameController {

	@Autowired
	private IGameService gameService;
	
}
