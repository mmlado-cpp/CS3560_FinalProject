package persistence;

import java.util.Arrays;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Documentary;
import domain.DocumentaryProducer;

public class DocumentaryProducerAccess {
	
	public static DocumentaryProducer createDocumentaryProducer(String name, String email, int documentaryId)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(DocumentaryProducer.class)
																				   .addAnnotatedClass(Documentary.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		DocumentaryProducer documentaryProducer = null;
		
		try
		{
			session.beginTransaction();
			
			Documentary tempDocumentary = session.get(Documentary.class, documentaryId);
			documentaryProducer = new DocumentaryProducer(name, email);
			
			if(tempDocumentary != null) { // Documentary ID exists
				tempDocumentary.addProducer(documentaryProducer); //Add producer to doc
				session.save(tempDocumentary);
			} else { // Document ID doesn't match with anything
				System.out.println("Documentary ID does not match with any existing book");
			}
			
			session.save(documentaryProducer);
			
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
	
	public static DocumentaryProducer getdocumentaryProducer(int id)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(DocumentaryProducer.class)
				   																   .addAnnotatedClass(Documentary.class).buildSessionFactory();
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
	
	public static boolean updatedocumentaryProducer(int id, String updated_name, String updated_email, Documentary updated_documentary)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(DocumentaryProducer.class)
		   																		   .addAnnotatedClass(Documentary.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		DocumentaryProducer documentaryProducer = null;
		boolean flag = false;
		
		try
		{
			
			session.beginTransaction();
			
			documentaryProducer = session.get(DocumentaryProducer.class, id);
			
			documentaryProducer.setName(updated_name);
			documentaryProducer.setEmail(updated_email);
			documentaryProducer.setDocumentary(updated_documentary);
			
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
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(DocumentaryProducer.class)
				   																   .addAnnotatedClass(Documentary.class).buildSessionFactory();
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
