package com.example.databasemarvel.controller;


import com.example.databasemarvel.exceptions.ResourceNotFoundException;
import com.example.databasemarvel.repositories.UsersRepository;
import com.example.databasemarvel.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// A controller is a class that accepts HTTP request

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class UserController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("allusers")
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @GetMapping("userbyid/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable String id) {
        Users users1 = usersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return ResponseEntity.ok(users1);
    }


    @GetMapping("userbyname/{username}")
    public List<Users> getUserByUserName(@PathVariable String username) {
        List<Users> usersList = usersRepository.findUsersByUserName(username);
        if (usersList.isEmpty()) {
            throw new ResourceNotFoundException("Name not found");
        }
        return usersRepository.findUsersByUserName(username);
    }

    @GetMapping("userbyemail/{email}")
    public List<Users> getUserByEmail(@PathVariable String email) {
        List<Users> usersList = usersRepository.findUsersByUserEmail(email);
        if (usersList.isEmpty()) {
            throw new ResourceNotFoundException("Email not found");
        }
        return usersRepository.findUsersByUserEmail(email);
    }

    @PostMapping("adduser")
    public Users newUser(@RequestBody Users users){
        return  usersRepository.save(users);
    }

    @DeleteMapping("deleteuser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id ){
        usersRepository.findById(id)
                .orElseThrow(() ->  new ResourceNotFoundException("User not found "));
        usersRepository.deleteById(id);

        return new ResponseEntity<>("User "+id+" deleted", HttpStatus.OK);
    }

    @PutMapping("updateuser/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable String id, @RequestBody Users users){
        Users foundUser = usersRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found"));
                foundUser.setUserName(users.getUserName());
                foundUser.setUserEmail(users.getUserEmail());

                Users updatedUser = usersRepository.save(foundUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }
}


