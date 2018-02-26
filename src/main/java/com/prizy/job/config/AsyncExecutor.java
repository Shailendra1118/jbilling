package com.prizy.job.config;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class AsyncExecutor extends AsyncConfigurerSupport {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("PrizyCalculator-");
		executor.initialize();
		return executor;
	}

	// TODO Get Asynctask return something so it can be done with Future and
	// exception can be also caught
	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		logger.error("Exception in AsyncExector...");
		return new IdealPriceAsyncUncaughtExceptionHandler();
	}
}
