package edu.nju.nba.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.nju.nba.bean.Game;
import edu.nju.nba.bean.PlayerSingleGame;
import edu.nju.nba.bean.TeamSingleGame;
import edu.nju.nba.service.IGameService;
import edu.nju.nba.service.IPlayerService;
import edu.nju.nba.service.ITeamService;

@Controller
@RequestMapping("/game")
public class GameController {

	@Autowired
	private IGameService gameService;
	@Autowired
	private ITeamService teamService;
	@Autowired
	private IPlayerService playerService;
	
	//跳转到比赛界面
	@RequestMapping(value="/games",method=RequestMethod.GET)
	public String games(Model model) {
		return "game";
		
	}
	
	//跳转到赛后数据界面
	@RequestMapping(value="/{seasonID}/{gameDate}/{homeTeam}/{guestTeam}",method=RequestMethod.GET)
	public String matchstat(@PathVariable String seasonID,@PathVariable String gameDate,@PathVariable String homeTeam,@PathVariable String guestTeam,Model model){
		Game game=gameService.show(seasonID, gameDate, homeTeam, guestTeam);
		String homeTeamPicture=teamService.show(game.getHomeTeam()+"队").getPicture();
		String guestTeamPicture=teamService.show(game.getGuestTeam()+"队").getPicture();
		model.addAttribute("game", game);
		model.addAttribute("homeTeamPicture", homeTeamPicture);
		model.addAttribute("guestTeamPicture", guestTeamPicture);
		

		//赛后球队平均数据
		TeamSingleGame homeTeamData=teamService.getTeamSingleGame(homeTeam, seasonID,gameDate,"0");
		TeamSingleGame guestTeamData=teamService.getTeamSingleGame(guestTeam, seasonID,gameDate,"0");

		model.addAttribute("homeTeamData", homeTeamData);
		model.addAttribute("guestTeamData", guestTeamData);
		//赛后球员个人数据
		List<PlayerSingleGame> homePlayerList=playerService.getPlayerSingleGames(homeTeam, seasonID, gameDate);
		List<PlayerSingleGame> guestPlayerList=playerService.getPlayerSingleGames(guestTeam, seasonID, gameDate);
		model.addAttribute("homePlayerList", homePlayerList);
		model.addAttribute("guestPlayerList", guestPlayerList);
		return "matchstat";
	}
	
	
	
}
