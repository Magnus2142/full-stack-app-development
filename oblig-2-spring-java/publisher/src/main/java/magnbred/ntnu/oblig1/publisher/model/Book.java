package magnbred.ntnu.oblig1.publisher.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Book
 */
public class Book {

    private int id;
    private String name;
    private String dateOfPublication;
    private List<Author> authors;


    public Book() {
    }

    public Book(int id, String name, String dateOfPublication, List<Author> authors) {
        this.id = id;
        this.name = name;
        this.dateOfPublication = dateOfPublication;
        this.authors = authors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfPublication() {
        return this.dateOfPublication;
    }

    public void setDateOfPublication(String dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public List<Author> getAuthors() {
        return this.authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }



}