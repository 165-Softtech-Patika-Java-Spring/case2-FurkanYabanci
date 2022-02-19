package org.example.case2FurkanYabanci.repository;

import org.example.case2FurkanYabanci.model.Address;
import org.example.case2FurkanYabanci.model.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NeighborhoodRepository extends JpaRepository<Neighborhood, Long> {

    List<Neighborhood> getNeighborhoodByDistrictId(long districtId);
}
