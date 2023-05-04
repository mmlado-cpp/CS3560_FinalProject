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
	
	public static boolean createAuthor(String name, int bookId)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class)
																				   .addAnnotatedClass(Author.class).buildSessionFactory();
		boolean flag = false;
		Session session = factory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
			
			Book tempBook = session.get(Book.class, bookId);
			Author tempAuthor = new Author(name);
			
			if(tempBook != null) { // Book ID exists
				tempBook.addAuthor(tempAuthor); //Add author to book
				session.save(tempBook);
			} else { // Book ID doesn't match with anything
				System.out.println("Book ID does not match with any existing book");
			}
			
			session.save(tempAuthor);
			
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
	
	public static Author getAuthor(int authorId)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Author.class)
																				   .addAnnotatedClass(Book.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		Author tempAuthor = null;
		
		try
		{
			
			session.beginTransaction();
			
			tempAuthor = session.get(Author.class, authorId);
			
			session.getTransaction().commit();
		
		} catch(Exception e)
		{
			 System.out.println("Problem creating session factory");
		     e.printStackTrace();
		} finally {
			factory.close();
		
		}
		return tempAuthor;
	}
	
	public static boolean updateAuthor(int authorId, String updatedName) { //Overload
		return updateAuthor(authorId, updatedName, -1);
	}
	
	public static boolean updateAuthor(int authorId, String updatedName, int updatedBookId)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Author.class)
																				   .addAnnotatedClass(Book.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		Author tempAuthor = null;
		boolean flag = false;
		
		try
		{
			session.beginTransaction();
			
			tempAuthor = session.get(Author.class, authorId);
			
			if(tempAuthor == null) {
				System.out.println("Author ID does not match with any existing author");
				return flag;
			}
			
			tempAuthor.setName(updatedName);
			
			Book tempBook = session.get(Book.class, updatedBookId);
			
			if(tempBook != null) {
				tempBook.addAuthor(tempAuthor);
				session.save(tempBook);
			} else {
				System.out.println("Book ID does not match with any existing book");
			}
			
			session.save(tempAuthor);
			
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
	
	public static Author deleteAuthor(int authorId)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Author.class)
																				   .addAnnotatedClass(Book.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		Author tempAuthor = null;
		
		try
		{
			
			session.beginTransaction();
		
			tempAuthor = session.get(Author.class, authorId);
			
			session.delete(tempAuthor);
			
			session.getTransaction().commit();

		} catch(Exception e)
		{
			 System.out.println("Problem creating session factory");
		     e.printStackTrace();
		} finally {
			factory.close();
		
		}
		return tempAuthor;
	}
}
