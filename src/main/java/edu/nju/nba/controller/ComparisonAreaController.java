package edu.nju.nba.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.nju.nba.bean.TeamSeasonAverage;
import edu.nju.nba.service.ITeamService;

@Controller
public class ComparisonAreaController {

	@Autowired
	private ITeamService teamService;
	
	@RequestMapping(value = "/comparisonArea", method = RequestMethod.GET)
	public ModelAndView showAreaComparison(HttpServletRequest request,HttpServletResponse response){
		// init view
		ModelAndView view = new ModelAndView();
		
		
		// get game data
		TeamSeasonAverage westAverage02=teamService.getDistrictSeasonAverages("02-03", "西部");
		TeamSeasonAverage westAverage03=teamService.getDistrictSeasonAverages("03-04", "西部");
		TeamSeasonAverage westAverage04=teamService.getDistrictSeasonAverages("04-05", "西部");
		TeamSeasonAverage westAverage05=teamService.getDistrictSeasonAverages("05-06", "西部");
		TeamSeasonAverage westAverage06=teamService.getDistrictSeasonAverages("06-07", "西部");
		TeamSeasonAverage westAverage07=teamService.getDistrictSeasonAverages("07-08", "西部");
		TeamSeasonAverage westAverage08=teamService.getDistrictSeasonAverages("08-09", "西部");
		TeamSeasonAverage westAverage09=teamService.getDistrictSeasonAverages("09-10", "西部");
		TeamSeasonAverage westAverage10=teamService.getDistrictSeasonAverages("10-11", "西部");
		TeamSeasonAverage westAverage11=teamService.getDistrictSeasonAverages("11-12", "西部");
		TeamSeasonAverage westAverage12=teamService.getDistrictSeasonAverages("12-13", "西部");
		TeamSeasonAverage westAverage13=teamService.getDistrictSeasonAverages("13-14", "西部");
		TeamSeasonAverage westAverage14=teamService.getDistrictSeasonAverages("14-15", "西部");
		TeamSeasonAverage eastAverage02=teamService.getDistrictSeasonAverages("02-03", "东部");
		TeamSeasonAverage eastAverage03=teamService.getDistrictSeasonAverages("03-04", "东部");
		TeamSeasonAverage eastAverage04=teamService.getDistrictSeasonAverages("04-05", "东部");
		TeamSeasonAverage eastAverage05=teamService.getDistrictSeasonAverages("05-06", "东部");
		TeamSeasonAverage eastAverage06=teamService.getDistrictSeasonAverages("06-07", "东部");
		TeamSeasonAverage eastAverage07=teamService.getDistrictSeasonAverages("07-08", "东部");
		TeamSeasonAverage eastAverage08=teamService.getDistrictSeasonAverages("08-09", "东部");
		TeamSeasonAverage eastAverage09=teamService.getDistrictSeasonAverages("09-10", "东部");
		TeamSeasonAverage eastAverage10=teamService.getDistrictSeasonAverages("10-11", "东部");
		TeamSeasonAverage eastAverage11=teamService.getDistrictSeasonAverages("11-12", "东部");
		TeamSeasonAverage eastAverage12=teamService.getDistrictSeasonAverages("12-13", "东部");
		TeamSeasonAverage eastAverage13=teamService.getDistrictSeasonAverages("13-14", "东部");
		TeamSeasonAverage eastAverage14=teamService.getDistrictSeasonAverages("14-15", "东部");

		// add into view
		view.addObject("westAverage02",westAverage02);
		view.addObject("westAverage03",westAverage03);
		view.addObject("westAverage04",westAverage04);
		view.addObject("westAverage05",westAverage05);
		view.addObject("westAverage06",westAverage06);
		view.addObject("westAverage07",westAverage07);
		view.addObject("westAverage08",westAverage08);
		view.addObject("westAverage09",westAverage09);
		view.addObject("westAverage10",westAverage10);
		view.addObject("westAverage11",westAverage11);
		view.addObject("westAverage12",westAverage12);
		view.addObject("westAverage13",westAverage13);
		view.addObject("westAverage14",westAverage14);
		view.addObject("eastAverage02",eastAverage02);
		view.addObject("eastAverage03",eastAverage03);
		view.addObject("eastAverage04",eastAverage04);
		view.addObject("eastAverage05",eastAverage05);
		view.addObject("eastAverage06",eastAverage06);
		view.addObject("eastAverage07",eastAverage07);
		view.addObject("eastAverage08",eastAverage08);
		view.addObject("eastAverage09",eastAverage09);
		view.addObject("eastAverage10",eastAverage10);
		view.addObject("eastAverage11",eastAverage11);
		view.addObject("eastAverage12",eastAverage12);
		view.addObject("eastAverage13",eastAverage13);
		view.addObject("eastAverage14",eastAverage14);
		
		// set view name
		view.setViewName("comparison_area");
		
		// return view
		return view;
		
	}
}
