package com.example.springbootoctober2023.controller;

import com.example.springbootoctober2023.model.Details;
import com.example.springbootoctober2023.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class PersonalController {

    @Autowired
    PersonalService service;

    @GetMapping("/add_personal_details")
    public String add(@RequestBody Details details) {
        return service.add(details);
    }

    @GetMapping("/get_all_personal_details")
    public List<Details> getAllPersonalDetails() {
        return service.getAllPersonalDetails();
    }

    @GetMapping("/get_per_By_id/{id}")
    public Optional<Details> getDetailsById(@PathVariable Long id) {

        return service.getDetailsById(id);
    }

    @GetMapping("/get_per_By_name/{name}")
    public Details getDetailsByName(@PathVariable String name) {

        return service.getDetailsByName(name);
    }

    @GetMapping("/get_per_By_id/{panNo}")
    public Details getDetailsByPanNo(@PathVariable String panNo) {

        return service.getDetailsByPanNo(panNo);
    }

    @PatchMapping("/update_personal_Details")
    public String updateDetails(@RequestParam String name, @RequestParam String panNo, @RequestParam int phoneNo, @RequestParam String email, @RequestParam Long id) {

        return service.updateDetails(name, panNo, phoneNo, email, id);

    }

    @DeleteMapping("/remove_per_by_id/{id}")
    public String deleteById(@PathVariable Long id) {
        return service.removeById(id);
    }

}
