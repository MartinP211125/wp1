package mk.finki.ukim.mk.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String biography;
    private LocalDate DateOfBirth;

    public Author(String name, String surname, String biography, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.biography = biography;
        this.DateOfBirth = dateOfBirth;
    }

    public Author() {

    }
}
