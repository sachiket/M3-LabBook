package com.cg.iter.dao;

import javax.persistence.EntityManager;
import com.cg.iter.DBUtil.Db;
import com.cg.iter.bean.Author;

public class AuthorDAOImpl implements AuthorDAO{
	

	Db con;
	EntityManager manager;

	public AuthorDAOImpl() {
		con = new Db();
		manager=con.getManager();
	}


	@Override
	public boolean addAuthor(Author author) {
		try {
			manager.getTransaction().begin();
			manager.persist(author);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteAuthor(Author author) {
		try {
			manager.remove(author);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateAuthor(Author author) {
		try {
			manager.getTransaction().begin();
			manager.merge(author);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Author findAuthor(Integer id) {
		return manager.find(Author.class, id);
	}

}
