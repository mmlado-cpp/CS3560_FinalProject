package domain;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book extends Item
{	
	@Column(name = "number_pages")
	private int numberPages;

	@OneToMany(mappedBy="book", cascade={CascadeType.PERSIST})
	private List<Author> authors;
	
	@Column(name = "publisher")
	private String publisher;
	
	@Column(name = "publication_date")
	private Date publicationDate;
	
	public Book() {
		
	}
	
	public Book(boolean isAvailable, String title, String description, String location, double dailyPrice, 
			int numberPages, List<Author> authors, String publisher, Date publicationDate)
	{
		super(isAvailable, title, description, location, dailyPrice);
		this.numberPages = numberPages;
		this.authors = authors;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
	}

	public int getNumberPages() {
		return numberPages;
	}

	public void setNumberPages(int numberPages) {
		this.numberPages = numberPages;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	public void addAuthor(Author tempAuthor) {
		if(authors == null) {
			authors = new ArrayList<Author>();
		}
		
		authors.add(tempAuthor);
		tempAuthor.setBook(this);
	}
	
	//@Override TODO: remove comment when superclass is implemented
//	public String toString() {
//		return;
//	}
}