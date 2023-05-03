package domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "author_id")
	private int authorId;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="book_id")
	private Book book;
	
	public Author(String name, Book book)
	{
		this.name = name;
	}
	
	public Author(String name) {
		this.name = name;
	}
	
	public Author()
	{
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "authorId=" + authorId + "\nname=" + name;
	}
}