package com.prizy.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prizy.entities.NGO;
import com.prizy.services.intf.INGOService;

@RestController
public class NGOController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private INGOService ngoservice;

	@RequestMapping("/ngos")
	public List<NGO> getAllNGO() {
		return ngoservice.getAllNGO();
	}

	@RequestMapping("/ngos/{id}")
	public NGO getNGOById(@PathVariable("id") Long id) {
		logger.info("getNGOById with " + id);
		return ngoservice.getNGOById(id);
	}
}