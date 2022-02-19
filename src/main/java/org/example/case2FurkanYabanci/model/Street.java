package org.example.case2FurkanYabanci.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "STREET")
@Data
public class Street {

    @Id
    @SequenceGenerator(name = "Street" , sequenceName = "STREET_ID_SEQ")
    @GeneratedValue(generator = "Street")
    private long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Neighborhood neighborhood;
}
