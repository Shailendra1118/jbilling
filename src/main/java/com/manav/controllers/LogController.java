package com.manav.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manav.entities.Log;
import com.manav.entities.NGO;


@RestController
public class LogController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @RequestMapping("/logs")
    public List<Log> getAllLogs() {
    	List<Log> logs = new ArrayList<Log>();
    	logs.add(new Log("First Title", 100, 200));
    	logs.add(new Log("Second Title", 200, 200));
    	logs.add(new Log("Third Title", 300, 200));
    	logs.add(new Log("Fourth Title", 400, 200));
    	logs.add(new Log("Fifth Title", 500, 200));
        return logs;
    }
    
    @RequestMapping("/logs/{id}")
    public NGO getLogById(@PathVariable("id") Long id) {
    	logger.info("getNGOById with "+id);
    	return null;
    }
    
}