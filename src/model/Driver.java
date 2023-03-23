package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Driver extends User {
    private LocalDate medCertDate;
    private String medCertNo;
    private String DriverLicenseNo;

    public Driver(String login, String password, String name, String surname, LocalDate birthDate, String phoneNo, LocalDate medCertDate, String medCertNo, String driverLicenseNo) {
        super(login, password, name, surname, birthDate, phoneNo);
        this.medCertDate = medCertDate;
        this.medCertNo = medCertNo;
        DriverLicenseNo = driverLicenseNo;
    }
}
