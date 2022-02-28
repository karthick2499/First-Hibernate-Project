package com.fetch.objecct;

import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {

	
	
	@SuppressWarnings({ "rawtypes", "removal" })
	public static void main(String[] args) {
		
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
		
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		
		Transaction t=session.beginTransaction();
		
		/*
		 * Book b=session.load(Book.class, new Long(12345)); //select * from Book where
		 * Bookid=12345; System.out.println(b);
		 * 
		 * Book b1=session.load(Book.class, new Long(12378)); System.out.println(b1);
		 * 
		 * 
		 * //Fetch object Query query = session.createQuery("from Book"); List<Book>
		 * books=query.list(); System.out.println("List of Books");
		 * System.out.println(books);
		 * 
		 * 
		 * //Update object Query q=session.
		 * createQuery("update Book set bookAuthorName=:bookAuthorName where bookId=:bookId "
		 * ); q.setString("bookAuthorName","Balaguruswamy"); q.setLong("bookId", 12345);
		 * q.executeUpdate();
		 * 
		 * //Delete object
		 * 
		 * Book bk=new Book(); bk.setBookId(12378); session.delete(bk);
		 * 
		 * 
		 * 
		 * //Delete operation using hql queries Query
		 * query=session.createQuery("delete from Book where bookId=:bookId");
		 * query.setLong("bookId", 12345); query.executeUpdate();
		 */
		 
		/*
		 * Query query=session.createQuery("select count(*) from Book"); List<Integer>
		 * count=query.list(); System.out.println(count.get(0));
		 * 
		 * 
		 * Query query1=session.createQuery("select avg(bookPrice) from Book");
		 * List<Integer> count1=query1.list(); System.out.println(count1.get(0));
		 * 
		 * 
		 * Query query2=session.createQuery("select max(bookPrice) from Book");
		 * List<Integer> count2=query2.list();
		 * System.out.println("Max book price="+count2.get(0));
		 * 
		 * 
		 * Query query3=session.createQuery("select min(bookPrice) from Book");
		 * List<Integer> count3=query3.list();
		 * System.out.println("Min book price="+count3.get(0));
		 * 
		 * 
		 * 
		 * query3=session.createQuery("select sum(bookPrice) from Book");
		 * count3=query3.list(); System.out.println("sum book price="+count3.get(0));
		 */
		
		
		TypedQuery q=session.getNamedQuery("fetchAllBook");
		System.out.println(q.getResultList());
		
		
		TypedQuery q1=session.getNamedQuery("fetchSingleBook");
		q1.setParameter("bookId",new Long(12300));
		System.out.println(q1.getResultList());

		
		t.commit();

	}

}
