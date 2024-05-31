package com.example.springbootoctober2023.controller;

import com.example.springbootoctober2023.model.Address;
import com.example.springbootoctober2023.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    AddressService service;


    @PostMapping("/add_Address_details")
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
//
//    @PatchMapping("/updateAddress/{id}")
//   public Address updateAddressByType(@PathVariable Long id, @RequestBody Map<String, Object>type){
//        return service.updateAddressByType(id, type);
//   }

    @PatchMapping("/{id}")
    public ResponseEntity<Address>updateAddress(@PathVariable Long id,@RequestBody Map<String,Object>type){
        Address updateAddress=service.updateAddress(id,type);
        if (updateAddress!=null){
            return ResponseEntity.ok(updateAddress);
        }else {
            return ResponseEntity.notFound().build();
        }
    }




    @DeleteMapping("/delete_add_by_id/{id}")
    public String deleteById(@PathVariable Long id){
        return service.removeById(id);
    }

}
