package org.example.case2FurkanYabanci.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
@Data
public class Address {

    @Id
    @SequenceGenerator(name = "Address" , sequenceName = "ADDRESS_ID_SEQ")
    @GeneratedValue(generator = "Address")
    private long id;

    @Column(name = "DOOR_NUMBER",nullable = false)
    private int doorNumber;

    @Column(name = "APARTMENT_NUMBER",nullable = false)
    private int apartmentNumber;

    @ManyToOne
    private Country country;

    @ManyToOne
    private City city;

    @ManyToOne
    private District district;

    @ManyToOne
    private Neighborhood neighborhood;

    @ManyToOne
    private Street street;
}
