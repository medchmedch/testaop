package com.women.empowerment.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.women.empowerment.entites.Like;



@Repository
public interface LikeRepository extends CrudRepository<Like, Integer>  {


}
