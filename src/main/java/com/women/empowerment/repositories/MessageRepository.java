package com.women.empowerment.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.women.empowerment.entites.Message;



@Repository
public interface MessageRepository extends CrudRepository<Message, Integer>   {

}
