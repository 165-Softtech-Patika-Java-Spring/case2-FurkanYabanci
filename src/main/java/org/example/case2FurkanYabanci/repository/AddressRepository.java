package org.example.case2FurkanYabanci.repository;

import org.example.case2FurkanYabanci.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
