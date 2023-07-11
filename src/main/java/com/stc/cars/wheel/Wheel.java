package com.stc.cars.wheel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wheel {

    public static final String WHEEL_SEQ = "wheel_seq";
    @Id
    @SequenceGenerator(
            name = WHEEL_SEQ,
            sequenceName = WHEEL_SEQ,
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = WHEEL_SEQ
    )
    private long id;

    @Column(name = "radius")
    private int radius;

    @Column(name = "profile")
    private int profile;

    @Enumerated(value = EnumType.STRING)
    private WheelType type;
}
