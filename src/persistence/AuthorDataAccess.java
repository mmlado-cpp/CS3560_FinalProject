package persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Author;
import domain.Book;

public class AuthorDataAccess {
	public static boolean createAuthor(String name, String email, int bookId)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class)
																				   .addAnnotatedClass(Author.class).buildSessionFactory();
		boolean flag = false;
		Session session = factory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
			
			Book tempBook = session.get(Book.class, bookId);
			Author tempAuthor = new Author(name, email);
			
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
	
	public static boolean updateAuthor(int authorId, String updatedName, String updatedEmail) { //Overload (When you don't want to change book ID)
		return updateAuthor(authorId, updatedName, updatedEmail, -1);
	}
	
	public static boolean updateAuthor(int authorId, String updatedName, String updatedEmail, int updatedBookId)
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
			if(updatedBookId != -1) {
				tempAuthor.setBook(session.get(Book.class, updatedBookId));
			}
			
			tempAuthor.setName(updatedName);
			tempAuthor.setEmail(updatedEmail);
			
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
