package com.namedquery;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
        Configuration config=new Configuration();
        config.configure("bookinfo.cfg.xml");
        
        SessionFactory sf=config.buildSessionFactory();
        
        Session s=sf.openSession();
        
        Transaction t=s.beginTransaction();
        
//        Book b1=new Book(12358,"C Programming","ABC",98765644,800);
//        Book b2=new Book(12300,"Python Programming","XYZ",98765682,900);
//        
//        s.save(b1);
//        s.save(b2);
        
        TypedQuery query= s.getNamedQuery("AllBookFetch");
		System.out.println(query.getResultList());
		
		
		TypedQuery query1= s.getNamedQuery("SingleBookFetch");
		query1.setParameter("book_id", 12358);
		System.out.println(query1.getResultList());

        
        t.commit();
        
        sf.close();
        s.close();
        
    }
}
