package com.cohart20.controller;
import com.cohart20.tb.User;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cohart20.service.UserService1;

@Controller
public class MasterModuleController {
	@RequestMapping("/masterModule")
	public ModelAndView getmasterModulePage() {
		
		ModelAndView modelAndView = new ModelAndView("masterModule");
		
		return modelAndView;
	}
	
	@RequestMapping("/masterUser")
	public ModelAndView getMasterUser() throws Exception {
		
		ModelAndView modelAndView = new ModelAndView("masterUserPage");
		
		UserService1 userService = new UserService1();
		
		List<User> users = userService.getAllUsers();
		
		modelAndView.addObject("allUsers", users);
		
		return modelAndView;
	}

}
