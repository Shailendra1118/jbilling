package com.prizy.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prizy.entities.Cause;
import com.prizy.enums.CauseType;
import com.prizy.services.intf.ICauseService;

@RestController
public class CauseController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ICauseService service;

	@RequestMapping("/elderly")
	public List<Cause> getElderlyCauses() {
		logger.info("getElderlyCauses called...");
		return service.getByType(CauseType.ELDERDLY.getDesc());
	}

	@RequestMapping("/children")
	public List<Cause> getChildCauses() {
		logger.info("getChildCauses called...");
		return service.getByType(CauseType.CHILDREN.getDesc());
	}

	@RequestMapping("/veterans")
	public List<Cause> getVeteransCauses() {
		logger.info("getVeteransCauses called...");
		return service.getByType(CauseType.VETERANS.getDesc());
	}

	@RequestMapping("/naturaldisaster")
	public List<Cause> getNatureDisasterCauses() {
		logger.info("getNatureDisasterCauses called...");
		return service.getByType("naturaldisaster");
	}

	@RequestMapping("/aroundus")
	public List<Cause> getPplAroundUsCauses() {
		logger.info("getPplAroundUsCauses called...");
		return service.getByType("aroundus");
	}

	@RequestMapping("/pilgrim")
	public List<Cause> getPilgrimCauses() {
		logger.info("getPilgrimCauses called...");
		return service.getByType("pilgrim");
	}

	@RequestMapping("/strugglingwm")
	public List<Cause> getStrugglingwm() {
		return service.getByType("strugglingwm");
	}

}
