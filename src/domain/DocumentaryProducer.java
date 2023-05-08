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
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="item_id")
	private Documentary documentary;
	
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
	
	public Documentary getDocumentary() {
		return documentary;
	}

	public void setDocumentary(Documentary documentary) {
		this.documentary = documentary;
	}

	@Override
	public String toString() {
		return "DocumentaryProducer \nid=" + id + "\nname=" + name + "\nemail=" + email + "\ndocumentary="
				+ documentary;
	}

}