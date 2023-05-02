package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documentary")
public class Documentary //extends Item
{
	@Id
	@Column(name = "code")
	private int code;
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "length")
	private int length;
	
	@Column(name = "releaseDate")
	private String releaseDate;
	
	public Documentary(int code, boolean isAvailable, String title, String description, 
					   String location, double dailyPrice, String director, int length, String releaseDate)
	{
		//super(code, isAvailable, title, description, location, dailyPrice, status)
		this.director = director;
		this.length = length;
		this.releaseDate = releaseDate;
	}

	
}

/* ITEM ATTRIBUTES
isAvailable
code
title
description
location
dailyPrice
status
returnItem()
updateItemAvailability()
*/