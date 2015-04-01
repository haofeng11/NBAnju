package edu.nju.nba.service.impl;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.nju.nba.bean.User;
import edu.nju.nba.dao.IGeneralDao;
import edu.nju.nba.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IGeneralDao generalDao;
	
	/* 
	 * 这里要有事务注解，默认readOnly=true,不设置的话会报错。
	 * insert和update操作都要。
	 */
	
	@Transactional(readOnly=false)
	public boolean registe(User user) {
		generalDao.save(user);
		return false;
	}

}
