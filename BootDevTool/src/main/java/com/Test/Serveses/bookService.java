package com.Test.Serveses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Test.Dao.BookRepositry;
import com.Test.entity.Book;



@Component
public class bookService {
	
	@Autowired
	private BookRepositry bookRepository;
	
//	private static List<Book> list=new ArrayList<>();
//	
//	static {
//	list.add(new Book(3,"java Reference","Mohd Sahazad"));
//	list.add(new Book(5,"java Reference sahazad","Mohd Asif"));
//	list.add(new Book(7,"pythan","Zibran Ansari"));
//	
//	}
    
	// get all books
	public List<Book> getAllBooks()
	{
		List<Book> list =(List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	//get single book
	public Book getBookById(int Id) 
	{
		Book book=null;
		try
		{
		//book=list.stream().filter(e->e.getId()==Id).findFirst().get();
			book=this.bookRepository.findById(Id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return book;
	}
	
	// add new book
	public Book addBook(Book b)
	{
		//list.add(b);
		Book book = bookRepository.save(b);
		return b;
	}
	
	//delete book
	public void deleteBook(int bid)
	{
		
	  //list = list.stream().filter(book ->book.getId()!=bid).collect(Collectors.toList());
		bookRepository.deleteById(bid);
	}
	
	
	//update Book
	public void updateBook(Book book,int bookId)

	{
//		list.stream().map(b->{
//			if(b.getId()==bookId)
//			{
//				b.setAuthor(book.getAuthor());
//				b.setTitle(book.getTitle());
//			}
//			return b;
//			
//		}).collect(Collectors.toList());
		book.setId(bookId);
		bookRepository.save(book);
		
	}

}
