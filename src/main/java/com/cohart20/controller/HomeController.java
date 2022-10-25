package com.cohart20.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cohart20.service.UserService;
import com.cohart20.service.UserService1;
import com.cohart20.tb.User;

@Controller
public class HomeController {

	@RequestMapping("/") // we can put only / for first page also
	public String home() {

		return "index"; // index is jsp name
	}

	@RequestMapping("/registration")
	public String registration() throws Exception {
		return "registration";
	}

	@RequestMapping("/registration1")
	public String registration1(String username, String password, String name, String lastname, String email)
			throws Exception {
		UserService uservice = new UserService();
		uservice.setuser(username, password, name, lastname, email);
		return "index";
	}

	@RequestMapping(value = ("/registrationpassvalue"), method = RequestMethod.POST)
	public String registrationpassvalue(User user) throws Exception {

		UserService1 uservice = new UserService1();
		boolean success;
		success = uservice.userlogin(user.getUsername());
		if (success = false) {

			return "registration";
		} else {
			uservice.setuser(user);
			return "index";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(String username, String password) throws Exception {
		UserService1 userService1 = new UserService1();
		User user = null;
		user = userService1.login(username, password);
		if (user != null) {
			ModelAndView mview = new ModelAndView("welcome");

			mview.addObject("username", user);

			return mview;
		} else {
			ModelAndView mview = new ModelAndView("index");
			return mview;

		}

	}
}
