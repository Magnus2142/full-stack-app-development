package magnbred.ntnu.oblig1.publisher.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Author
 */
public class Author {

    private int id;
    private String name;
    private String dateOfBirth;
    private Address address;
    private List<Book> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Author() {
    }

    public Author(int id, String name, String dateOfBirth, Address address, List<Book> books) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.books = books;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Author name(String name) {
        setName(name);
        return this;
    }

    public Author dateOfBirth(String dateOfBirth) {
        setDateOfBirth(dateOfBirth);
        return this;
    }

    public Author address(Address address) {
        setAddress(address);
        return this;
    }

    public Author books(List<Book> books) {
        setBooks(books);
        return this;
    }

}