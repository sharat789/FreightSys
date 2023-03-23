package model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String phoneNo;

    public User(String login, String password, String name, String surname, LocalDate birthDate, String phoneNo) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phoneNo = phoneNo;
    }
}
