package com.women.empowerment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.women.empowerment.entites.Claim;
@Repository
public interface ClaimRepository extends JpaRepository<Claim,Integer>{

}
