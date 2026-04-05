package com.jayesh.ecommerce.repository;

import com.jayesh.ecommerce.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {



}