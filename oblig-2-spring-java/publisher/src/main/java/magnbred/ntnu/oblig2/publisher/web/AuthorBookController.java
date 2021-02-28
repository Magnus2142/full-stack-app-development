package magnbred.ntnu.oblig2.publisher.web;


import magnbred.ntnu.oblig2.publisher.model.Author;
import magnbred.ntnu.oblig2.publisher.model.Book;
import magnbred.ntnu.oblig2.publisher.service.AuthorBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorBookController {


    @Autowired
    private AuthorBookService authorBookService;

    @RequestMapping("/authors/{author_id}/books")
    public List<Book> getAuthorBooks(@PathVariable int author_id){
        return authorBookService.getAuthorBooks(author_id);
    }

    @RequestMapping("/books/{book_id}/authors")
    public List<Author> getBookAuthors(@PathVariable int book_id){
        return authorBookService.getBookAuthors(book_id);
    }

    @PutMapping("/books/{book_id}/authors/{author_id}")
    public void addAuthorToBook(@PathVariable int book_id, @PathVariable int author_id){
        authorBookService.addAuthorToBook(book_id, author_id);
    }
}
