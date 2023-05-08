package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_details")
public class ItemDetails
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "code")
	private int code;
	
	@Column(name = "status")
	private boolean isAvailable;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "daily_price")
	private double dailyPrice;
	
	public ItemDetails(boolean isAvailable, String title, String description, 
					   String location, double dailyPrice)
	{
	    this.isAvailable = isAvailable;
	    this.title = title;
	    this.description = description;
	    this.location = location;
	    this.dailyPrice = dailyPrice;
	}
	
	public ItemDetails() {
		
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean status) {
		this.isAvailable = status;
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
	
	public void returnItem() {
		
	}
	
	public void updateItemAvailability(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Item \ncode=" + code + "\nisAvailable=" + isAvailable + "\ntitle=" + title + "\ndescription=" + description
				+ "\nlocation=" + location + "\ndailyPrice=" + dailyPrice;

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