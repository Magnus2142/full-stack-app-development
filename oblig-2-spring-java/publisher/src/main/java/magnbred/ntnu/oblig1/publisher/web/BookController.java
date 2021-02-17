package magnbred.ntnu.oblig1.publisher.web;

import magnbred.ntnu.oblig1.publisher.model.Book;
import magnbred.ntnu.oblig1.publisher.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;


    @RequestMapping("/books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @RequestMapping("/books/{id}")
    public Book getBook(@PathVariable int id){
        return bookService.getBook(id);
    }

    @RequestMapping("/books/name={name}")
    public Book getBook(@PathVariable String name){
        return bookService.getBook(name);
    }

    @PostMapping( "/books")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @PutMapping("/books/{id}")
    public void updateBook(@RequestBody Book book, @PathVariable int id){
        bookService.updateBook(book, id);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
    }
}
