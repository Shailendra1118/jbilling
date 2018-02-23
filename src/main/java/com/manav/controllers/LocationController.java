package com.manav.controllers;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manav.entities.Location;

@RestController
@RequestMapping("/flash")
public class LocationController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody Location location) {
		if(location != null)
			logger.info("location: "+location);
    }

}
