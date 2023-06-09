package domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.text.SimpleDateFormat;
//import java.lang.module.Configuration;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import org.hibernate.cfg.Configuration;


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
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date obj = new Date();
		this.loanDate = formatter.format(obj);
		
		Calendar now = Calendar.getInstance();  
		Date loanDateType = null;
		try {
			loanDateType = formatter.parse(loanDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		now.setTime(loanDateType);
        now.add(Calendar.MONTH, 6);
        this.duedate = formatter.format(now.getTime());;
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
		
		double dailyItemPrice = this.item.getDailyPrice(); //needs to be implemented as a foreign key
		double totalPrice = 0.0;
		
		Date current = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		double totalprice = 0.0;
		
		int daysBetween;
		int daysLoanBetween;
		
		Date dateDueDate;
		Date dateLoanDate;
		
		try {
            
            dateDueDate = new SimpleDateFormat("MM/dd/yyyy").parse(this.duedate);
            dateLoanDate = new SimpleDateFormat("MM/dd/yyyy").parse(this.loanDate);
            daysBetween = daysBetween(current, dateDueDate);
            daysLoanBetween = daysBetween(dateLoanDate, dateDueDate);
            if(this.isOverdue()) {
    			int daysOverdue =( -1* daysBetween) - daysLoanBetween;
    			totalPrice = dailyItemPrice * daysBetween + (0.1*dailyItemPrice)*daysOverdue;
    		}
            else {
            	totalPrice = dailyItemPrice * daysBetween;
            }
            
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
		return totalPrice;

	}
	public static int daysBetween(Date d1, Date d2){
	    return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}
	
	public boolean isOverdue() {
		
		Date current = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		double totalprice = 0.0;
		boolean isOverdue = false;
		
		
		Date dateDueDate;
		try {
			dateDueDate = new SimpleDateFormat("MM/dd/yyyy").parse(this.duedate);
			if(current.compareTo(dateDueDate)==1){
		         isOverdue =true;
		         overdueLoans.add(this);
		    }
			isOverdue = false;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isOverdue;
	
       
   
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
	
	public static boolean deleteLoan(int loanID) { //Is this supposed to be static?
		return true;
	}
	
	public static void convertToFinancialReport() { //I think this would go in the student class as generate financial report
		
		
	}

	public static void updateLoan(int loanID, Item newItem, String newDueDate) {
	    SessionFactory factory = new Configuration().configure().addAnnotatedClass(Loan.class).buildSessionFactory();
	    Session session = null;
	    Transaction transaction = null;

	    try {
	        session = factory.openSession();
	        transaction = session.beginTransaction();

	        Loan loan = session.get(Loan.class, loanID);
	        if (loan != null) {
	            loan.setItem(newItem);
	            loan.setDuedate(newDueDate);
	        }

	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	        factory.close();
	    }
	}


	public static void displayReciept() { //Is this supposed to be static?
		
		
	}

	@Override
	public String toString() {
		return "Loan [loanID=" + loanID + ", student=" + student + ", item=" + item + ", duedate=" + duedate
				+ ", loanDate=" + loanDate + "]";
	}
}
