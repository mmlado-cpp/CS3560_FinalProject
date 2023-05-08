package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;

@Entity
@Table(name = "item")
@Inheritance(strategy=InheritanceType.JOINED)
public class Item
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "available")
	private boolean isAvailable;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "daily_price")
	private double dailyPrice;
	
	public Item(boolean isAvailable, String title, String description, 
					   String location, double dailyPrice)
	{
	    this.isAvailable = isAvailable;
	    this.title = title;
	    this.description = description;
	    this.location = location;
	    this.dailyPrice = dailyPrice;
	}
	
	public Item() {
		
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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
	
	/* End Get Set */
	
	/* Start Methods */
	
	
	public String returnItemDueDate() {
		//Return current time
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
	}
	
	public void updateItemAvailability(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	/* End Methods */

	@Override
	public String toString() {
		return "Item \nitem_id=" + itemId + "\nisAvailable=" + isAvailable + "\ntitle=" + title + "\ndescription=" + description
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