package mk.finki.ukim.mk.service.imp;

import mk.finki.ukim.mk.model.Author;
import mk.finki.ukim.mk.repository.jpa.AuthorRepository;
import mk.finki.ukim.mk.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImp implements AuthorService{

    private final AuthorRepository authorRepository;

    public AuthorServiceImp(AuthorRepository authorService) {
        this.authorRepository = authorService;
    }

    @Override
    public List<Author> listAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> findByBookId(Long id) {
        return authorRepository.findByBookId(id);
    }
}
