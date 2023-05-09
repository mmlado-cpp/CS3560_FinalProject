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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import persistence.DocumentaryProducerAccess;

@Entity
@Table(name = "documentary_producer")
public class DocumentaryProducer
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "producer_id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@ManyToMany(mappedBy="producers", cascade={CascadeType.PERSIST})
	private List<Documentary> documentaries;
	
	public DocumentaryProducer() {
		
	}

	public DocumentaryProducer(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public List<Documentary> getDocumentaries() {
		return documentaries;
	}

	public void setDocumentaries(List<Documentary> documentaries) {
		this.documentaries = documentaries;
	}
	
	public void addDocumentary(Documentary tempDocumentary) {
		if(documentaries == null) {
			documentaries = new ArrayList<Documentary>();
		}
		
		documentaries.add(tempDocumentary);
	}

	@Override
	public String toString() {
		return "DocumentaryProducer \nid=" + id + "\nname=" + name + "\nemail=" + email + "\ndocumentary=" + DocumentaryProducerAccess.getDocumentaries(id);
	}

}