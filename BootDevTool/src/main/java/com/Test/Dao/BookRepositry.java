package com.Test.Dao;

import org.springframework.data.repository.CrudRepository;

import com.Test.entity.Book;

public interface BookRepositry extends CrudRepository<Book, Integer> {

	public Book findById(int id);
}
