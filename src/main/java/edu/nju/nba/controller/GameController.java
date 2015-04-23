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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.nju.nba.bean.Game;
import edu.nju.nba.bean.PlayerDataStatistics;
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
		calendar.add(Calendar.DATE, -1);
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

		// get data
		List<TeamGameRecord> records = gameService.listFederalBoard(seasonId);
		//球队排名
		List<TeamGameRecord> regularEastRankGameRecords =gameService.getRegularEastRank(seasonId);
		List<TeamGameRecord> regularWestRankGameRecords =gameService.getRegularWestRank(seasonId);
		List<TeamGameRecord> playoffEastRankGameRecords =gameService.getPlayoffEastRank(seasonId);
		List<TeamGameRecord> playoffWestRankGameRecords =gameService.getPlayoffWestRank(seasonId);

		List<Game> gameSchedule = gameService.listGameSchedule(seasonId, gameDate);
		//球员常规赛数据榜
		List<PlayerDataStatistics> playerScoreRank= playerService.getPlayerScoreRankingList(seasonId);
		List<PlayerDataStatistics> playerReboundRank= playerService.getPlayerReboundRankingList(seasonId);
		List<PlayerDataStatistics> playerAssistanceRank= playerService.getPlayerAssistanceRankingList(seasonId);
		List<PlayerDataStatistics> playerGrabRank= playerService.getPlayerGrabRankingList(seasonId);
		List<PlayerDataStatistics> playerThreehitRank= playerService.getPlayerThreehitRankingList(seasonId);
		List<PlayerDataStatistics> playerBlockRank= playerService.getPlayerBlockRankingList(seasonId);
		//球员季后赛数据榜
		List<PlayerDataStatistics> playerOffScoreRank= playerService.getPlayerScoreRankingOffList(seasonId);
		List<PlayerDataStatistics> playerOffReboundRank= playerService.getPlayerReboundRankingOffList(seasonId);
		List<PlayerDataStatistics> playerOffAssistanceRank= playerService.getPlayerAssistanceRankingOffList(seasonId);
		List<PlayerDataStatistics> playerOffGrabRank= playerService.getPlayerGrabRankingOffList(seasonId);
		List<PlayerDataStatistics> playerOffThreehitRank= playerService.getPlayerThreehitRankingOffList(seasonId);
		List<PlayerDataStatistics> playerOffBlockRank= playerService.getPlayerBlockRankingOffList(seasonId);
		
		// add into view
		//添加联盟排名
		view.addObject("records", records);
		view.addObject("regularEastRankGameRecords", regularEastRankGameRecords);
		view.addObject("regularWestRankGameRecords", regularWestRankGameRecords);
		view.addObject("playoffEastRankGameRecords", playoffEastRankGameRecords);
		view.addObject("playoffWestRankGameRecords", playoffWestRankGameRecords);

		//添加比赛列表
		view.addObject("gameSchedule", gameSchedule);
		//添加常规赛球员赛季数据榜
		view.addObject("playerScoreRank", playerScoreRank);
		view.addObject("playerReboundRank", playerReboundRank);
		view.addObject("playerAssistanceRank", playerAssistanceRank);
		view.addObject("playerGrabRank", playerGrabRank);
		view.addObject("playerThreehitRank", playerThreehitRank);
		view.addObject("playerBlockRank", playerBlockRank);
		//添加季后赛球员赛季数据榜
		view.addObject("playerOffScoreRank", playerOffScoreRank);
		view.addObject("playerOffReboundRank", playerOffReboundRank);
		view.addObject("playerOffAssistanceRank", playerOffAssistanceRank);
		view.addObject("playerOffGrabRank", playerOffGrabRank);
		view.addObject("playerOffThreehitRank", playerOffThreehitRank);
		view.addObject("playerOffBlockRank", playerOffBlockRank);
		
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
