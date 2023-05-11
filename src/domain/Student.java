package domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.*;
import java.util.*;

@Entity
@Table(name = "student")
public class Student
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "bronco_id")
	private int broncoId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name="course")
	private String course;
	
	@Column(name="email")
	private String email;
	
//	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
//	private List<Loan> loans;
	
	
	//create a list of loans that the student has 

	public Student(String name, String course, String email)
	{
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
	
	public List<Loan> createOverdueLoansList(List<Loan> loans) {
		for(Loan loan : loans) {
			
		}
	}

	@Override
	public String toString() {
		return "broncoId=" + broncoId + "\nname=" + name + "\ncourse=" + course + "\nemail=" + email;
	}

	

}