package com.women.empowerment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.women.empowerment.entites.OwnedChannels;

@Repository
public interface OwnedChannelRepository extends JpaRepository<OwnedChannels, Long> {
}
