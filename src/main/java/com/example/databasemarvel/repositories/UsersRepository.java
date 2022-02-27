package com.example.databasemarvel.repositories;

import com.example.databasemarvel.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
// ===== REPOSITORY =====
// @Repository is a Spring annotation that indicates that the decorated class is a repository. A repository is a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects.

// JpaRepository - JPA stands for Java Persistence API, this is an extension of Repository. It contains an API of CrudRepository and PagingAndSortingRepository. It conatains API for basic CRUD operations, and it can also do pagination and sorting.

// Read more about repositories: https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html

// Read more about jpa repositories: https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html


@Repository
public interface UsersRepository extends JpaRepository<Users,String> {

    List<Users> findUsersByUserName(String userName);

    List<Users> findUsersByUserEmail(String userEmail);

}
