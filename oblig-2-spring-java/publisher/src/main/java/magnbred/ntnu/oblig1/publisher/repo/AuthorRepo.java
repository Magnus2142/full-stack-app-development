package magnbred.ntnu.oblig1.publisher.repo;

import magnbred.ntnu.oblig1.publisher.model.Address;
import magnbred.ntnu.oblig1.publisher.model.Author;
import magnbred.ntnu.oblig1.publisher.model.Book;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class AuthorRepo {

    private List<Author> authors = new ArrayList<>(Arrays.asList(
            new Author(1, "Magnus Bredeli", "2000.03.02", new Address("Festningsgata 11")),
            new Author(2, "Mads Selbo Nyberg", "2000.03.08", new Address("Oslo 11")),
            new Author(3, "Eirik SKillingstad", "2000.03.09", new Address("Festningsgata 11")),
            new Author(4, "Atalay Gøzlek", "2000.08.02", new Address("Festningsgata 11"))
            ));


    public List<Author> getAuthors(){
        return authors;
    }

    public Author getAuthor(int id){
        return authors.stream().filter(author -> author.getId() == id).findFirst().get();
    }

    public Author getAuthor(String name){
        return authors.stream().filter(author -> author.getName().equalsIgnoreCase(name)).findFirst().get();
    }

    public List<Book> getAuthorBooks(int id){
        //Dummy data
        Book book = new Book(1,"Lord of the rings", "2005.03.02");
        authors.stream().filter(author -> author.getId() == id).findFirst().get().getBooks().add(book);

        return authors.stream().filter(author -> author.getId() == id).findFirst().get().getBooks();
    }

    public void addAuthor(Author author){
        authors.add(author);
    }

    public void updateAuthpor(Author author, int id){
        for(int i = 0; i < authors.size(); i ++){
            Author a = authors.get(i);
            if(a.getId() == id){
                authors.set((i), author);
                return;
            }
        }
    }

    public void deleteAuthor(int id){
        authors.removeIf(author -> author.getId() == id);
    }
}
