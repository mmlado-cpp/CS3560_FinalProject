package persistence;

import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Documentary;
import domain.DocumentaryProducer;

public class DocumentaryProducerAccess {
	
	public static DocumentaryProducer createDocumentaryProducer(String name, String email, String style, String nationality, int documentaryId)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(DocumentaryProducer.class)
																				   .addAnnotatedClass(Documentary.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		DocumentaryProducer documentaryProducer = null;
		
		try
		{
			session.beginTransaction();
			
			Documentary tempDocumentary = session.get(Documentary.class, documentaryId);
			documentaryProducer = new DocumentaryProducer(name, email, style, nationality);
			
			if(tempDocumentary != null) { // Documentary ID exists
				tempDocumentary.addProducer(documentaryProducer); //Add producer to doc
				documentaryProducer.addDocumentary(tempDocumentary); //Add documentary to producer
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
	
	public static String getDocumentaries(int code){
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Documentary.class).addAnnotatedClass(DocumentaryProducer.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		List<Documentary> documentaries = null;
		String documentariesString = "";
		
		try
		{
			
			session.beginTransaction();
			
			documentaries = session.get(DocumentaryProducer.class, code).getDocumentaries();
			
			for(Documentary doc : documentaries) {
				documentariesString += "[id (" + doc.getItemId() + "): " + doc.getTitle() + "] ";
			}
			
			session.getTransaction().commit();
		
		} catch(Exception e)
		{
			 System.out.println("Problem creating session factory");
		     e.printStackTrace();
		} finally {
			factory.close();
		
		}
		return documentariesString;
	}
	
	public static List<Integer> getDocumentaryList(int code){
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Documentary.class).addAnnotatedClass(DocumentaryProducer.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		List<Integer> documentaryIds = new ArrayList<Integer>();
		
		try
		{
			
			session.beginTransaction();
			
			List<Documentary> documentaries = session.get(DocumentaryProducer.class, code).getDocumentaries();
			
			if(documentaries != null) {
				for(Documentary doc : documentaries) {
					documentaryIds.add(doc.getItemId());
				}
			}
			
			session.getTransaction().commit();
		
		} catch(Exception e)
		{
			 System.out.println("Problem creating session factory");
		     e.printStackTrace();
		} finally {
			factory.close();
		
		}
		return documentaryIds;
	}
	
	public static List<DocumentaryProducer> getAllProducers(){
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Documentary.class).addAnnotatedClass(DocumentaryProducer.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		List<DocumentaryProducer> producers = null;
		
		try
		{
			
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<DocumentaryProducer> criteria = builder.createQuery(DocumentaryProducer.class);
			criteria.from(DocumentaryProducer.class);
			
			producers = session.createQuery(criteria).getResultList();
			
			session.getTransaction().commit();
		
		} catch(Exception e)
		{
			 System.out.println("Problem creating session factory");
		     e.printStackTrace();
		} finally {
			factory.close();
		
		}
		return producers;
	}
	
	public static boolean updateDocumentaryProducer(int id, String updated_name, String updated_email, String updated_style, String updated_nationality, int updated_documentary_id, boolean addDocumentary)
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
			Documentary tempDocumentary = session.get(Documentary.class, updated_documentary_id);
			
			if(tempDocumentary != null) { // Documentary ID exists
				if(addDocumentary) {
					tempDocumentary.addProducer(documentaryProducer); //Add producer to doc
					documentaryProducer.addDocumentary(tempDocumentary); //Add documentary to producer
					session.save(tempDocumentary);
				} else {
					tempDocumentary.removeProducer(documentaryProducer);
					documentaryProducer.removeDocumentary(tempDocumentary);
					session.save(tempDocumentary);
				}
			} else if (updated_documentary_id == -2){ // Document ID doesn't match with anything (So user chose Clear all Documentaries in the combo box)
				//For each documentary that the producer did, remove this from producer list
				for(Documentary doc : documentaryProducer.getDocumentaries()) {
					System.out.println("Removing from " + doc);
					doc.removeProducer(documentaryProducer);
					session.save(doc);
				}
				documentaryProducer.setDocumentaries(null);
			}
			
			documentaryProducer.setName(updated_name);
			documentaryProducer.setEmail(updated_email);
			documentaryProducer.setStyle(updated_style);
			documentaryProducer.setNationality(updated_nationality);
			
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
			
			for(Documentary doc : documentaryProducer.getDocumentaries()) {
				doc.removeProducer(documentaryProducer);
			}
			
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
