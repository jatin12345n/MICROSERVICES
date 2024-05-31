package com.example.springbootoctober2023.repository;

import com.example.springbootoctober2023.model.Address;
import com.example.springbootoctober2023.model.Details;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonalRepository extends JpaRepository<Details ,Long> {


    public Optional<Details>findById(Long id);

    public Details findByName(String name);

    public Details findByPanNo(String panNo);

    public default String updateAddressByType(Address address){

        return "Address Updated Successfully ";
    }


}
