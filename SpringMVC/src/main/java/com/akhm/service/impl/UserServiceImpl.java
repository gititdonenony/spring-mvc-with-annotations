package com.akhm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhm.dao.UserDAO;
import com.akhm.dao.model.UserTl;
import com.akhm.dto.UserDTO;
import com.akhm.service.UserService;
import com.akhm.utils.FactoryUtils;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	public Integer saveUser(UserDTO userDTO) {
		Integer userId = 0;
		try {
			if (userDTO != null) {
				UserTl userTl = FactoryUtils.convertUserDtoToUserTl(userDTO);
				if (userTl != null) {
					userId = userDAO.insertUser(userTl);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userId;
	}

}
