package com.example.mongodb_immersion_crud.Controller;

import com.example.mongodb_immersion_crud.Models.Address;
import com.example.mongodb_immersion_crud.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/api/addresses")
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @PostMapping(value = "/api/address")
    public Address saveAddress(@RequestBody Address address) {
        return addressService.saveAddress(address);
    }

    @PutMapping(value = "api/address/{id}")
    public Address updateAddress(@PathVariable String id, @RequestBody Address newAddress) {
        return addressService.updateAddress(id, newAddress);
    }

}
