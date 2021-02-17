package magnbred.ntnu.oblig1.publisher.repo;

import magnbred.ntnu.oblig1.publisher.model.Address;
import magnbred.ntnu.oblig1.publisher.model.Author;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class AuthorRepo {

    private List<Author> authors = new ArrayList<>(Arrays.asList(
            new Author(1, "Magnus Bredeli", "2000.03.02", new Address("Festningsgata 11"), new ArrayList<>()),
            new Author(2, "Mads Selbo Nyberg", "2000.03.08", new Address("Oslo 11"), new ArrayList<>()),
            new Author(3, "Eirik SKillingstad", "2000.03.09", new Address("Festningsgata 11"), new ArrayList<>()),
            new Author(4, "Atalay Gøzlek", "2000.08.02", new Address("Festningsgata 11"), new ArrayList<>())
            ));


    public List<Author> getAuthors(){
        return authors;
    }

    public Author getAuthor(int id){
        return authors.stream().filter(author -> author.getId() == id).findFirst().get();
    }

    public void addAuthor(Author author){
        authors.add(author);
    }
}
