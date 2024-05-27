package com.example.mongodb_immersion_crud.Service;

import com.example.mongodb_immersion_crud.Models.Address;
import com.example.mongodb_immersion_crud.Models.User;
import com.example.mongodb_immersion_crud.Repository.AddressRepository;
import com.example.mongodb_immersion_crud.Repository.UserRepository;
import com.example.mongodb_immersion_crud.dto.UserWithAddressesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUserWithAddresses(String userId, UserWithAddressesDTO userWithAddressesDTO){

        // Log addresses before update
        System.out.println("Addresses before update: " + userWithAddressesDTO);
        if (userWithAddressesDTO == null) {
            throw new IllegalArgumentException("UserWithAddressesDTO cannot be null");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id " + userId));
        // Update user details
        user.setFirstName(userWithAddressesDTO.getFirstName());
        user.setLastName(userWithAddressesDTO.getLastName());
        user.setAge((userWithAddressesDTO.getAge()));

        // Update or create addresses
        List<Address> addresses = new ArrayList<>();
        if (userWithAddressesDTO.getAddresses() != null) {
            for (UserWithAddressesDTO.AddressDTO addressDTO : userWithAddressesDTO.getAddresses()) {
                Address address = addressRepository.findById(addressDTO.getId()).orElse(new Address());
                address.setStreet(addressDTO.getStreet());
                address.setCity(addressDTO.getCity());
                address.setState(addressDTO.getState());
                addresses.add(addressRepository.save(address));
            }
        }

        // Remove addresses not present in the DTO
        user.getAddresses().removeIf(address -> !addresses.contains(address));

        // Set the updated addresses to the user
        user.setAddresses(addresses);


        System.out.print("User after update: " + user);


        return userRepository.save(user);
    }

    public User saveUserWithAddresses(UserWithAddressesDTO userWithAddressesDTO) {
        // Save addresses first
        List<Address> addresses = new ArrayList<>();
        for (UserWithAddressesDTO.AddressDTO addressDTO : userWithAddressesDTO.getAddresses()) {
            Address address = new Address();
            address.setStreet(addressDTO.getStreet());
            address.setCity(addressDTO.getCity());
            address.setState(addressDTO.getState());
            addresses.add(addressRepository.save(address));
        }

        // Save user with references to addresses
        User user = new User();
        user.setFirstName(userWithAddressesDTO.getFirstName());
        user.setLastName(userWithAddressesDTO.getLastName());
        user.setAge(userWithAddressesDTO.getAge());
        user.setAddresses(addresses);
        return userRepository.save(user);
    }
}
