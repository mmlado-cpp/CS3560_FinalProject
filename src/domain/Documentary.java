package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documentary")
public class Documentary extends Item
{	
	@Column(name = "director")
	private String director;
	
	@Column(name = "length")
	private int length;
	
	@Column(name = "release_date")
	private String releaseDate;
	
	public Documentary(int code, boolean isAvailable, String title, String description, 
					   String location, double dailyPrice, String director, int length, String releaseDate)
	{
		super(isAvailable, title, description, location, dailyPrice);
	    this.director = director;
	    this.length = length;
	    this.releaseDate = releaseDate;
	}
	
	public Documentary() {
		
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
		return super.toString() + "\ndirector=" + director + "\nlength="
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