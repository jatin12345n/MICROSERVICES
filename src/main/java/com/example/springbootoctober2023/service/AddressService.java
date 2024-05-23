package com.example.springbootoctober2023.service;

import com.example.springbootoctober2023.model.Address;
import com.example.springbootoctober2023.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository repository;

    public String add(Address address) {
        repository.save(address);
        return "Successfully Saved to dataBase";
    }

    public String updateAddressDetails(String type, String cityName, String stateName, int pinCode, String addressLine1, String addressLine2, Long id) {
        Address address = repository.getById(id);
        address.setType(type);
        address.setCityName(cityName);
        address.setStateName(stateName);
        address.setPinCode(pinCode);
        address.setAddressLine1(addressLine1);
        address.setAddressLine2(addressLine2);
        repository.save(address);

        if (id == null) {
            return "Address not found";
        } else {
            return "Successfully Updated Details as " + type + cityName + stateName + pinCode + addressLine1 + addressLine2;
        }
    }

    public List<Address> getAllAddressDetails() {
        return repository.findAll();
    }

    public Optional<Address> getAddressById(Long id) {
        return repository.findById(id);

    }

    public Address getAddressByCityName(String cityName) {
        return repository.findByCityName(cityName);
    }

    public Address getAddressByStateName(String stateName) {
        return repository.findByStateName(stateName);
    }

    public String removeById(Long id) {
        repository.deleteById(id);
        return "Successfully deleted from Database";
    }
}
