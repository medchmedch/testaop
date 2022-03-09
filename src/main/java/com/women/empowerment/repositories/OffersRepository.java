package com.women.empowerment.repositories;

import com.women.empowerment.entites.Offers;
import com.women.empowerment.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface OffersRepository extends JpaRepository<Offers, Integer> {
    List<Offers> getOffersByUser(User user);
}
