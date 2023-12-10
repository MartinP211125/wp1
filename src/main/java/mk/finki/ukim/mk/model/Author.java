package mk.finki.ukim.mk.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Author {
    Long id;
    String name;
    String surname;
    String biography;


}
