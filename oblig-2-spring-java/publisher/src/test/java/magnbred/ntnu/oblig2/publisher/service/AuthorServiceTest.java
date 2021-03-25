package magnbred.ntnu.oblig2.publisher.service;

import magnbred.ntnu.oblig2.publisher.model.Address;
import magnbred.ntnu.oblig2.publisher.model.Author;
import magnbred.ntnu.oblig2.publisher.repo.AuthorRepo;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class AuthorServiceTest {


    @InjectMocks
    private AuthorService authorService;

    @Mock
    private AuthorRepo authorRepo;


    @Test
    public void testGetAllAuthors(){
        List<Author> authors = new ArrayList<>();
        authors.add(new Author(1, "Magnus Bredeli", "03.02.2000", new Address("Festningsgata 11")));
        authors.add(new Author(2, "Mads Selbo Nyberg", "08.02.2000", new Address("Barcode 69")));
        when(authorRepo.getAuthors()).thenReturn(authors);

        List<Author> result = authorService.getAuthors();


        assertThat(result.get(0).getName()).isEqualTo("Magnus Bredeli");
        assertThat(result.get(1).getName()).isEqualTo("Mads Selbo Nyberg");

    }

    @Test
    public void testGetAuthorByName(){
        Author author = new Author(1, "Magnus Bredeli", "03.02.2000", new Address("Festningsgata 11"));
        when(authorRepo.getAuthor("Magnus Bredeli")).thenReturn(author);

        Author result = authorService.getAuthor("Magnus Bredeli");
        assertThat(result.getName()).isEqualTo("Magnus Bredeli");
        assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getAddress().getAddress()).isEqualTo("Festningsgata 11");
        assertThat(result.getDateOfBirth()).isEqualTo("03.02.2000");
    }

    @Test
    public void testGetAuthorById(){
        Author author = new Author(1, "Magnus Bredeli", "03.02.2000", new Address("Festningsgata 11"));
        when(authorRepo.getAuthor(1)).thenReturn(author);

        Author result = authorService.getAuthor(1);
        assertThat(result.getName()).isEqualTo("Magnus Bredeli");
        assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getAddress().getAddress()).isEqualTo("Festningsgata 11");
        assertThat(result.getDateOfBirth()).isEqualTo("03.02.2000");
    }

    @Test
    public void testAddAuthor(){
        Author author = new Author(1, "Magnus Bredeli", "03.02.2000", new Address("Festningsgata 11"));
        when(authorRepo.addAuthor(author)).thenReturn(1);

        int result = authorService.addAuthor(author);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void testUpdateAuthor(){
        Author author = new Author(1, "Magnus Bredeli", "03.02.2000", new Address("Festningsgata 11"));
        when(authorRepo.updateAuthpor(author, 1)).thenReturn(1);

        int result = authorService.updateAuthor(author, 1);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void testDeleteAuthor(){
        int id = 1;
        when(authorRepo.deleteAuthor(id)).thenReturn(1);

        int result = authorService.deleteAuthor(id);
        assertThat(result).isEqualTo(1);
    }
}
