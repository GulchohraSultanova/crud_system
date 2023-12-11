package edu.cs.crud.crud_system.model;

import edu.cs.crud.crud_system.enums.SexEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "humans")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex", nullable = false)
    private SexEnum sex;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "height", nullable = false)
    private Integer height;

    @Column(name = "weight", nullable = false)
    private Integer weight;
}
