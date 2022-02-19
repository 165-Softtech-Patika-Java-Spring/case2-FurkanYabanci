package org.example.case2FurkanYabanci.repository;

import org.example.case2FurkanYabanci.model.Address;
import org.example.case2FurkanYabanci.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetRepository extends JpaRepository<Street, Long> {

    List<Street> getStreetByNeighborhoodId(long neighborhoodId);
}
