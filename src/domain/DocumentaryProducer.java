package domain;

import java.util.ArrayList;
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
	private ArrayList<Integer> documentary_ids;
	
	public DocumentaryProducer() {
		
	}

	public DocumentaryProducer(int id, String name, String email, ArrayList<Integer> documentary_ids) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.documentary_ids = documentary_ids;
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

	public ArrayList<Integer> getDocumentaries() {
		return documentary_ids;
	}

	public void setDocumentaries(ArrayList<Integer> documentaries) {
		this.documentary_ids = documentaries;
	}
	
	public boolean addDocumentary(int documentary_id) {
		if(this.documentary_ids.add(documentary_id)) {
			return true;
		}
		return false;
	}

	
	@Override
	public String toString() {
		return "DocumentaryProducer \nid=" + id + "\nname=" + name + "\nemail=" + email + "\ndocumentaries="
				;
	}

}