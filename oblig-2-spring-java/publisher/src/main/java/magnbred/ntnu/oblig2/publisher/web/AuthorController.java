package magnbred.ntnu.oblig2.publisher.web;


import magnbred.ntnu.oblig2.publisher.model.Author;
import magnbred.ntnu.oblig2.publisher.model.Book;
import magnbred.ntnu.oblig2.publisher.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
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

    @PostMapping("/authors")
    @ResponseBody
    public Author addAuthor(@RequestBody Author author, HttpServletResponse httpServletResponse, WebRequest request){
        authorService.addAuthor(author);

        httpServletResponse.setStatus(HttpStatus.CREATED.value());
        httpServletResponse.setHeader("Location", String.format("%s/authors/%s", request.getContextPath(), author.getId()));

        return author;
    }

    @PutMapping("/authors/{id}")
    public Author updateAuthor(@RequestBody Author author, @PathVariable int id){
        authorService.updateAuthor(author, id);
        return author;
    }

    @DeleteMapping("/authors/{id}")
    public void deleteAuthor(@PathVariable int id, HttpServletResponse httpServletResponse){
        authorService.deleteAuthor(id);
        httpServletResponse.setStatus(HttpStatus.ACCEPTED.value());
    }
}