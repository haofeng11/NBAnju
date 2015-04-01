package edu.nju.nba.bean;

import java.io.Serializable;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @className Player
 * @description 球员类
 * @author 作者: fenghao
 * @date 创建时间：2015年3月31日 上午9:56:37
 */

@Entity  
@Table 
public class Player implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//球员基本信息
	private Integer id;
	private String playername;
	private String birthday;
	private String height;
	private String weight;
	// 球队
	private String team;
	// 选秀
	private String draft;
	// 出生地
	private String birthplace;
	// 位置
	private String position;
    //本赛季薪水
	private String salary;
	//合同
	private String contract;
	//主要奖项
	private String prize;

	
	public Player() {
		super();
	}
	
	

	public Player(Integer id, String playername, String birthday,
			String height, String weight, String team, String draft,
			String birthplace, String position, String salary, String contract,
			String prize) {
		super();
		this.id = id;
		this.playername = playername;
		this.birthday = birthday;
		this.height = height;
		this.weight = weight;
		this.team = team;
		this.draft = draft;
		this.birthplace = birthplace;
		this.position = position;
		this.salary = salary;
		this.contract = contract;
		this.prize = prize;
	}



	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlayername() {
		return playername;
	}

	public void setPlayername(String playername) {
		this.playername = playername;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}
	
	
	public String toString() {
		return playername+" : "+position+" : "+team+" : "+prize;
	}

    

}
