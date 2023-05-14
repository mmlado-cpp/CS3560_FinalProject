package persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import domain.Student;
import domain.Item;
import domain.Loan;

public class LoanDataAccess {
	
	public static String createLoan(int broncoId, int itemId, String dueDate)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Item.class).addAnnotatedClass(Loan.class).buildSessionFactory();
		String flag = "";
		Session session = factory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
		
			Item item = session.get(Item.class, itemId);
			System.out.println(item.getIsAvailable());
			
			if(item.getIsAvailable())
			{
				Student student = session.get(Student.class, broncoId);
				
				Loan loan = new Loan(student, item, dueDate);
				
				
				item.setIsAvailable(false);
				
				session.save(loan);
			
				session.getTransaction().commit();
			
				flag = "created";
			}
			else
			{
				flag = "itemNotAvailable";
			}
		} catch(Exception e)
		{
			 flag = "notCreated";
			 System.out.println("Problem creating session factory");
		     e.printStackTrace();
		} finally {
			factory.close();
		
		}
		return flag;
	}
	
	public static List<Loan> getLoans(int broncoId)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Item.class).addAnnotatedClass(Loan.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		List<Loan> loans= null;
		
		try
		{
			
			session.beginTransaction();
			
			
			 
			String hql = "FROM Loan L WHERE L.student.broncoId = " + broncoId;
			Query<Loan> query = session.createQuery(hql);
			List<Loan> listLoans = query.list();
			
			for(Loan loan : listLoans) {
				System.out.println("Row" + loan.toString());
			}
			
			session.getTransaction().commit();
		
		} catch(Exception e)
		{
			 System.out.println("Problem creating session factory");
		     e.printStackTrace();
		} finally {
			factory.close();
		
		}
		return loans;
	}
	
	public static boolean updateLoan(int loanId, String updateDueDate, String loanDate)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Item.class).addAnnotatedClass(Loan.class).buildSessionFactory();		
		Session session = factory.getCurrentSession();
		Loan loan = null;
		boolean flag = false;
		
		try
		{
			
			session.beginTransaction();
			
			loan = session.get(Loan.class, loanId);
			
			loan.setLoanID(loanId);
			loan.setDuedate(updateDueDate);
			loan.setLoanDate(loanDate);
			
			session.getTransaction().commit();
			
			flag = true;
		} catch(Exception e)
		{
			 System.out.println("Problem creating session factory");
		     e.printStackTrace();
		} finally {
			factory.close();
		
		}
		return flag;
	}
	
	public static boolean deleteLoan(int broncoId)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Item.class).addAnnotatedClass(Loan.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		Student student = null;
		boolean flag = false;
	
		try
		{
			
			session.beginTransaction();
			
			student = session.get(Student.class, broncoId);
			
			session.delete(student);
			
			session.getTransaction().commit();
			
			flag = true;
		} catch(Exception e)
		{
			 System.out.println("Problem creating session factory");
		     e.printStackTrace();
		} finally {
			factory.close();
		
		}
		return flag;
	}
	
}

