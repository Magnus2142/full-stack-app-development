package magnbred.ntnu.oblig2.publisher.dao;

import magnbred.ntnu.oblig2.publisher.model.Author;
import magnbred.ntnu.oblig2.publisher.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDao {


    @Autowired
    JdbcTemplate jdbcTemplate;

    //Er dette okay?????
    @Autowired
    AuthorDao authorDao;

    public List<Book> getBooks(){
        String query = "SELECT * FROM BOOK";
        return jdbcTemplate.query(query, new BookRowMapper());
    }

    public Book getBook(int id){
        String query = "SELECT * FROM BOOK WHERE BOOK_ID = ?";
        return jdbcTemplate.queryForObject(query, new BookRowMapper(), id);
    }

    public Book getBook(String name){
        String query = "SELECT * FROM BOOK WHERE BOOK_NAME = ?";
        return jdbcTemplate.queryForObject(query, new BookRowMapper(), name);
    }

    public void updateBook(Book book, int id){
        String query = "UPDATE BOOK SET BOOK_NAME = ?, DATE_OF_PUBLICATION = ? WHERE BOOK_ID = ?";
        jdbcTemplate.update(query, book.getName(), book.getDateOfPublication(), id);
    }

    public void deleteBook(int id){
        String query = "DELETE FROM BOOK WHERE BOOK_ID = ?";
        jdbcTemplate.update(query, id);
    }

    public void createBook(Book book){
        boolean authors_exist = true;
        for(int i = 0; i < book.getAuthors().size(); i ++){
            if(!(authorDao.authorIsValid(book.getAuthors().get(i).getId()))){
                authors_exist = false;
            }
        }

        if(authors_exist){
            String addQuery = "INSERT INTO BOOK VALUES(?, ?, ?)";
            jdbcTemplate.update(addQuery, book.getId(), book.getName(), book.getDateOfPublication());
            String relationQuery = "INSERT INTO AUTHOR_BOOK VALUES(?, ?)";
            book.getAuthors().stream().forEach(author -> jdbcTemplate.update(relationQuery, author.getId(), book.getId()));
        }else{
            System.out.println("Error, some of the authors does not exist");
        }
    }



}
