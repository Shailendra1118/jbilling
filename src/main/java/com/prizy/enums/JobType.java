package com.prizy.enums;

/**
 * @author Shailendra
 */
public enum JobType {

	IDEAL_PRICE("idealPrice");

	String desc = "";

	private JobType(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

}
