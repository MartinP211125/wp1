package mk.finki.ukim.mk.service;

import mk.finki.ukim.mk.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> listAuthors();
    public Author findById(Long id);
}
