package magnbred.ntnu.oblig2.publisher.model;

import java.util.ArrayList;
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

    public Book(int id, String name, String dateOfPublication) {
        this.id = id;
        this.name = name;
        this.dateOfPublication = dateOfPublication;
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