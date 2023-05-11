package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.text.DateFormat;


@Entity
@Table(name = "loan")
public class Loan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "loan_id")
	private int loanID;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "bronco_id")
	private Student student;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "item_id")
	private Item item;
	
	@Column(name="due_date")
	private String duedate;
	
	@Column(name="loan_date")
	private String loanDate;
	
	
	public static ArrayList<Loan> overdueLoans= new ArrayList<Loan>();
	
//	DateFormat dform = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
//	Date obj = new Date();
	
	public Loan(Student student, Item item, String duedate) {
		super();
		this.student = student;
		this.item = item;
		this.duedate = duedate;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date obj = new Date();
		this.loanDate = formatter.format(obj);
	}
	
	public Loan()
	{
		
	}
	

	public int getLoanID() {
		return loanID;
	}

	public void setLoanID(int loanID) {
		this.loanID = loanID;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	public String getDuedate() {
		return duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	public double calculateFinalLoanPrice() {
		double finalPrice = 0.0;
		return finalPrice;
		
	}
	
	public void checkOverdueLoans() {
		
		boolean overdue = false;
		if(overdue) {
			overdueLoans.add(this);
		}
		
	}
	
	public static List<Loan> listAllOverdueLoans() {
		return overdueLoans;
	}
	
	public static void readLoan(int loanID) { //Is this supposed to be static?
		
		
	}
	public static void deleteLoan(int loanID) { //Is this supposed to be static?
		
		
	}
	public static void convertToFinancialReport() { //I think this would go in the student class as generate financial report
		
		
	}
	public static void updateLoan(int loanID) { //Is this supposed to be static?
			
			
		}
	public static void displayReciept() { //Is this supposed to be static?
		
		
	}
	
	@Override
	public String toString() {
		return "Loan [loanID=" + loanID + ", student=" + student + ", item=" + item + ", duedate=" + duedate
				+ ", loanDate=" + loanDate + "]";
	}
	
	
	
	

	

}
