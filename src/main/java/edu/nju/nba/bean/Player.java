package edu.nju.nba.bean;

import java.io.Serializable;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @className Player
 * @description 球员类
 * @author 作者: fenghao
 * @date 创建时间：2015年3月31日 上午9:56:37
 */

@Entity
@Table(name = "player_base_info")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Player implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 球员基本信息
	private String playerID;
	private String cName;
	private String eName;
	private String height;
	private String weight;
	// 出生日期
	private String birthday;
	// 球队
	private String team;
	// 选秀
	private String draftInfo;
	// 出生地
	private String birthplace;
	// 位置
	private String position;
	// 球衣号码
	private String playerNumber;
	// 本赛季薪水
	private String salary;
	// 奖项
	private String price;
	// 图片地址
	private String picture;

	public Player() {
		super();
	}

	public Player(String playerID, String cName, String eName, String height,
			String weight, String birthday, String team, String draftInfo,
			String birthplace, String position, String playerNumber,
			String salary, String price, String picture) {
		super();
		this.playerID = playerID;
		this.cName = cName;
		this.eName = eName;
		this.height = height;
		this.weight = weight;
		this.birthday = birthday;
		this.team = team;
		this.draftInfo = draftInfo;
		this.birthplace = birthplace;
		this.position = position;
		this.playerNumber = playerNumber;
		this.salary = salary;
		this.price = price;
		this.picture = picture;
	}

	@Id
	@GeneratedValue
	public String getPlayerID() {
		return playerID;
	}

	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getDraftInfo() {
		return draftInfo;
	}

	public void setDraftInfo(String draftInfo) {
		this.draftInfo = draftInfo;
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

	public String getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(String playerNumber) {
		this.playerNumber = playerNumber;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String toString() {
		return cName + " : " + position + " : " + team + " : " + playerNumber;
	}

}
