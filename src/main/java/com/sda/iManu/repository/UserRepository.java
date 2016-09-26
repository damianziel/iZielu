package com.sda.iManu.repository;

import com.sda.iManu.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kamil on 18.09.16.
 */

@Repository
public interface UserRepository extends MongoRepository<User, String> {

//    User findByFirstName(String firstName);

    User findByLogin(String login);

//    List<User> findByLastName(String lastName);

}
