package domain;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documentary_producer")
public class DocumentaryProducer
{
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "documentaries")
	private Documentary[] documentaries;
	
	public DocumentaryProducer() {
		
	}

	public DocumentaryProducer(int id, String name, String email, Documentary[] documentaries) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.documentaries = documentaries;
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

	public Documentary[] getDocumentaries() {
		return documentaries;
	}

	public void setDocumentaries(Documentary[] documentaries) {
		this.documentaries = documentaries;
	}

	
	@Override
	public String toString() {
		return "DocumentaryProducer \nid=" + id + "\nname=" + name + "\nemail=" + email + "\ndocumentaries="
				+ Arrays.toString(documentaries);
	}

}