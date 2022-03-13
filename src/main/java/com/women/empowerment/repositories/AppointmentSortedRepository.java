package com.women.empowerment.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.women.empowerment.entites.Appointment;


public interface AppointmentSortedRepository extends PagingAndSortingRepository<Appointment, Integer>{

}
