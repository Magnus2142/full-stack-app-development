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

    @RequestMapping(method = RequestMethod.POST, value = "/books")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }
}
