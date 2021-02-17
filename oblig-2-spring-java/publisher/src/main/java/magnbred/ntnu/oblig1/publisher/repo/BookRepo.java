package magnbred.ntnu.oblig1.publisher.repo;

import magnbred.ntnu.oblig1.publisher.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepo {


    private List<Book> books = new ArrayList<>(Arrays.asList(
            new Book(1,"Lord of the rings", "2005.03.02", new ArrayList<>()),
            new Book(2, "The hobbit", "2007.03.02", new ArrayList<>()),
            new Book(3, "Sarablord", "2009.10.02", new ArrayList<>()),
            new Book(4, "Monsterbedriften", "2105.03.22", new ArrayList<>())
    ));


    public List<Book> getBooks(){
        return books;
    }

    public Book getBook(int id){
        return books.stream().filter(book -> book.getId() == id).findFirst().get();
    }

    public void addBook(Book book){
        books.add(book);
    }
}
