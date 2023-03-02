package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Manager extends User {
    private String email;
    private LocalDate employmentDate;
    private boolean isAdmin;

    public Manager(String login, String password, String name, String surname, LocalDate birthDate, String phoneNo, String email) {
        super(login, password, name, surname, birthDate, phoneNo);
        this.employmentDate = LocalDate.now();
        this.email = email;
    }

    public Manager(String login, String password, String name, String surname, LocalDate birthDate, String phoneNo, String email, boolean isAdmin) {
        super(login, password, name, surname, birthDate, phoneNo);
        this.employmentDate = LocalDate.now();
        this.email = email;
        this.isAdmin = isAdmin;
    }
}
