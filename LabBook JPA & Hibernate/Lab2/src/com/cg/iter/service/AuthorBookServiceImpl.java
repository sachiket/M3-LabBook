package com.cg.iter.service;

import java.util.List;

import com.cg.iter.dao.AuthorBookDAO;
import com.cg.iter.dao.AuthorBookDAOImpl;
import com.cg.iter.entities.Book;

public class AuthorBookServiceImpl implements AuthorBookService {

	AuthorBookDAO dao= new AuthorBookDAOImpl();
	@Override
	public List<Book> getAllBooks() {
		return dao.getAllBooks();
	}

	@Override
	public List<Book> getBooksByAuthor(String author_name) {
		return dao.getBooksByAuthor(author_name);
	}

	@Override
	public List<Book> getBooksByPriceRange(double min, double max) {
		if(min>=0&&max>0&&min<max)
			return dao.getBooksByPriceRange(min, max);
		else
			return null;
	}

	@Override
	public List<String> getAuthorName(long b_id) {
		if(b_id>0)
			return dao.getAuthorName(b_id);
		else
			return null;
	}

}
