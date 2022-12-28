package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import lombok.Getter;
import mk.finki.ukim.mk.lab.model.attribute.UserFullName;
import mk.finki.ukim.mk.lab.model.converter.UserFullNameConverter;
import mk.finki.ukim.mk.lab.model.enumType.Role;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Data
@Entity
@Table(name = "balloonUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    private String username;
    private String name;
    private String surname;

    @Convert(converter = UserFullNameConverter.class)
    private UserFullName userFullName;

    private String password;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    @OneToMany(mappedBy = "user")
    private List<ShoppingCart> carts;

    public User() {
    }

    public User(String username, String name, String surname, String password) {
        this.userFullName = new UserFullName();
        this.userFullName.setName(name);
        this.userFullName.setSurname(surname);
        this.username = username;
        this.password = password;
        this.dateOfBirth = LocalDate.now();
    }
    public User(String username, String name, String surname, String password,Role role) {
        this.userFullName = new UserFullName();
        this.userFullName.setName(name);
        this.userFullName.setSurname(surname);
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public User(String username,String password){
        this.username = username;
        this.password = password;
    }

    public User(String username) {
        this.username=username;
    }
}
