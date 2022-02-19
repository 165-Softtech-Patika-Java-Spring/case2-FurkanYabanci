package org.example.case2FurkanYabanci.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DISTRICT")
@Data
public class District {
    @Id
    @SequenceGenerator(name = "District" , sequenceName = "DISTRICT_ID_SEQ")
    @GeneratedValue(generator = "District")
    private long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "district",fetch = FetchType.LAZY)
    private List<Neighborhood> neighborhoods;
}
