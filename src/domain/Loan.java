package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Loan {
	private int loanID;
	private String studentName;
	private Date loanDate;
	private Date duedate;
	private ArrayList<Item> borrowedItems = new ArrayList<Item>();
	public static ArrayList<Loan> overdueLoans= new ArrayList<Loan>();
	private double dailyPrice;
	private double totalPrice;
	
	
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
	
	
	
	

	

}
