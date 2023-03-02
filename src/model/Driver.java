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

public class Driver extends User {
    private LocalDate medCertDate;
    private int medCertNo;
    private String DriverLicenseNo;

    public Driver(String login, String password, String name, String surname, LocalDate birthDate, String phoneNo, LocalDate medCertDate, int medCertNo, String driverLicenseNo) {
        super(login, password, name, surname, birthDate, phoneNo);
        this.medCertDate = medCertDate;
        this.medCertNo = medCertNo;
        DriverLicenseNo = driverLicenseNo;
    }
}
