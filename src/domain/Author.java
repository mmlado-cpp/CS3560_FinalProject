package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "nationality")
	private String nationality;

	@ManyToMany(mappedBy="authors", cascade={CascadeType.PERSIST})
	private List<Book> books;
	
	public Author(String name, String email)
	{
		this.name = name;
		this.email = email;
	}
	
	public Author(String name, String email, String subject, String nationality) {
		super();
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.nationality = nationality;
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public void addBook(Book tempBook) {
		if(books == null) {
			books = new ArrayList<Book>();
		}
		
		books.add(tempBook);
	}
	
	public void removeBook(Book tempBook) {
		books.remove(tempBook);
	}

	@Override
	public String toString() {
		return "authorId=" + authorId + "\nname=" + name + "\nsubject=" + subject + "\nnationality=" + nationality;
	}
}