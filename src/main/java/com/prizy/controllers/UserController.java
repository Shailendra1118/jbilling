package com.prizy.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prizy.entities.AppUser;
import com.prizy.entities.EntryPass;
import com.prizy.services.intf.IUserService;

@RestController
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUserService usrvc;

	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public AppUser getUserById(@RequestBody EntryPass creds) {
		logger.info("getUserById with " + creds.getUname());
		return usrvc.getUserById(creds);
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public AppUser registerNewUser(@RequestBody AppUser user) {
		logger.info("New user: " + user);

		// TODO:do registration in DB and then retrive and return the user

		return user;
	}

}
