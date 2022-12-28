package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Data
@Entity
@Getter
public class Balloon {
    private String name;
    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Manufacturer manufacturer;

//    @ManyToOne
//    private BalloonType balloonType;

    public Balloon(String name, String description, Manufacturer manufacturer) {
//        this.balloonType = balloonType;
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    public Balloon() {

    }

    public Balloon(String name, String description) {
        this.name=name;
        this.description=description;
    }

    public String getName() {
        return name;
    }
}
