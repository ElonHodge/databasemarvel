package com.example.databasemarvel.controller;


import com.example.databasemarvel.exceptions.ResourceNotFoundException;
import com.example.databasemarvel.model.Test;
import com.example.databasemarvel.model.Users;
import com.example.databasemarvel.repositories.TestRepository;
import com.example.databasemarvel.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// A controller is a class that accepts HTTP request

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class TestController {
    @Autowired
    private TestRepository testRepo;

    @GetMapping("test")
    public List<Test> getAll() {
        return testRepo.findAll();
    }

}


