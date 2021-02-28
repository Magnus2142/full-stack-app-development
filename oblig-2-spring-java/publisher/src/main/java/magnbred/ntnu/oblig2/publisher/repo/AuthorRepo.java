package magnbred.ntnu.oblig2.publisher.repo;

import magnbred.ntnu.oblig2.publisher.dao.AuthorDao;
import magnbred.ntnu.oblig2.publisher.model.Address;
import magnbred.ntnu.oblig2.publisher.model.Author;
import magnbred.ntnu.oblig2.publisher.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AuthorRepo {

    @Autowired
    AuthorDao authorDao;


    public List<Author> getAuthors(){
        return authorDao.getAuthors();
    }

    public Author getAuthor(int id){
        return authorDao.getAuthor(id);
    }

    public Author getAuthor(String name){
        return authorDao.getAuthor(name);
    }

    public void addAuthor(Author author){
        authorDao.createAuthor(author);
    }

    public void updateAuthpor(Author author, int id){
        authorDao.updateAuthor(author, id);
    }

    public void deleteAuthor(int id){
        authorDao.deleteAuthor(id);
    }
}
