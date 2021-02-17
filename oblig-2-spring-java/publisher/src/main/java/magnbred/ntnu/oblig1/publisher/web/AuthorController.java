package magnbred.ntnu.oblig1.publisher.web;


import magnbred.ntnu.oblig1.publisher.model.Author;
import magnbred.ntnu.oblig1.publisher.model.Book;
import magnbred.ntnu.oblig1.publisher.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AuthorController
 */
@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping("/authors")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @RequestMapping("/authors/{id}")
    public Author getAuthor(@PathVariable int id){
        return authorService.getAuthor(id);
    }

    @RequestMapping("/authors/name={name}")
    public Author getAuthor(@PathVariable String name){
        return authorService.getAuthor(name);
    }

    @RequestMapping("/authors/{id}/books")
    public List<Book> getAuthorBooks(@PathVariable int id){
        return authorService.getAuthorBooks(id);
    }

    @PostMapping("/authors")
    public void addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
    }

    @PutMapping("/authors/{id}")
    public void updateAuthor(@RequestBody Author author, @PathVariable int id){
        authorService.updateAuthor(author, id);
    }

    @DeleteMapping("/authors/{id}")
    public void deleteAuthor(@PathVariable int id){
        authorService.deleteAuthor(id);
    }
}