package com.women.empowerment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.women.empowerment.entites.TopicClaim;

@Repository
public interface TopicClaimRepository extends JpaRepository<TopicClaim, Long> {
}
