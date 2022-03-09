package com.women.empowerment.repositories;
import com.women.empowerment.entites.Offers;
import com.women.empowerment.entites.Postulant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PostulantRepository extends JpaRepository<Postulant, Integer> {
    Postulant getPostulantByOffers(Offers offers);
    List<Postulant> deletePostulantsByOffers(Offers offers);

    List<Postulant> findPostulantByAnswer(boolean answer);
}
