package magnbred.ntnu.oblig2.publisher.service;

import magnbred.ntnu.oblig2.publisher.model.Author;
import magnbred.ntnu.oblig2.publisher.model.Book;
import magnbred.ntnu.oblig2.publisher.repo.AuthorRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    Logger logger = LoggerFactory.getLogger(AuthorService.class);

    public List<Author> getAuthors(){
        logger.info("Getting all authors");
        return authorRepo.getAuthors();
    }

    public Author getAuthor(int id){
        logger.info("Getting author with id: " + id);
        return authorRepo.getAuthor(id);
    }

    public Author getAuthor(String name){
        logger.info("Getting author with name: " + name);
        return authorRepo.getAuthor(name);
    }

    public void addAuthor(Author author){
        logger.info("Adding author: " + author.toString());
        authorRepo.addAuthor(author);
    }

    public void updateAuthor(Author author, int id){
        logger.info("Updating author with id: " + id);
        authorRepo.updateAuthpor(author, id);
    }

    public void deleteAuthor(int id){
        logger.info("Deleting author with id: " + id);
        authorRepo.deleteAuthor(id);
    }
}
