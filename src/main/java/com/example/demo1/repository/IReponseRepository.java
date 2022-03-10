package com.example.demo1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1.entity.Reponse;

@Repository
public interface IReponseRepository extends CrudRepository<Reponse, Long>  {


}