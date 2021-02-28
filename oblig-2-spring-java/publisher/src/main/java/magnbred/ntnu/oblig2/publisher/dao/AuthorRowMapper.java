package magnbred.ntnu.oblig2.publisher.dao;

import magnbred.ntnu.oblig2.publisher.model.Address;
import magnbred.ntnu.oblig2.publisher.model.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRowMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();

        author.setId(rs.getInt("AUTHOR_ID"));
        author.setName(rs.getString("AUTHOR_NAME"));
        author.setDateOfBirth(rs.getString("DATE_OF_BIRTH"));
        author.setAddress(new Address(rs.getString("ADDRESS")));

        return author;
    }
}
