package com.prizy.entities;

public class Location {
	
	private double longitude;
	private double latitude;
	private double accuracy;
	
	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the accuracy
	 */
	public double getAccuracy() {
		return accuracy;
	}
	/**
	 * @param accuracy the accuracy to set
	 */
	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}
	
	public String toString(){
		return this.longitude+","+this.latitude+","+this.accuracy;
	}

}
