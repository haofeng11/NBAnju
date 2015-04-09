package edu.nju.nba.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import edu.nju.nba.bean.Team;
import edu.nju.nba.dao.ITeamDao;

@Repository
public class TeamDao implements ITeamDao {

	/**
	 * 这个bean里面需要注入sessionFactory，所以把这个bean写在了配置中。
	 */
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public Team findByName(String queryString, Object value) {
		return (Team)hibernateTemplate.find(queryString, value).get(0);
	}

}
