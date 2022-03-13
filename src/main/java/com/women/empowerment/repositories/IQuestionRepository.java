package com.example.demo1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1.entity.Question;

@Repository
public interface IQuestionRepository extends CrudRepository<Question, Long>  {


}