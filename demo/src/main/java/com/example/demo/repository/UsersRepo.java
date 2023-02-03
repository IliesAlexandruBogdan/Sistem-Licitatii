package com.example.demo.repository;


import com.example.demo.modal.Users;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepo extends CrudRepository<Users, Long> {
    List<Users> findAll();
    Optional<User>FindById(Long id);

}
