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

    public int addAuthor(Author author){
        return authorDao.createAuthor(author);
    }

    public int updateAuthpor(Author author, int id){
        return authorDao.updateAuthor(author, id);
    }

    public int deleteAuthor(int id){
        return authorDao.deleteAuthor(id);
    }
}
