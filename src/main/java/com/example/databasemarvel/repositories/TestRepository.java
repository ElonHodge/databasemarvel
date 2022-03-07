package com.example.databasemarvel.repositories;

import com.example.databasemarvel.model.FavoriteCharacters;
import com.example.databasemarvel.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<Test,String> {

    List<Test> findAllByTestId(String Id);

}
