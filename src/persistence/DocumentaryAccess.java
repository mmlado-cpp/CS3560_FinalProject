package persistence;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import domain.Documentary;

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
			
			session.getTransaction().commit();
		
		} catch(Exception e)
		{
			 System.out.println("Problem creating session factory");
		     e.printStackTrace();
		} finally {
			factory.close();
		
		}
		return documentary;
	}
}