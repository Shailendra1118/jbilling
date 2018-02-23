package com.manav.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NGO")
public class NGO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ngo_id")	
	private Long id;
	
	@Column(name="short_desc")	
	private String shortDescription;
	
	@Column(name="long_desc")	
	private String longDescription;
	
	@Column(name="summary")
	private String summary;
	
	@Column(name="type")
	private String type;
	
	@Column(name="img_url")
	private String imgUrl;
	
	@Column(name="rating")
	private Float rating;
	
	public NGO(){
		// default emtpy constructor
	};
	
	public NGO(Long id, String sd, String ld, String summary, String type, String imgUrl, Float rating){
		this.id = id;
		this.shortDescription = sd;
		this.longDescription = ld;
		this.summary = summary;
		this.type = type;
		this.imgUrl = imgUrl;
		this.rating = rating;
	}
	
	public NGO(Long id, String summary, String type){
		this.id = id;
		this.summary = summary;
		this.type = type;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the shortDescription
	 */
	public String getShortDescription() {
		return shortDescription;
	}
	/**
	 * @param shortDescription the shortDescription to set
	 */
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	/**
	 * @return the longDescription
	 */
	public String getLongDescription() {
		return longDescription;
	}
	/**
	 * @param longDescription the longDescription to set
	 */
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the imgUrl
	 */
	public String getImgUrl() {
		return imgUrl;
	}

	/**
	 * @param imgUrl the imgUrl to set
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	/**
	 * @return the rating
	 */
	public Float getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(Float rating) {
		this.rating = rating;
	}
	

}
