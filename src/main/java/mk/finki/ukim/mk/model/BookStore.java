package mk.finki.ukim.mk.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class BookStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String address;

    public BookStore(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

    public BookStore() {

    }
}
