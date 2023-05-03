package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student
{
	@Id
	@Column(name = "bronco_id")
	private int broncoId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name="course")
	private String course;
	
	@Column(name="email")
	private String email;

	public Student(int broncoId, String name, String course, String email)
	{
		this.broncoId = broncoId;
		this.name = name;
		this.course = course;
		this.email = email;
	}
	
	public Student()
	{
		
	}

	public int getBroncoId() {
		return broncoId;
	}

	public void setBroncoId(int broncoId) {
		this.broncoId = broncoId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "broncoId=" + broncoId + "\nname=" + name + "\ncourse=" + course + "\nemail=" + email;
	}

	

}