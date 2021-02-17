package magnbred.ntnu.oblig1.publisher.service;

import magnbred.ntnu.oblig1.publisher.model.Author;
import magnbred.ntnu.oblig1.publisher.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    public List<Author> getAuthors(){
        return authorRepo.getAuthors();
    }

    public Author getAuthor(int id){
        return authorRepo.getAuthor(id);
    }

    public void addAuthor(Author author){
        authorRepo.addAuthor(author);
    }
}
