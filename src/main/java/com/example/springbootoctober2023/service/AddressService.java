package com.example.springbootoctober2023.service;

import com.example.springbootoctober2023.model.Address;
import com.example.springbootoctober2023.model.Details;
import com.example.springbootoctober2023.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository repository;

    public String add(Address address) {
        repository.save(address);
        return "Successfully saved to database";
    }

//        public String updateAddress(Long id,String type) {
//        Optional<Address> address1 = repository.findById(id);
//        if (address1.isPresent()) {
//            Address address = address1.get();
//
//
//
//            if (address.getType().equals("Current")) {
//                return "Current" + updateCurrentAddress(address);
//
//            } else {
//                return "Permanent" + updatePermanentAddress(address);
//            }
//        } else {
//            return "Address not found";
//        }
//    }

//    public String updateCurrentAddress(Long id,Address currentAddress) {
//    Address address =repository.findById(id)
//            .orElseThrow(() -> new ResourceNotFoundException("user not found with id: "+id));
//
//    address.setCurrentAddress(currentAddress);
//    return repository.save(address);
//
//    }


    //    public Address updateAddressByType(Long id, Map<String, Object> type) {
//        Optional<Address> existingAddress = repository.findById(id);
//        if (existingAddress.isPresent()) {
//            type.forEach((key, value) -> {
//                Field field = ReflectionUtils.findField(Address.class, key);
//                field.setAccessible(true);
//                ReflectionUtils.setField(field, existingAddress.get(), value);
//            });
//           return repository.save(existingAddress.get());
//
//        }
//        return null;
//    }
    public Address updateAddress(Long id, Map<String, Object> type) {
        Optional<Address> existingAddress = repository.findById(id);
        if (existingAddress.isPresent()) {
            Address address = existingAddress.get();
            String addressType = (String) type.get("type");
            if (addressType != null) {
                if (addressType.equalsIgnoreCase("CURRENT")) {
                    updateCurrentAddress(address, type);
                } else if (addressType.equalsIgnoreCase("PERMANENT")) {
                    updatePremAddress(address, type);
                }
            }
            return repository.save(address);
        }
        return null;
    }

    private void updateCurrentAddress(Address address, Map<String, Object> type) {
        type.forEach((key, value) -> {
            if (!key.equalsIgnoreCase("type")) {
                Field field = ReflectionUtils.findField(Address.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, address, value);
            }
        });
    }

    private void updatePremAddress(Address address, Map<String, Object> type) {
        type.forEach((key, value) -> {
            if (!key.equalsIgnoreCase("type")) {
                Field field = ReflectionUtils.findField(Address.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, address, value);
            }
        });
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
