package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public abstract class User {
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
