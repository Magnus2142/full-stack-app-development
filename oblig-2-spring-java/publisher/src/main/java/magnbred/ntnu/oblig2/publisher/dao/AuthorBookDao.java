package magnbred.ntnu.oblig2.publisher.dao;

import magnbred.ntnu.oblig2.publisher.model.Author;
import magnbred.ntnu.oblig2.publisher.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorBookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;



    public List<Book> getAuthorBooks(int author_id){
        String query = "SELECT * FROM AUTHOR_BOOK JOIN BOOK ON AUTHOR_BOOK.BOOK_ID = BOOK.BOOK_ID AND AUTHOR_BOOK.AUTHOR_ID = ?";
        return jdbcTemplate.query(query, new BookRowMapper(), author_id);
    }

    public List<Author> getBookAuthors(int book_id){
        String query = "SELECT * FROM AUTHOR_BOOK JOIN AUTHOR ON AUTHOR_BOOK.AUTHOR_ID = AUTHOR.AUTHOR_ID AND AUTHOR_BOOK.BOOK_ID = ?";
        return jdbcTemplate.query(query, new AuthorRowMapper(), book_id);
    }

    public void addAuthorToBook(int author_id, int book_id){
        String query = "INSERT INTO AUTHOR_BOOK VALUES(?, ?)";
        jdbcTemplate.update(query, author_id, book_id);
    }
}
