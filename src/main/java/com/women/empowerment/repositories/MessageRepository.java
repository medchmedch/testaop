package com.women.empowerment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.women.empowerment.entites.Message;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
