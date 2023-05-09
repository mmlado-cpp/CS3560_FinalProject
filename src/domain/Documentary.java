package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "documentary")
@PrimaryKeyJoinColumn(name="item_id")
public class Documentary extends Item
{	
	@Column(name = "director")
	private String director;
	
	@ManyToMany(cascade={CascadeType.PERSIST})
	@JoinTable(
	        name = "documentary_documentary_producer", 
	        joinColumns = { @JoinColumn(name = "item_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "producer_id") }
	    )
	private List<DocumentaryProducer> producers;
	
	@Column(name = "length")
	private int length;
	
	@Column(name = "release_date")
	private String releaseDate;
	
	public Documentary(boolean isAvailable, String title, String description, 
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

	public List<DocumentaryProducer> getProducers() {
		return producers;
	}

	public void setProducers(List<DocumentaryProducer> producers) {
		this.producers = producers;
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

	public void addProducer(DocumentaryProducer tempProducer) {
		if(producers == null) {
			producers = new ArrayList<DocumentaryProducer>();
		}
		
		producers.add(tempProducer);
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