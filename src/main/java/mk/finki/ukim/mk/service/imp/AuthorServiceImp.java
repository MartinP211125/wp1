package mk.finki.ukim.mk.service.imp;

import mk.finki.ukim.mk.model.Author;
import mk.finki.ukim.mk.repository.AuthorRepository;
import mk.finki.ukim.mk.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImp implements AuthorService{

    public final AuthorRepository authorRepository;

    public AuthorServiceImp(AuthorRepository authorService) {
        this.authorRepository = authorService;
    }

    @Override
    public List<Author> listAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id);
    }
}
