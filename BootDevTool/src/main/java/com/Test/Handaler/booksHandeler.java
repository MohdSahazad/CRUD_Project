package com.Test.Handaler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Test.Serveses.bookService;
import com.Test.entity.Book;

@RestController
public class booksHandeler {
	
	@Autowired
	private bookService BookService;
	
	//get all book handaler
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBook() {
       
		List<Book> list = BookService.getAllBooks();
		if(list.size() <=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
					
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
		
		
	}
	
	//get single book handeler
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id)
	{
		Book book = BookService.getBookById(id);
		if(book==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
		
		
	}
	
	//create new book handeler
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book)
	{
		Book b=null;
		try {
			b=BookService.addBook(book);
			return ResponseEntity.of(Optional.of(b));
			
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
		
	}
	
	// delete book handeler
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<?> deleteBook(@PathVariable("bookId") int bookId)
	{
		try {
			this.BookService.deleteBook(bookId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	//update book handeler
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId)
	{

try {
	this.BookService.updateBook(book,bookId);
	return ResponseEntity.ok().body(book);
	
} catch (Exception e) {
e.printStackTrace();
return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}
		
		
	}
	
	

}
