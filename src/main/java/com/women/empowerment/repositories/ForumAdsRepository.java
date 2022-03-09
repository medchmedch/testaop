package com.women.empowerment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.women.empowerment.entites.ForumAd;


@Repository
public interface ForumAdsRepository extends JpaRepository<ForumAd, Long> {
}
