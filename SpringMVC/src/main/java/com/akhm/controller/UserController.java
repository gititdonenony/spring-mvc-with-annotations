package com.akhm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akhm.controller.command.UserCommand;
import com.akhm.dto.UserDTO;
import com.akhm.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET, value = "/adduser.htm")
	public String showAddUser() {
		return "adduser.jsp";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/adduser.htm")
	public String addUser(UserCommand userCommand) {
		String target = "adduser";
		UserDTO userDTO = new UserDTO();
		userDTO.setFirstName(userCommand.getFirstName());
		userDTO.setLastName(userCommand.getLastName());
		userDTO.setEmailId(userCommand.getEmailId());
		userDTO.setMobileNumber(userCommand.getMobileNumber());
		userDTO.setPassword(userCommand.getPassword());
		userDTO.setDob(userCommand.getDob());
		if (userCommand.getDob() != null) {

		}
		Integer userId = userService.saveUser(userDTO);
		if (userId != null && userId > 0) {
			target = "redirect:users.htm";
		}
		return target;
	}
}
