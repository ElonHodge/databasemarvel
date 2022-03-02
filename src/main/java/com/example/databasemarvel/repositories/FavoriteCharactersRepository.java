package com.example.databasemarvel.repositories;

import com.example.databasemarvel.model.FavoriteCharacters;
import com.example.databasemarvel.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteCharactersRepository  extends JpaRepository<FavoriteCharacters,Integer> {


    List<FavoriteCharacters> findAllByUserId(String Id);
    List<FavoriteCharacters> findAllByCharId(Integer Id);

    FavoriteCharacters  findByFavId(Integer Id);
}
