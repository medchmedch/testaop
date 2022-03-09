package com.women.empowerment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.women.empowerment.entites.TopicRate;

@Repository
public interface TopicRateRepository extends JpaRepository<TopicRate, Long> {
}
