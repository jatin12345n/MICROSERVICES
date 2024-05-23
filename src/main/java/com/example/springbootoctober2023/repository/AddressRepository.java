package com.example.springbootoctober2023.repository;

import com.example.springbootoctober2023.model.Address;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address ,Long> {

    public Optional<Address> findById(Long id);

    public Address findByCityName(String cityName);

    public Address findByStateName(String stateName);


}
