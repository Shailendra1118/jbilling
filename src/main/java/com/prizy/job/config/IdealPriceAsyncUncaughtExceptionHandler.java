package com.prizy.job.config;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

/**
 * @author Shailendra
 *
 */
public class IdealPriceAsyncUncaughtExceptionHandler implements
		AsyncUncaughtExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void handleUncaughtException(Throwable ex, Method method,
			Object... params) {
		// handle exception
		logger.error("Exception while AsyncExecutor..." + ex.getMessage());
	}

}
