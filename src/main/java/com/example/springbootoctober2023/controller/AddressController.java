package com.example.springbootoctober2023.controller;

import com.example.springbootoctober2023.model.Address;
import com.example.springbootoctober2023.model.Details;
import com.example.springbootoctober2023.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressController {

    @Autowired
    AddressService service;


    @GetMapping("/add_Address_details")
    public String add(@RequestBody Address address) {
        return service.add(address);
    }


    @GetMapping("/get_all_address_details")
    public List<Address> getAllAddressDetails() {
        return service.getAllAddressDetails();
    }

    @GetMapping("/get_add_By_id/{id}")
    public Optional<Address> getAddressById(@PathVariable Long id) {

        return service.getAddressById(id);
    }

    @GetMapping("/get_add_By_cityName/{cityName}")
    public Address getAddressByCityName(@PathVariable String cityName) {

        return service.getAddressByCityName(cityName);
    }

    @GetMapping("/get_add_By_stateName/{stateName}")
    public Address getAddressByStateName(@PathVariable String stateName) {

        return service.getAddressByStateName(stateName);
    }




    @PatchMapping("/update_Address_Details")
    public String updateAddressDetails(@RequestParam String type, @RequestParam String cityName, @RequestParam String stateName, @RequestParam int pinCode, @RequestParam String addressLine1, @RequestParam String addressLine2, @RequestParam Long id) {

        return service.updateAddressDetails(type, cityName, stateName, pinCode, addressLine1, addressLine2, id);

    }
    @DeleteMapping("/delete_add_by_id/{id}")
    public String deleteById(@PathVariable Long id){
        return service.removeById(id);
    }

}
