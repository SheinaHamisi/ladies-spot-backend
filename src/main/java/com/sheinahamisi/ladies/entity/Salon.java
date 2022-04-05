package com.sheinahamisi.ladies.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "salon"
)
public class Salon {
    @Id
    @SequenceGenerator(
            name = "salon_sequence",
            sequenceName = "salon_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "salon_sequence"
    )
    private Long id;
    @Column(name = "name")
    @Lob
    private String name;
    @Column(name = "image")
    @Lob
    private String image;
    @Column(name = "location")
    @Lob
    private String location;
    @Column(name = "phone")
    private String phone;
    @Column(name = "ratings")
    private Integer ratings;
    @Column(name = "working_hours")
    private String workingHours;
}
