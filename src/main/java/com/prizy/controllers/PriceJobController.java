package com.prizy.controllers;

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
import com.prizy.scheduled.tasks.ScheduledPriceTask;
import com.prizy.services.intf.IPriceStoreService;

@RestController
public class PriceJobController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ScheduledPriceTask task;

	@Autowired
	private IPriceStoreService service;

	// jobs/pricecalculator?command=start
	@RequestMapping(value = "/jobs/pricecalculator", method = RequestMethod.POST)
	public ResponseEntity<JobDetails> runPriceCalculator(
			@RequestParam(value = "command") String command) {
		logger.info("runPriceCalculator called...");
		task.toggle();
		JobDetails job = new JobDetails();
		job.setJobName(task.getJobName());
		job.setStartedAt(task.getStartedAt());
		return new ResponseEntity<JobDetails>(HttpStatus.ACCEPTED);
	}

}
