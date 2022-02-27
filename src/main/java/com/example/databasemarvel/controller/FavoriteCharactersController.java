package com.example.databasemarvel.controller;

import com.example.databasemarvel.exceptions.ResourceNotFoundException;
import com.example.databasemarvel.model.FavoriteCharacters;
import com.example.databasemarvel.model.Users;
import com.example.databasemarvel.repositories.FavoriteCharactersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")

public class FavoriteCharactersController {
    @Autowired
    private FavoriteCharactersRepository favRepo;
    // Tested
    @GetMapping("allfavs")
    public List<FavoriteCharacters> getAllCharacters() {
        return favRepo.findAll();
    }

    // Tested
    @GetMapping("favsbyuserid/{id}")
    public List<FavoriteCharacters> getUserById(@PathVariable String id) {
        List<FavoriteCharacters> list = favRepo.findAllByUserId(id);
        if (list.isEmpty())throw new ResourceNotFoundException("List not found");

        return favRepo.findAllByUserId(id);
    }
    @GetMapping("favsbyid/{id}")
    public List<FavoriteCharacters> getFavById(@PathVariable Integer id) {
        List<FavoriteCharacters> list = favRepo.findAllByCharId(id);
        if (list.isEmpty())throw new ResourceNotFoundException("List not found");

        return favRepo.findAllByCharId(id);
    }
    //Tested
    @PostMapping("addtofavs")
    public FavoriteCharacters newFav(@RequestBody FavoriteCharacters favs){
        return  favRepo.save(favs);
    }
    @DeleteMapping("deletefav/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id ){
        favRepo.findById(id)
                .orElseThrow(() ->  new ResourceNotFoundException("User not found "));
        favRepo.deleteById(id);

        return new ResponseEntity<>("Favorite "+id+" deleted", HttpStatus.OK);
    }



}
