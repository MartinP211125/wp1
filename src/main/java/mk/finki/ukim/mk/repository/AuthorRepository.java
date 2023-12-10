package mk.finki.ukim.mk.repository;

import mk.finki.ukim.mk.bootstrap.DataHolder;
import mk.finki.ukim.mk.model.Author;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository {

    public List<Author> findAll(){
        return DataHolder.authorList;
    }

    public Author findById(Long id){
        Optional<Author> var = DataHolder.authorList.stream().filter(r -> r.getId().equals(id)).findFirst();
        return var.orElse(null);
    }
}
