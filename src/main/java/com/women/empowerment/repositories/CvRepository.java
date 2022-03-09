package com.women.empowerment.repositories;
import com.women.empowerment.entites.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CvRepository extends JpaRepository<Cv, Integer> {

    @Query("SELECT P FROM Postulant P,Cv C join P.cv CP on C=CP AND P.id=:idPostulant")
    Cv getCvByPostulants(int idPostulant);

}
