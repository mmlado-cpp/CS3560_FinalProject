package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documentary")
public class Documentary extends Item//extends Item //needs Item superclass
{
	@Id
	@Column(name = "code")
	private int code;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "daily_price")
	private double dailyPrice;
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "length")
	private int length;
	
	@Column(name = "release_date")
	private String releaseDate;
	
	public Documentary(int code, boolean status, String title, String description, 
					   String location, double dailyPrice, String director, int length, String releaseDate)
	{
		/*
		super(code, status, title, description, location, dailyPrice, status) //needs Item Superclass
		this.director = director;
		this.length = length;
		this.releaseDate = releaseDate;
		*/
		this.code = code;
	    this.status = status;
	    this.title = title;
	    this.description = description;
	    this.location = location;
	    this.dailyPrice = dailyPrice;
	    this.director = director;
	    this.length = length;
	    this.releaseDate = releaseDate;
	}
	
	public Documentary() {
		
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(double dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Documentary \ncode=" + code + "\nstatus=" + status + "\ntitle=" + title + "\ndescription=" + description
				+ "\nlocation=" + location + "\ndailyPrice=" + dailyPrice + "\ndirector=" + director + "\nlength="
				+ length + "\nreleaseDate=" + releaseDate;

	}

}

/* ITEM ATTRIBUTES
code-
title-
description-
location-
dailyPrice-
status-
returnItem()
updateItemAvailability()
*/