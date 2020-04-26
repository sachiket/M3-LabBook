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
			manager.getTransaction().begin();
			manager.remove(author);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Author updateAuthor(Author author) {
		try {	
			manager.getTransaction().begin();
			Author temp = findAuthor(author.getAuthorId());
			temp.setFirstName(author.getFirstName());
			temp.setLastName(author.getLastName());
			temp.setMiddleName(author.getMiddleName());
			temp.setPhoneNo(author.getPhoneNo());
                        manager.merge(temp);

			manager.getTransaction().commit();
			return temp;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Author findAuthor(Integer id) {
		return manager.find(Author.class, id);
	}

}
