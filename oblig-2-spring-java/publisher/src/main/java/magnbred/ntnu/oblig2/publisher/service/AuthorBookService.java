package magnbred.ntnu.oblig2.publisher.service;

import magnbred.ntnu.oblig2.publisher.model.Author;
import magnbred.ntnu.oblig2.publisher.model.Book;
import magnbred.ntnu.oblig2.publisher.repo.AuthorBookRepo;
import magnbred.ntnu.oblig2.publisher.web.AuthorBookController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorBookService {


    @Autowired
    AuthorBookRepo authorBookRepo;

    Logger logger = LoggerFactory.getLogger(AuthorBookService.class);

    public List<Book> getAuthorBooks(int author_id){
        logger.info("Getting all books that is written by author with id: " + author_id);
        return authorBookRepo.getAuthorBooks(author_id);
    }

    public List<Author> getBookAuthors(int book_id){
        logger.info("Getting all authors to the book with id: " + book_id);
        return authorBookRepo.getBookAuthors(book_id);
    }

    public void addAuthorToBook(int book_id, int author_id){
        logger.info("Adding author with id: " + author_id + "\n to book with id: " + book_id);
        authorBookRepo.addAuthorToBook(book_id, author_id);
    }
}
