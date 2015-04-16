package edu.nju.nba.dao;

import java.io.Serializable;
import java.util.List;

public interface IGeneralDao {
	
	public <T> T findById(Class<T> type, Serializable id);  
	  
    public <T> List<T> findAll(Class<T> type);  
  
    public void save(Object... entities);  
  
    public void update(Object... entities);  
  
    public void saveOrUpdate(Object entity);  
  
    public void delete(Object... entities);  
  
    public void deleteById(Class<?> type, Serializable id);  
  
    public void refresh(Object... entities);  
  
    public void flush();
    
    public Object find(String queryString, Object value);
    
    public Object find2(String queryString, String value1,String value2);
    
    public Object find3(String queryString, String value1,String value2,String value3);
    
    public Object find4(String queryString, String value1,String value2,String value3,String value4);
    
    public Object findList(String queryString, Object value);
    
    public Object findList2(String queryString, String value1,String value2);
    
    public Object findList3(String queryString, String value1,String value2,String value3);
    
    public Object findList4(String queryString, String value1,String value2,String value3,String value4);

}
