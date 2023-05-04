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
}
