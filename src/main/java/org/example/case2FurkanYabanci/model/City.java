package org.example.case2FurkanYabanci.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CITY")
@Data
public class City {
    @Id
    @SequenceGenerator(name = "City" , sequenceName = "CITY_ID_SEQ")
    @GeneratedValue(generator = "City")
    private long id;

    @Column(name = "PLATE_CODE")
    private String plateCode;

    @Column(name = "NAME")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Country country;

    @OneToMany(mappedBy = "city",fetch = FetchType.LAZY)
    private List<District> districts;
}
