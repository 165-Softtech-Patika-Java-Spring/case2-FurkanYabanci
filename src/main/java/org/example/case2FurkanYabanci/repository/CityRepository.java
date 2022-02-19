package org.example.case2FurkanYabanci.repository;

import org.example.case2FurkanYabanci.model.Address;
import org.example.case2FurkanYabanci.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City getCityByPlateCode(String plateCode);
}
