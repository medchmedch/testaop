package com.women.empowerment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.women.empowerment.entites.Channel;


@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
