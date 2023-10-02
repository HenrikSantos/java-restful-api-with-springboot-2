package com.henrik.javarestfulapiwithspringboot2.services;

import com.henrik.javarestfulapiwithspringboot2.models.AddressModel;
import com.henrik.javarestfulapiwithspringboot2.models.UserModel;
import com.henrik.javarestfulapiwithspringboot2.repositories.AddressRepository;
import com.henrik.javarestfulapiwithspringboot2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ViaCepService viaCepService;


    public Iterable<UserModel> findAll() {
        return userRepository.findAll();
    }
    public UserModel findByID(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void addOne(UserModel newUser) {
        saveAddresses(newUser);
        userRepository.save(newUser);
    }

    public void update(Long id, UserModel updatedUser) {
        Optional<UserModel> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();
            user.setName(updatedUser.getName());
            saveAddresses(updatedUser);
            userRepository.save(user);
        }
    }

    private void saveAddresses(UserModel user) {
        String cep = user.getAddress().getCep();
        AddressModel address = addressRepository.findById(cep).orElseGet(() -> {
            AddressModel newAddress = viaCepService.consultarCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        user.setAddress(address);
        userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
