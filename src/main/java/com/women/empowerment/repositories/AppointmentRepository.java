package com.women.empowerment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.women.empowerment.entites.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer>{
	
	@Query("SELECT a FROM Appointment a WHERE a.title like %:motCle% ")
	 public List<Appointment> findAllByTitle_Id( @Param("motCle") String motCle);


}
