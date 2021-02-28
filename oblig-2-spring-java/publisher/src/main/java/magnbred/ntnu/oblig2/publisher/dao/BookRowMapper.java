package magnbred.ntnu.oblig2.publisher.dao;

import magnbred.ntnu.oblig2.publisher.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();

        book.setId(rs.getInt("BOOK_ID"));
        book.setName(rs.getString("BOOK_NAME"));
        book.setDateOfPublication(rs.getString("DATE_OF_PUBLICATION"));

        return book;
    }
}
