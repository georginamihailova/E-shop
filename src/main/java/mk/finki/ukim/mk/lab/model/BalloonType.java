package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "balloonType")
public class BalloonType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String typeName;

    public BalloonType(String typeName) {
        this.typeName = typeName;
    }

    public BalloonType() {

    }
}
