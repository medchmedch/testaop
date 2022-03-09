package com.women.empowerment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.women.empowerment.entites.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
