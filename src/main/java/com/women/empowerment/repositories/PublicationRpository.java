package com.women.empowerment.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.women.empowerment.entites.Publication;


@Repository
public interface PublicationRpository extends CrudRepository<Publication, Integer>  {

}
