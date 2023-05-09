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
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "nationality")
	private String nationality;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="item_id")
	private Book book;
	
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
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

	@Override
	public String toString() {
		return "authorId=" + authorId + "\nname=" + name + "\nsubject=" + subject + "\nnationality=" + nationality;
	}
}