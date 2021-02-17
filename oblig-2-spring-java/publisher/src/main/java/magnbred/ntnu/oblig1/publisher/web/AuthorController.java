package magnbred.ntnu.oblig1.publisher.web;


import magnbred.ntnu.oblig1.publisher.model.Author;
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

    @RequestMapping(method = RequestMethod.POST, value = "/authors")
    public void addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
    }
}