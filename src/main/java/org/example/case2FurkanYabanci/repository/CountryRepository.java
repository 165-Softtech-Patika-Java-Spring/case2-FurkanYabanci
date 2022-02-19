package org.example.case2FurkanYabanci.repository;

import org.example.case2FurkanYabanci.model.Address;
import org.example.case2FurkanYabanci.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    Country getCountryByCountryCode(String countryCode);
}
