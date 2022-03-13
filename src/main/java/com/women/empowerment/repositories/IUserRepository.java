package com.example.demo1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1.entity.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Long>  {


}