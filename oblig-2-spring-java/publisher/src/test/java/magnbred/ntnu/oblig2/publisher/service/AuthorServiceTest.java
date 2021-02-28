package magnbred.ntnu.oblig2.publisher.service;

import magnbred.ntnu.oblig2.publisher.model.Address;
import magnbred.ntnu.oblig2.publisher.model.Author;
import magnbred.ntnu.oblig2.publisher.repo.AuthorRepo;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.lenient;



@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class AuthorServiceTest {


    @InjectMocks
    private AuthorService authorService;

    @Mock
    private AuthorRepo authorRepo;


    @BeforeEach
    public void setUp(){

        Author author = new Author(1, "Magnus Bredeli", "03.02.2000", new Address("Festningsgata 11"));
        Author author2 = new Author(2, "Mads Selbo Nyberg", "08.02.2000", new Address("Barcode 69"));

        List<Author> authors = Arrays.asList(author, author2);

        lenient().when(authorRepo.getAuthors()).thenReturn(authors);
        lenient().when(authorRepo.getAuthor(1)).thenReturn(author);
        lenient().when(authorRepo.getAuthor("Magnus Bredeli")).thenReturn(author);
        lenient().doNothing().when(authorRepo).addAuthor(author);
    }

    @Test
    public void testGetAllAuthors(){
        List<Author> authors = authorService.getAuthors();

        assertThat(authors.get(0).getName()).isEqualTo("Magnus Bredeli");
    }
}
