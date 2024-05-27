package com.example.mongodb_immersion_crud.Service;


import com.example.mongodb_immersion_crud.Models.Address;
import com.example.mongodb_immersion_crud.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(String id, Address newAddress) {
        return addressRepository.findById(id)
                .map(address -> {
                    address.setStreet(newAddress.getStreet());
                    address.setCity(newAddress.getCity());
                    address.setState(newAddress.getState());
                    return addressRepository.save(address);
                })
                .orElseThrow(() -> new RuntimeException("Address not found with id " + id));
    }
}
