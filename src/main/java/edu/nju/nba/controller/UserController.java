package edu.nju.nba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.nju.nba.bean.User;
import edu.nju.nba.service.IUserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	/**
	 * 注入userService。
	 * 如果userService继承了某个接口，
	 * 这里类型必须是接口IUserService，
	 * 不能是类UserService，不知道为什么。
	 */
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/registe", method=RequestMethod.GET)
	public String registe() {
		User user = new User(0, "小马云", "999");
		userService.registe(user);
		return "index";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add() {
		User user = new User(0, "马云", "939");
		userService.add(user);
		return "";
	}

}
