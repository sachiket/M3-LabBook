package com.cg.iter.client;

import javax.persistence.EntityManager;


import com.cg.iter.DBUtil.Db;
import com.cg.iter.entities.Author;
import com.cg.iter.entities.Book;

public class addEntity {
	Db con;
	EntityManager manager;
	
	public addEntity() {
		
		con=new Db();
		manager=con.getManager();
		
		//1st input 
		Author eric = new Author("Eric");
		Book book1 = new Book(1234,"Domain Driven Design" , 100);
		eric.getBookList().add(book1);
		book1.getAuthorList().add(eric);
		
		//2nd input
		Author moe = new Author("Moe");
		Book book2 = new Book(2345,"JPA" , 600);
		moe.getBookList().add(book2);
		book2.getAuthorList().add(moe);
		
		//3nd input
		Author joe = new Author("Koe");
		Book book3 = new Book(3456,"C#" , 750);
		joe.getBookList().add(book3);
		book3.getAuthorList().add(joe);
		
		manager.getTransaction().begin();
		manager.persist(eric);
		manager.persist(book1);
	
		manager.persist(moe);
		manager.persist(book2);
		
		manager.persist(joe);
		manager.persist(book3);
		manager.getTransaction().commit();
		
		
		
		
	}

	


}
