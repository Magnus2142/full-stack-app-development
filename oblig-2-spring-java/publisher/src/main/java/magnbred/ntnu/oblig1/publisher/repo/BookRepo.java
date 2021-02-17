package magnbred.ntnu.oblig1.publisher.repo;

import magnbred.ntnu.oblig1.publisher.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepo {


    private List<Book> books = new ArrayList<>(Arrays.asList(
            new Book(1,"Lord of the rings", "2005.03.02"),
            new Book(2, "The hobbit", "2007.03.02"),
            new Book(3, "Sarablord", "2009.10.02"),
            new Book(4, "Monsterbedriften", "2105.03.22")
    ));


    public List<Book> getBooks(){
        return books;
    }

    public Book getBook(int id){
        return books.stream().filter(book -> book.getId() == id).findFirst().get();
    }

    public Book getBook(String name){
        return books.stream().filter(book -> book.getName().equalsIgnoreCase(name)).findFirst().get();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void updateBook(Book book, int id){
        for(int i = 0; i < books.size(); i ++){
            Book b = books.get(i);
            if(b.getId() == id){
                books.set(i, book);
                return;
            }
        }
    }
    public void deleteBook(int id){
        books.removeIf(b -> b.getId() == id);
    }
}
