package edu.nju.nba.bean;

import java.util.Date;

/**
 * @className Player
 * @description 球员类
 * @author 作者: fenghao
 * @date 创建时间：2015年3月31日 上午9:56:37
 */

public class Player {

	private Integer id;
	private String Playername;
	private String birthday;
	private double height;
	private double weight;
	// 球队
	private String team;
	// 选秀
	private String draft;
	// 出生地
	private String birthplace;
	// 位置
	private String position;

	// //单赛季平均数据
	// private PlayerSeasonData playerSeasonData;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlayername() {
		return Playername;
	}

	public void setPlayername(String playername) {
		Playername = playername;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getDraft() {
		return draft;
	}

	public void setDraft(String draft) {
		this.draft = draft;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
