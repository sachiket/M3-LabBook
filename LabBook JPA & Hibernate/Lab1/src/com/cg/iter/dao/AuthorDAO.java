package com.cg.iter.dao;

import com.cg.iter.bean.Author;

public interface AuthorDAO {
	public boolean addAuthor(Author author);
	public boolean deleteAuthor(Author author);
	public boolean updateAuthor(Author author);
	public Author findAuthor(Integer id);
}
