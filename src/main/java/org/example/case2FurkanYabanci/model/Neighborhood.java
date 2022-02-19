package org.example.case2FurkanYabanci.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "NEIGHBORHOOD")
@Data
public class Neighborhood {

    @Id
    @SequenceGenerator(name = "Neighborhood" , sequenceName = "NEIGHBORHOOD_ID_SEQ")
    @GeneratedValue(generator = "Neighborhood")
    private long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private District district;

    @OneToMany(mappedBy = "neighborhood",fetch = FetchType.LAZY)
    private List<Street> streets;
}
