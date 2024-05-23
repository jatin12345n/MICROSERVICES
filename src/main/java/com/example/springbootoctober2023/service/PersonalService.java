package com.example.springbootoctober2023.service;

import com.example.springbootoctober2023.model.Details;
import com.example.springbootoctober2023.repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PersonalService {


    @Autowired
    PersonalRepository repository;

    public String add(Details details) {
        repository.save(details);
        return "Successfully saved to database";
    }

    public List<Details> getAllPersonalDetails() {
        return repository.findAll();
    }

    public Optional<Details> getDetailsById(Long id) {
        return repository.findById(id);// SELECT * FROM TABLE WHERE ID=?


    }

    public Details getDetailsByName(String name) {
        return repository.findByName(name);// SELECT * FROM TABLE WHERE ID=?


    }

    public Details getDetailsByPanNo(String panNo) {
        return repository.findByPanNo(panNo);// SELECT * FROM TABLE WHERE ID=?


    }

    public String updateDetails(String name, String panNo, int phoneNo, String email, Long id) {

        Details details = repository.getById(id);
        details.setName(name);
        details.setPanNo(panNo);
        details.setPhoneNo(phoneNo);
        details.setEmail(email);
        repository.save(details);

        if (id == null) {
            return "Customer not found";
        } else {
            return "Successfully Updated Details as " + name + panNo + phoneNo + email;
        }
    }

    public String removeById(Long id) {
        repository.deleteById(id);//DELETE FROM TABLE WHERE ID=?
        return "Successfully Deleted from DataBase";
    }


}
