package com.cg.iter.service;

import com.cg.iter.bean.Author;

public interface AuthorService {
	public boolean addAuthor(Author author);
	public Author updateAuthor(Author author);
	public boolean deleteAuthor(Integer id);
	public Author findAuthor(Integer id);
}