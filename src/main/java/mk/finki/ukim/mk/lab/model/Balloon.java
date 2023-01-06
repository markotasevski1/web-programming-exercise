package mk.finki.ukim.mk.lab.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Optional;
import java.util.Random;

@Data
@Entity
@Table(name = "Balloon")
public class Balloon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private String name;
   private String description;

   @ManyToOne
   private Manufacturer manufacturer;



    public Balloon(String name, String description,Manufacturer manufacturer) {

        this.manufacturer=manufacturer;
        this.name = name;
        this.description = description;
    }

    public Balloon(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Balloon() {
    }
}
