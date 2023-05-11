package persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Author;
import domain.Book;
import domain.Documentary;
import domain.DocumentaryProducer;

public class AuthorDataAccess {
	public static Author createAuthor(String name, String email, String subject, String nationality, int bookId)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class)
																				   .addAnnotatedClass(Author.class).buildSessionFactory();
		Author tempAuthor = null;
		Session session = factory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
			
			Book tempBook = session.get(Book.class, bookId);
			tempAuthor = new Author(name, email, subject, nationality);
			
			if(tempBook != null) { // Book ID exists
				tempBook.addAuthor(tempAuthor); //Add author to book
				tempAuthor.addBook(tempBook);
				session.save(tempBook);
			} else { // Book ID doesn't match with anything
				System.out.println("Book ID does not match with any existing book");
			}
			
			session.save(tempAuthor);
			
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
	
	public static List<Integer> getBookList(int code){
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Author.class).addAnnotatedClass(Book.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		List<Integer> bookIds = new ArrayList<Integer>();
		
		try
		{
			
			session.beginTransaction();
			
			List<Book> books = session.get(Author.class, code).getBooks();
			
			if(books != null) {
				for(Book book : books) {
					bookIds.add(book.getItemId());
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
		return bookIds;
	}
	
	public static List<Author> getAllAuthors(){
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Author.class).addAnnotatedClass(Book.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		List<Author> authors = null;
		
		try
		{
			
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Author> criteria = builder.createQuery(Author.class);
			criteria.from(Author.class);
			
			authors = session.createQuery(criteria).getResultList();
			
			session.getTransaction().commit();
		
		} catch(Exception e)
		{
			 System.out.println("Problem creating session factory");
		     e.printStackTrace();
		} finally {
			factory.close();
		
		}
		return authors;
	}
	
	public static boolean updateAuthor(int authorId, String updatedName, String updatedEmail, String updatedSubject, String updatedNationality, int updatedBookId, boolean addBook)
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
			Book tempBook = session.get(Book.class, updatedBookId);
			
			if(tempBook != null) { // Documentary ID exists
				if(addBook) {
					tempBook.addAuthor(tempAuthor); //Add producer to doc
					tempAuthor.addBook(tempBook); //Add documentary to producer
					session.save(tempBook);
				} else {
					tempBook.removeAuthor(tempAuthor);
					tempAuthor.removeBook(tempBook);
					session.save(tempBook);
				}
			}
			
			tempAuthor.setName(updatedName);
			tempAuthor.setEmail(updatedEmail);
			tempAuthor.setSubject(updatedSubject);
			tempAuthor.setNationality(updatedNationality);
			
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
	
	public static boolean deleteAuthor(int authorId)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Author.class)
																				   .addAnnotatedClass(Book.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		boolean flag = true;
		
		try
		{
			
			session.beginTransaction();
		
			Author tempAuthor = session.get(Author.class, authorId);
			
			session.delete(tempAuthor);
			
			session.getTransaction().commit();

		} catch(Exception e)
		{
			flag = false;
			System.out.println("Problem creating session factory");
		    e.printStackTrace();
		} finally {
			factory.close();
		
		}
		return flag;
	}
}
