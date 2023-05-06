package persistence;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import domain.Book;
import domain.Student;
import domain.Author;

public class BookDataAccess {
	
	public static boolean createBook(boolean isAvailable, String title, String description, String location, double dailyPrice, 
			int numberPages, List<Author> authors, String publisher, Date publicationDate)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class)
																				   .addAnnotatedClass(Author.class).buildSessionFactory();
		boolean flag = false;
		Session session = factory.getCurrentSession();
		
		try
		{
			Book tempBook = new Book(isAvailable, title, description, location, dailyPrice, 
					numberPages, authors, publisher, publicationDate);
			
;			session.beginTransaction();
			
			session.save(tempBook);
			
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
	
	public static Book getBook(int bookId)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Author.class)
																				   .addAnnotatedClass(Book.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		Book tempBook = null;
		
		try
		{
			
			session.beginTransaction();
			
			tempBook = session.get(Book.class, bookId);
			
			session.getTransaction().commit();
		
		} catch(Exception e)
		{
			 System.out.println("Problem creating session factory");
		     e.printStackTrace();
		} finally {
			factory.close();
		
		}
		return tempBook;
	}
	
	public static boolean updateBook(int bookId, boolean updated_status, String updatedName, String updated_title, String updated_description, 
			   String updated_location, double updated_dailyPrice, int updated_numberPages, List<Author> updated_authors, String updated_publisher, Date updated_publicationDate)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Author.class)
																				   .addAnnotatedClass(Book.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		Book tempBook = null;
		boolean flag = false;
		
		try
		{
			session.beginTransaction();
			
			tempBook = session.get(Book.class, bookId);
			
			if(tempBook == null) {
				System.out.println("Book ID does not match with any existing book");
				return flag;
			}
			
//			tempBook.setStatus(updated_status);
//			tempBook.setTitle(updated_title);
//			tempBook.setDescription(updated_description);
//			tempBook.setLocation(updated_location);
//			tempBook.setDailyPrice(updated_dailyPrice);
			tempBook.setNumberPages(updated_numberPages);
			tempBook.setAuthors(updated_authors);
			tempBook.setPublisher(updated_publisher);
			tempBook.setPublicationDate(updated_publicationDate);
			
			session.save(tempBook);
			
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
	
	public static Book deleteBook(int bookId)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Author.class)
																				   .addAnnotatedClass(Book.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		Book tempBook = null;
		
		try
		{
			
			session.beginTransaction();
		
			tempBook = session.get(Book.class, bookId);
			
			session.delete(tempBook);
			
			session.getTransaction().commit();

		} catch(Exception e)
		{
			 System.out.println("Problem creating session factory");
		     e.printStackTrace();
		} finally {
			factory.close();
		
		}
		return tempBook;
	}
}
