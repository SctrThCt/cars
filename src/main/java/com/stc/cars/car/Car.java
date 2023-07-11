package com.stc.cars.car;

import com.stc.cars.driver.Driver;
import com.stc.cars.engine.Engine;
import com.stc.cars.wheel.Wheel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "car")
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    public static final String CAR_SEQ = "car_seq";
    @Id
    @SequenceGenerator(
            name = CAR_SEQ,
            sequenceName = CAR_SEQ,
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = CAR_SEQ
    )
    private long id;

    @Column(name = "model")
    private String model;

    public Car(long id, String model) {
        this.id = id;
        this.model = model;
    }

    @ManyToOne(
            targetEntity = Engine.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "engine_id")
    private Engine engine;

    @ManyToOne(
            targetEntity = Driver.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @JoinColumn(name = "left_front_wheel_id")
    @ManyToOne(
            targetEntity = Driver.class,
            fetch = FetchType.LAZY
    )
    private Wheel leftFrontWheel;

    @JoinColumn(name = "right_front_wheel_id")
    @ManyToOne(
            targetEntity = Driver.class,
            fetch = FetchType.LAZY
    )
    private Wheel rightFrontWheel;

    @JoinColumn(name = "left_rear_wheel_id")
    @ManyToOne(
            targetEntity = Driver.class,
            fetch = FetchType.LAZY
    )
    private Wheel leftRearWheel;

    @JoinColumn(name = "right_rear_wheel_id")
    @ManyToOne(
            targetEntity = Driver.class,
            fetch = FetchType.LAZY
    )
    private Wheel rightRearWheel;
}
