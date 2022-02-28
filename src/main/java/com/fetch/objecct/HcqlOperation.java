package com.fetch.objecct;

import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.hibernate.Book;

public class HcqlOperation {

	public static void main(String[] args) {
		
		Configuration c=new Configuration();
		c.configure();
		
		SessionFactory factory=c.buildSessionFactory();
		Session session=factory.openSession();
		
		Transaction t=session.beginTransaction();
		
		
		// select * from Book where bookPrice>700;
		Criteria crt=session.createCriteria(Book.class);
		crt.add(Restrictions.gt("bookPrice", new Double(700)));
		System.out.println(crt.list());
		
		//select * from Book order by bookId;
		Criteria crt1=session.createCriteria(Book.class);
		crt1.addOrder(Order.asc("bookId"));
		System.out.println(crt1.list());
		
		//Projection
		Criteria crt2=session.createCriteria(Book.class);
		crt2.setProjection(Projections.property("bookName"));
		System.out.println(crt2.list());
		
		//select bookName from Book;
		TypedQuery query= session.getNamedQuery("AllBookFetch");
		System.out.println(query.getResultList());
		
		
		TypedQuery query1= session.getNamedQuery("SingleBookFetch");
		query1.setParameter("bookId", 9876);
		System.out.println(query1.getResultList());

		
		
		

	}

}
