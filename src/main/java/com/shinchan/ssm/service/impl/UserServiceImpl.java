package com.shinchan.ssm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shinchan.ssm.dao.UserDao;
import com.shinchan.ssm.domain.User;
import com.shinchan.ssm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	@Override
	    public User getUserById(int userId) {
	        return this.userDao.selectByPrimaryKey(userId);
	}

}
