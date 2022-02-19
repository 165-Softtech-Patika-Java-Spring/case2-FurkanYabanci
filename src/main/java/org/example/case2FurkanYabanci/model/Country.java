package org.example.case2FurkanYabanci.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COUNTRY")
@Data
public class Country {

    @Id
    @SequenceGenerator(name = "Country" , sequenceName = "COUNTRY_ID_SEQ")
    @GeneratedValue(generator = "Country")
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COUNTRY_CODE")
    private String countryCode;

    @OneToMany(mappedBy = "country",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<City> cities;
}
