package magnbred.ntnu.oblig2.publisher.dao;

import magnbred.ntnu.oblig2.publisher.model.Author;
import magnbred.ntnu.oblig2.publisher.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDao {


    @Autowired
    JdbcTemplate jdbcTemplate;


    public void createAuthor(Author author){
        String query = "INSERT INTO AUTHOR VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(query, author.getId(), author.getName(), author.getDateOfBirth(), author.getAddress().getAddress());
    }

    public List<Author> getAuthors(){
        String query = "SELECT * FROM AUTHOR";
        return jdbcTemplate.query(query, new AuthorRowMapper());
    }

    public Author getAuthor(int id){
        String query = "SELECT * FROM AUTHOR where AUTHOR_ID = ?";
        return jdbcTemplate.queryForObject(query, new AuthorRowMapper(), id);
    }

    public Author getAuthor(String name){
        String query = "SELECT * FROM AUTHOR WHERE AUTHOR_NAME = ?";
        return jdbcTemplate.queryForObject(query, new AuthorRowMapper(), name);
    }

    public void updateAuthor(Author author, int id){
        String query = "UPDATE AUTHOR SET AUTHOR_NAME = ?, DATE_OF_BIRTH = ?, ADDRESS = ? WHERE AUTHOR_ID = ?";
        jdbcTemplate.update(query, author.getName(), author.getDateOfBirth(), author.getAddress().getAddress(), id);
    }

    public void deleteAuthor(int id){
        String query = "DELETE FROM AUTHOR WHERE AUTHOR_ID = ?";
        jdbcTemplate.update(query, id);
    }

    public boolean authorIsValid(int id){
        String query = "SELECT COUNT(*) FROM AUTHOR WHERE AUTHOR_ID = ?";
        int isValid = jdbcTemplate.queryForObject(query, new Object[] { id }, Integer.class);
        return isValid == 1;
    }

}
