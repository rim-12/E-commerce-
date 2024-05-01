package com.example.UsersServices.Repository;

import com.example.UsersServices.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
    Optional<User> findByLastName(String lastName);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

}
