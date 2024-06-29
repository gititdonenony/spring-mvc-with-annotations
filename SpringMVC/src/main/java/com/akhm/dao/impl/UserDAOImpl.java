package com.akhm.dao.impl;

import org.springframework.stereotype.Repository;

import com.akhm.dao.CustomHibernateDaoSupport;
import com.akhm.dao.UserDAO;
import com.akhm.dao.model.UserTl;

@Repository
public class UserDAOImpl extends CustomHibernateDaoSupport implements UserDAO {

	@Override
	public Integer insertUser(UserTl userTl) {

		return (Integer) getHibernateTemplate().save(userTl);
	}

}
