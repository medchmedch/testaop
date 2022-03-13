package com.women.empowerment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.women.empowerment.entites.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
