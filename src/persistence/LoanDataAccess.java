package persistence;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import domain.Student;
import domain.Item;
import domain.Loan;



public class LoanDataAccess {
	
	public static boolean createLoan(int broncoId, int itemId, String dueDate)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Item.class).addAnnotatedClass(Loan.class).buildSessionFactory();
		boolean flag = false;
		Session session = factory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
		
			Item item = session.get(Item.class, itemId);
			
			if(item.getIsAvailable())
			{
				Student student = session.get(Student.class, broncoId);
				
				Loan loan = new Loan(student, item, dueDate);
			
				session.save(loan);
			
				session.getTransaction().commit();
			
				flag = true;
			}
		} catch(Exception e)
		{
			 System.out.println("Problem creating session factory");
		     e.printStackTrace();
		} finally {
			factory.close();
		
		}
		return flag;
	}
	
	public static Student getLoan(int broncoId)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		Student student = null;
		
		try
		{
			
			session.beginTransaction();
			
			student = session.get(Student.class, broncoId);
			
			session.getTransaction().commit();
		
		} catch(Exception e)
		{
			 System.out.println("Problem creating session factory");
		     e.printStackTrace();
		} finally {
			factory.close();
		
		}
		return student;
	}
	
	public static boolean updateLoan(int broncoId, String updatedName, String updatedCourse, String updatedEmail)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		Student student = null;
		boolean flag = false;
		
		try
		{
			
			session.beginTransaction();
			
			student = session.get(Student.class, broncoId);
			
			student.setName(updatedName);
			student.setCourse(updatedCourse);
			student.setEmail(updatedEmail);
			
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
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
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

