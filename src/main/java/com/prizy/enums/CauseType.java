package com.prizy.enums;

public enum CauseType {
	
	CHILDREN("children"),
	ELDERDLY("elderly"),
	VETERANS("veterans");
	
	String desc = "";
	private CauseType(String desc){
		this.desc = desc;
	}
	
	public String getDesc(){
		return desc;
	}
	
	

}
