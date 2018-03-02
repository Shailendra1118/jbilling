package com.prizy.rest.controllers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prizy.entities.vo.JobDetails;
import com.prizy.services.intf.IPriceCalcJobService;
import com.prizy.services.intf.IPriceStoreService;

@RestController
public class PriceJobController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IPriceCalcJobService jobService;

	@Autowired
	private IPriceStoreService service;

	// jobs/pricecalculator?command=start
	@RequestMapping(value = "/jobs/pricecalculator", method = RequestMethod.POST)
	public ResponseEntity<JobDetails> runPriceCalculator(
			@RequestParam(value = "command") String command) {
		logger.info("runPriceCalculator called...");
		JobDetails job = new JobDetails();
		job.setJobName("pricecalculator");
		if (jobService.getStatus().compareAndSet(false, true)) {
			logger.info("Batch is triggered...");
			jobService.calculate();
			job.setStartedAt(new Date());
			job.setMessage("Triggered successfully, returning...");
			return new ResponseEntity<JobDetails>(job, HttpStatus.ACCEPTED);
		}
		// if already running
		logger.info("Batch is already running");
		job.setMessage("Already running. Try after sometime.");
		return new ResponseEntity<JobDetails>(HttpStatus.FORBIDDEN);

	}
}
