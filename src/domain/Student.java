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
	
	public Student(int broncoId, String name, String course)
	{
		this.broncoId = broncoId;
		this.name = name;
		this.course = course;
	}
	
	public Student()
	{
		
	}

	public int getBroncoName() {
		return broncoId;
	}

	public void setBroncoName(int broncoId) {
		this.broncoId = broncoId;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "broncoId=" + broncoId + "\nname=" + name + "\ncourse=" + course;
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
	

}