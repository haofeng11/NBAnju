package edu.nju.nba.controller;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.nju.nba.bean.Game;
import edu.nju.nba.bean.PlayerSingleGame;
import edu.nju.nba.bean.TeamGameRecord;
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
	@Autowired
	private PlayerController playerController;

	// 跳转到比赛界面
	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public String games(Model model) {
		return "game";

	}

	//比赛默认获取本日信息
	@RequestMapping(value = "/game", method = RequestMethod.GET)
	public ModelAndView showGame(HttpServletRequest request,
			HttpServletResponse response) {
		// init view
		ModelAndView view = new ModelAndView();
		// get game data
		List<TeamGameRecord> records = gameService.listFederalBoard("14-15");
		
		Calendar calendar = Calendar.getInstance();
//		calendar.add(Calendar.MONTH, -1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(calendar.getTime());
		List<Game> gameSchedule = gameService.listGameSchedule("14-15", today);
		System.out.println(records.size());
		// add into view
		view.addObject("records", records);
		//添加比赛列表
		view.addObject("gameSchedule", gameSchedule);
		// set view name
		view.setViewName("game");

		// return view
		return view;
	}


	//选择日期后刷新页面
	@RequestMapping(value = "/gameSchedule", method = RequestMethod.GET)
	public ModelAndView showGameSchedule(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {
		// init view
		ModelAndView view = new ModelAndView();
		//得到赛季seasonId和日期gameDate
		String season = request.getParameter("seasonId");
		String date = request.getParameter("date");
		String[] seasonArr=season.split(" ");
		String seasonId=seasonArr[0];
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date temp = sdf.parse(date);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		String gameDate = sdf2.format(temp);

		// get game data
		List<TeamGameRecord> records = gameService.listFederalBoard(seasonId);
		List<Game> gameSchedule = gameService.listGameSchedule(seasonId, gameDate);
		// add into view
		//添加联盟排名
		view.addObject("records", records);
		//添加比赛列表
		view.addObject("gameSchedule", gameSchedule);
		
		view.setViewName("game");

		return view;
	}
	
	// 跳转到赛后数据界面
	@RequestMapping(value = "/match", method = RequestMethod.POST)
	public ModelAndView matchStatus(String seasonID,String gameDate,String homeTeam,String guestTeam, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView();
		Game game = gameService.show(seasonID, gameDate, homeTeam, guestTeam);
		String homeTeamPicture = teamService.show(game.getHomeTeam() + "队")
				.getPicture();
		String guestTeamPicture = teamService.show(game.getGuestTeam() + "队")
				.getPicture();
		view.addObject("game", game);
		view.addObject("homeTeamPicture", homeTeamPicture);
		view.addObject("guestTeamPicture", guestTeamPicture);

		// 赛后球队总数据
		TeamSingleGame homeTeamData = teamService.getTeamSingleGame(homeTeam,
				seasonID, gameDate, "0");
		TeamSingleGame guestTeamData = teamService.getTeamSingleGame(guestTeam,
				seasonID, gameDate, "0");

		view.addObject("homeTeamData", homeTeamData);
		view.addObject("guestTeamData", guestTeamData);
		// 赛后球员个人数据
		List<PlayerSingleGame> homePlayerList = playerService
				.getPlayerSingleGames(homeTeam, seasonID, gameDate);
		List<PlayerSingleGame> guestPlayerList = playerService
				.getPlayerSingleGames(guestTeam, seasonID, gameDate);
		view.addObject("homePlayerList", homePlayerList);
		view.addObject("guestPlayerList", guestPlayerList);
		view.setViewName("matchstat");
		return view;
	}

}
