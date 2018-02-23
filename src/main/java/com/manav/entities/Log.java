package com.manav.entities;

import java.io.Serializable;

public class Log implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String title = "default";
	private int start = 0;
	private int end = 0;
	private boolean complete = false;
	
	public Log(String title, int start, int end){
		this.title = title;
		this.end = end;
		this.start = start;
		this.complete = false;
	}
	
	public Log(){
		//empty default constructor
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @return the end
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * @param end the end to set
	 */
	public void setEnd(int end) {
		this.end = end;
	}

	/**
	 * @return the complete
	 */
	public boolean isComplete() {
		return complete;
	}

	/**
	 * @param complete the complete to set
	 */
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	
	

}
