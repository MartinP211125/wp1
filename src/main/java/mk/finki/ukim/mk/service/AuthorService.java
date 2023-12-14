package mk.finki.ukim.mk.service;

import mk.finki.ukim.mk.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> listAuthors();
    public Optional<Author> findById(Long id);
    List<Author> findByBookId(Long id);
}
