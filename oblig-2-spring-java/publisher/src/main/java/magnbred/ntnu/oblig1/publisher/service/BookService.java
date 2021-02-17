package magnbred.ntnu.oblig1.publisher.service;

import magnbred.ntnu.oblig1.publisher.model.Author;
import magnbred.ntnu.oblig1.publisher.model.Book;
import magnbred.ntnu.oblig1.publisher.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public List<Book> getBooks(){
        return bookRepo.getBooks();
    }

    public Book getBook(int id){
        return bookRepo.getBook(id);
    }

    public void addBook(Book book){
        bookRepo.addBook(book);
    }
}
