package magnbred.ntnu.oblig2.publisher.repo;

import magnbred.ntnu.oblig2.publisher.dao.BookDao;
import magnbred.ntnu.oblig2.publisher.model.Author;
import magnbred.ntnu.oblig2.publisher.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    Logger logger = LoggerFactory.getLogger(BookRepo.class);

    @Autowired
    BookDao bookDao;

    public List<Book> getBooks(){
        return bookDao.getBooks();
    }

    public Book getBook(int id){
        return bookDao.getBook(id);
    }

    public Book getBook(String name){
        return bookDao.getBook(name);
    }

    public void addBook(Book book){
        if(!(book.getAuthors().size() == 0)){
            bookDao.createBook(book);
        }else{
            logger.error("ERROR! Can't add book without any authors");
        }
    }

    public void updateBook(Book book, int id){
        bookDao.updateBook(book, id);
    }
    public void deleteBook(int id){
        bookDao.deleteBook(id);
    }
}
