/**
 * 
 */
package com.prizy.services.intf;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Shailendra
 *
 */
public interface IPriceCalcJobService {
	/***
	 * main method to trigger calculation logic
	 */
	void calculate();

	/***
	 * Used for handle running of calucation process
	 * 
	 * @return status
	 */
	AtomicBoolean getStatus();
}
