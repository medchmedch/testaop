package com.example.demo1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1.entity.Cours;

@Repository
public interface ICoursRepository extends CrudRepository<Cours, Long>  {


}