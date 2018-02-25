package com.prizy.scheduled.tasks;

import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.prizy.price.strategies.IIdealPriceStrategy;

@Component
public class ScheduledPriceTask {

	@Autowired
	private IIdealPriceStrategy strategy;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final AtomicBoolean enabled = new AtomicBoolean(false);
	private final String jobName = "IdealPriceCalculator";
	private Date startedAt = null;

	@Scheduled(fixedDelay = 3000)
	private void execute() {
		if (enabled.get()) {
			// run spring batch here.
			logger.info("IdealPriceCalculator started running...");
			startedAt = new Date();
			strategy.setProductId(1L);
			strategy.execute();
		}
	}

	public void toggle() {
		enabled.set(!enabled.get());
	}

	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @return the startedAt
	 */
	public Date getStartedAt() {
		return startedAt;
	}

}
