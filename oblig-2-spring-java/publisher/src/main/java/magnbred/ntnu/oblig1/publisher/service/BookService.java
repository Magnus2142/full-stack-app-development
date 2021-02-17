package magnbred.ntnu.oblig1.publisher.service;

import magnbred.ntnu.oblig1.publisher.model.Author;
import magnbred.ntnu.oblig1.publisher.model.Book;
import magnbred.ntnu.oblig1.publisher.repo.BookRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    Logger logger = LoggerFactory.getLogger(AuthorService.class);

    public List<Book> getBooks(){
        logger.info("Getting all books");
        return bookRepo.getBooks();
    }

    public Book getBook(int id){
        logger.info("Getting book with id: " + id);
        return bookRepo.getBook(id);
    }

    public Book getBook(String name){
        logger.info("Getting book with name: " + name);
        return bookRepo.getBook(name);
    }

    public void addBook(Book book){
        logger.info("Adding book: " + book.toString());
        bookRepo.addBook(book);
    }

    public void updateBook(Book book, int id){
        logger.info("Updating book with id: " + id);
        bookRepo.updateBook(book, id);
    }

    public void deleteBook(int id){
        logger.info("Deleting book with id: " + id);
        bookRepo.deleteBook(id);
    }
}
