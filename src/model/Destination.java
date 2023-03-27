package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String startCity;
    private long startLong;
    private long startLat;
    private long endLong;
    private long endLat;
            private LocalDate dateCreated;
            private LocalDate dateUpdated;
            @OneToMany(mappedBy = "destination", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
            private List<Checkpoint> checkpointList;
            @OneToOne(mappedBy = "currentDestination")
            private Truck truck;
            @ManyToMany(mappedBy = "myManagedDestinations" , cascade = CascadeType.ALL)
    private List<Manager> responsibleManagers;
    @OneToOne(mappedBy = "destination")
    private Cargo cargo;

    public Destination(String startCity, long startLong, long startLat, long endLong, long endLat, List<Checkpoint> checkpointList, List<Manager> responsibleManagers) {
        this.startCity = startCity;
        this.startLong = startLong;
        this.startLat = startLat;
        this.endLong = endLong;
        this.endLat = endLat;
        this.checkpointList = checkpointList;
        this.responsibleManagers = responsibleManagers;
    }

    public Destination(String startCity, long startLong, long startLat, long endLong, long endLat, List<Checkpoint> checkpointList, Truck truck, List<Manager> responsibleManagers, Cargo cargo) {
        this.startCity = startCity;
        this.startLong = startLong;
        this.startLat = startLat;
        this.endLong = endLong;
        this.endLat = endLat;
        this.checkpointList = checkpointList;
        this.truck = truck;
        this.responsibleManagers = responsibleManagers;
        this.cargo = cargo;
    }
}
