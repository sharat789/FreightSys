package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Manager extends User {
    private String email;
    private LocalDate employmentDate;
    private boolean isAdmin;
    @ManyToMany
    private List<Destination> myManagedDestinations;

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
