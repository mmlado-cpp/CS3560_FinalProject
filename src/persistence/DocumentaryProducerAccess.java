package persistence;

import java.util.Arrays;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Documentary;
import domain.DocumentaryProducer;

public class DocumentaryProducerAccess {
	
	public static boolean createDocumentaryProducer(int id, String name, String email, Documentary[] documentaries)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(DocumentaryProducer.class).buildSessionFactory();
		boolean flag = false;
		Session session = factory.getCurrentSession();
		
		try
		{
			
			DocumentaryProducer documentaryProducer = new DocumentaryProducer(id, name, email, documentaries);
			
			session.beginTransaction();
			
			session.save(documentaryProducer);
			
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
	
	public static DocumentaryProducer getdocumentaryProducer(int id)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(DocumentaryProducer.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		DocumentaryProducer documentaryProducer = null;
		
		try
		{
			
			session.beginTransaction();
			
			documentaryProducer = session.get(DocumentaryProducer.class, id);
			
			session.getTransaction().commit();
		
		} catch(Exception e)
		{
			 System.out.println("Problem creating session factory");
		     e.printStackTrace();
		} finally {
			factory.close();
		
		}
		return documentaryProducer;
	}
	
	public static boolean updatedocumentaryProducer(int id, String updated_name, String updated_email, Documentary[] updated_documentaries)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(DocumentaryProducer.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		DocumentaryProducer documentaryProducer = null;
		boolean flag = false;
		
		try
		{
			
			session.beginTransaction();
			
			documentaryProducer = session.get(DocumentaryProducer.class, id);
			
			documentaryProducer.setName(updated_name);
			documentaryProducer.setEmail(updated_email);
			documentaryProducer.setDocumentaries(updated_documentaries);
			
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
	
	public static boolean deleteDocumentaryProducer(int id)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(DocumentaryProducer.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		DocumentaryProducer documentaryProducer = null;
		boolean flag = false;
		
		try
		{
			
			session.beginTransaction();
			
			documentaryProducer = session.get(DocumentaryProducer.class, id);
			
			session.delete(documentaryProducer);
			
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
