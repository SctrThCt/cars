package com.stc.cars.engine;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "engines")
public class Engine {

    public static final String ENGINE_SEQ = "engines_seq";
    @Id
    @SequenceGenerator(
            name = ENGINE_SEQ,
            sequenceName = ENGINE_SEQ,
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = ENGINE_SEQ
    )
    private long id;

    @Column(name = "engine_model")
    private String engineModel;

    @Column(name = "volume")
    private int volume;

    @Enumerated(value = EnumType.STRING)
    private EngineType type;
}
