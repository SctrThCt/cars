package com.stc.cars.driver;

import com.stc.cars.car.Car;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NamedEntityGraph
@NoArgsConstructor
public class Driver {
    public static final String DRIVER_SEQ = "driver_seq";
    @Id
    @SequenceGenerator(
            name = DRIVER_SEQ,
            sequenceName = DRIVER_SEQ,
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = DRIVER_SEQ
    )
    private long id;

    @Column(name = "name")
    private String name;

    @Enumerated(value = EnumType.STRING)
    private LicenseCategory category;

    @OneToMany(
            targetEntity = Car.class,
            fetch = FetchType.LAZY
    )
    @JoinTable(
            joinColumns = {@JoinColumn(name = "driver_id")},
            inverseJoinColumns = {@JoinColumn(name = "car_id")})
    private List<Car> cars;
}
