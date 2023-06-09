package persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import domain.Documentary;
import domain.Student;
import domain.DocumentaryProducer;

public class DocumentaryAccess {
	
	public static boolean createDocumentary(boolean status, String title, String description, 
			   String location, double dailyPrice, String director, int length, String releaseDate, int producerId)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Documentary.class).addAnnotatedClass(DocumentaryProducer.class).buildSessionFactory();
		boolean flag = false;
		Session session = factory.getCurrentSession();
		
		try
		{
			
			Documentary documentary = new Documentary(status, title, description, 
				    location, dailyPrice, director, length, releaseDate);
			
			session.beginTransaction();
			
			DocumentaryProducer producer = session.get(DocumentaryProducer.class, producerId);
			
			if(producer != null) { // Documentary ID exists
				producer.addDocumentary(documentary); //Add producer to doc
				documentary.addProducer(producer); //Add documentary to producer
				session.save(producer);
			} else { // Document ID doesn't match with anything
				System.out.println("Producer ID does not match with any existing producer");
			}
			
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
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Documentary.class).addAnnotatedClass(DocumentaryProducer.class).buildSessionFactory();
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
	
	public static String getProducers(int code){
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Documentary.class).addAnnotatedClass(DocumentaryProducer.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		List<DocumentaryProducer> producers = null;
		String producersString = "";
		
		try
		{
			
			session.beginTransaction();
			
			producers = session.get(Documentary.class, code).getProducers();
			producersString = producers.toString();
			
			session.getTransaction().commit();
		
		} catch(Exception e)
		{
			 System.out.println("Problem creating session factory");
		     e.printStackTrace();
		} finally {
			factory.close();
		
		}
		return producersString;
	}
	
	public static List<DocumentaryProducer> getProducerList(int code){
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Documentary.class).addAnnotatedClass(DocumentaryProducer.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		List<DocumentaryProducer> producers = null;
		
		try
		{
			
			session.beginTransaction();
			
			producers = session.get(Documentary.class, code).getProducers();
			
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
	
	public static List<Integer> getProducerIds(int code){
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Documentary.class).addAnnotatedClass(DocumentaryProducer.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		List<Integer> producerIds = new ArrayList<Integer>();
		
		try
		{
			
			session.beginTransaction();
			
			List<DocumentaryProducer> producers = session.get(Documentary.class, code).getProducers();
			
			if(producers != null) {
				for(DocumentaryProducer producer : producers) {
					producerIds.add(producer.getId());
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
		return producerIds;
	}
	
	public static List<Documentary> getAllDocumentaries(){
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Documentary.class).addAnnotatedClass(DocumentaryProducer.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		List<Documentary> documentaries = null;
		
		try
		{
			
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Documentary> criteria = builder.createQuery(Documentary.class);
			criteria.from(Documentary.class);
			
			documentaries = session.createQuery(criteria).getResultList();
			
			session.getTransaction().commit();
		
		} catch(Exception e)
		{
			 System.out.println("Problem creating session factory");
		     e.printStackTrace();
		} finally {
			factory.close();
		
		}
		return documentaries;
	}
	
	public static boolean updateDocumentary(int code, boolean updated_status, String updated_title, String updated_description, 
			   String updated_location, double updated_dailyPrice, String updated_director, int updated_length, String updated_releaseDate, int updated_producer_id, boolean addProducer)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Documentary.class).addAnnotatedClass(DocumentaryProducer.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		Documentary documentary = null;
		boolean flag = false;
		
		try
		{
			
			session.beginTransaction();
			
			documentary = session.get(Documentary.class, code);
			DocumentaryProducer tempProducer = session.get(DocumentaryProducer.class, updated_producer_id);
			
			documentary.setIsAvailable(updated_status);
			documentary.setTitle(updated_title);
			documentary.setDescription(updated_description);
			documentary.setLocation(updated_location);
			documentary.setDailyPrice(updated_dailyPrice);
			documentary.setDirector(updated_director);
			documentary.setLength(updated_length);
			documentary.setReleaseDate(updated_releaseDate);
			
			if(tempProducer != null) { // Documentary ID exists
				if(addProducer) {
					documentary.addProducer(tempProducer); //Add producer to doc
					tempProducer.addDocumentary(documentary); //Add documentary to producer
					session.save(tempProducer);
				} else {
					documentary.removeProducer(tempProducer);
					tempProducer.removeDocumentary(documentary);
					session.save(tempProducer);
				}
			}
			
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
	
	public static boolean deleteDocumentary(int code)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Documentary.class).addAnnotatedClass(DocumentaryProducer.class).buildSessionFactory();
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