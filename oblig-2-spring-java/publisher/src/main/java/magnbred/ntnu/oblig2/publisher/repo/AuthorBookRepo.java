package magnbred.ntnu.oblig2.publisher.repo;

import magnbred.ntnu.oblig2.publisher.dao.AuthorBookDao;
import magnbred.ntnu.oblig2.publisher.dao.AuthorDao;
import magnbred.ntnu.oblig2.publisher.model.Author;
import magnbred.ntnu.oblig2.publisher.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorBookRepo {


    @Autowired
    AuthorBookDao authorBookDao;

    public List<Book> getAuthorBooks(int author_id){
        return authorBookDao.getAuthorBooks(author_id);
    }

    public List<Author> getBookAuthors(int book_id){
        return authorBookDao.getBookAuthors(book_id);
    }

    public void addAuthorToBook(int book_id, int author_id){
        authorBookDao.addAuthorToBook(author_id, book_id);
    }
}
