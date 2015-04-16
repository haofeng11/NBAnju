package edu.nju.nba.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.orm.hibernate4.HibernateTemplate;

import edu.nju.nba.dao.IGeneralDao;

/**
 * 这个类将dao成封装成了一个操作类，从网上复制过来的。
 */
@Repository
public class GeneralDao implements IGeneralDao {
	/**
	 * 这个bean里面需要注入sessionFactory，所以把这个bean写在了配置中。
	 */
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public <T> T findById(Class<T> type, Serializable id) {
		return hibernateTemplate.get(type, id);
	}

	public <T> List<T> findAll(Class<T> type) {
		return hibernateTemplate.loadAll(type);
	}

	public void save(Object... entities) {
		for (Object entity : entities) {
			hibernateTemplate.save(entity);
		}
	}

	public void saveOrUpdate(Object entity) {
		hibernateTemplate.saveOrUpdate(entity);
	}

	public void update(Object... entities) {
		for (Object entity : entities) {
			hibernateTemplate.update(entity);
		}
	}

	public void delete(Object... entities) {
		for (Object entity : entities) {
			if (entity != null) {
				hibernateTemplate.delete(entity);
			}
		}
	}

	public void deleteById(Class<?> type, Serializable id) {
		if (id == null) {
			return;
		}
		Object entity = findById(type, id);
		if (entity == null) {
			return;
		}
		delete(entity);
	}

	public void refresh(Object... entities) {
		for (Object entity : entities) {
			hibernateTemplate.refresh(entity);
		}
	}

	public void flush() {
		hibernateTemplate.flush();
	}

	
	public Object find(String queryString, Object value) {
		return hibernateTemplate.find(queryString, value).get(0);
	}

	
	public Object find2(String queryString, String value1, String value2) {
		Object[] values=new String[]{value1,value2};
		return hibernateTemplate.find(queryString, values).get(0);
	}

	
	public Object find3(String queryString, String value1, String value2,
			String value3) {
		Object[] values=new String[]{value1,value2,value3};
		return hibernateTemplate.find(queryString, values).get(0);
	}

	
	public Object find4(String queryString, String value1, String value2,
			String value3, String value4) {
		Object[] values=new String[]{value1,value2,value3,value4};
		return hibernateTemplate.find(queryString, values).get(0);
	}

	
	public Object findList(String queryString, Object value) {
		return hibernateTemplate.find(queryString, value);
	}

	public Object findList2(String queryString, String value1, String value2) {
		Object[] values=new String[]{value1,value2};
		return hibernateTemplate.find(queryString, values);
	}

	public Object findList3(String queryString, String value1, String value2,
			String value3) {
		Object[] values=new String[]{value1,value2,value3};
		return hibernateTemplate.find(queryString, values);
	}

	public Object findList4(String queryString, String value1, String value2,
			String value3, String value4) {
		Object[] values=new String[]{value1,value2,value3,value4};
		return hibernateTemplate.find(queryString, values);
	}
	
	

}
