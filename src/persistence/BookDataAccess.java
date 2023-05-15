package persistence;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import domain.Book;
import domain.DocumentaryProducer;
import domain.Item;
import domain.Student;
import domain.Author;

public class BookDataAccess {
	
	public static boolean createBook(boolean isAvailable, String title, String description, String location, double dailyPrice, 
			int numberPages, String publisher, String publicationDate, int authorId)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class)
																				   .addAnnotatedClass(Author.class).buildSessionFactory();
		boolean flag = false;
		Session session = factory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
			
			Book tempBook = new Book(isAvailable, title, description, location, dailyPrice, 
					numberPages, publisher, publicationDate);
			
			Author author = session.get(Author.class, authorId);
			
			if(author != null) { // Documentary ID exists
				author.addBook(tempBook); //Add producer to doc
				tempBook.addAuthor(author); //Add documentary to producer
				session.save(author);
			} else { // Document ID doesn't match with anything
				System.out.println("Author ID does not match with any existing producer");
			}
			
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
	
	public static List<Integer> getAuthorIds(int code){
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Author.class).addAnnotatedClass(Book.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		List<Integer> authorIds = new ArrayList<Integer>();
		
		try
		{
			
			session.beginTransaction();
			
			List<Author> authors = session.get(Book.class, code).getAuthors();
			
			if(authors != null) {
				for(Author author : authors) {
					authorIds.add(author.getAuthorId());
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
		return authorIds;
	}
	
	public static List<Book> getAllBooks(){
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Author.class).addAnnotatedClass(Book.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		List<Book> books = null;
		
		try
		{
			
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Book> criteria = builder.createQuery(Book.class);
			criteria.from(Book.class);
			
			books = session.createQuery(criteria).getResultList();
			
			session.getTransaction().commit();
		
		} catch(Exception e)
		{
			 System.out.println("Problem creating session factory");
		     e.printStackTrace();
		} finally {
			factory.close();
		
		}
		return books;
	}
	
	public static boolean updateBook(int bookId, boolean updated_status, String updated_title, String updated_description, 
			   String updated_location, double updated_dailyPrice, int updated_numberPages, String updated_publisher, String updated_publicationDate,
			   int updatedAuthorId, boolean addAuthor)
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
			Author tempAuthor = session.get(Author.class, updatedAuthorId);
			
			if(tempAuthor != null) { // Author Id exists
				if(addAuthor) {
					tempBook.addAuthor(tempAuthor); 
					tempAuthor.addBook(tempBook); 
					session.save(tempAuthor);
				} else {
					tempBook.removeAuthor(tempAuthor);
					tempAuthor.removeBook(tempBook);
					session.save(tempAuthor);
				}
			}
			
			tempBook.setIsAvailable(updated_status);
			tempBook.setTitle(updated_title);
			tempBook.setDescription(updated_description);
			tempBook.setLocation(updated_location);
			tempBook.setDailyPrice(updated_dailyPrice);
			tempBook.setNumberPages(updated_numberPages);
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
	
	public static boolean returnBook(int bookId)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Author.class)
																				   .addAnnotatedClass(Book.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		Item tempBook = null;
		boolean flag = false;
		
		try
		{
			
			session.beginTransaction();
		
			tempBook = session.get(Book.class, bookId);
			
			if(tempBook == null) {
				System.out.println("Book ID does not match with any existing book");
				return flag;
			}
			
			tempBook.setIsAvailable(true);
			
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
