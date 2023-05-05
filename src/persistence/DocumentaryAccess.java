package persistence;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import domain.Documentary;
import domain.Student;

public class DocumentaryAccess {
	
	public static boolean createDocumentary(int code, boolean status, String title, String description, 
			   String location, double dailyPrice, String director, int length, String releaseDate)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Documentary.class).buildSessionFactory();
		boolean flag = false;
		Session session = factory.getCurrentSession();
		
		try
		{
			
			Documentary documentary = new Documentary(code, status, title, description, 
				    location, dailyPrice, director, length, releaseDate);
			
			session.beginTransaction();
			
			session.save(documentary);
			
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
	
	public static Documentary getDocumentary(int code)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Documentary.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		Documentary documentary = null;
		
		try
		{
			
			session.beginTransaction();
			
			documentary = session.get(Documentary.class, code);
			System.out.println(documentary + "0");
			session.getTransaction().commit();
		
		} catch(Exception e)
		{
			 System.out.println("Problem creating session factory");
		     e.printStackTrace();
		} finally {
			factory.close();
		
		}
		System.out.println(documentary);
		return documentary;
	}
	
	public static boolean updateDocumentary(int code, boolean updated_status, String updated_title, String updated_description, 
			   String updated_location, double updated_dailyPrice, String updated_director, int updated_length, String updated_releaseDate)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Documentary.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		Documentary documentary = null;
		boolean flag = false;
		
		try
		{
			
			session.beginTransaction();
			
			documentary = session.get(Documentary.class, code);
			
			documentary.setStatus(updated_status);
			documentary.setTitle(updated_title);
			documentary.setDescription(updated_description);
			documentary.setLocation(updated_location);
			documentary.setDailyPrice(updated_dailyPrice);
			documentary.setDirector(updated_director);
			documentary.setLength(updated_length);
			documentary.setReleaseDate(updated_releaseDate);
			
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
	
	public static boolean deleteDocumentary(int code)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Documentary.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		Documentary documentary = null;
		boolean flag = false;
		
		try
		{
			
			session.beginTransaction();
			
			documentary = session.get(Documentary.class, code);
			
			session.delete(documentary);
			
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