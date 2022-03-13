package com.women.empowerment.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.women.empowerment.entites.Appointment;
import com.women.empowerment.entites.User;
import com.women.empowerment.repositories.AppointmentRepository;
import com.women.empowerment.repositories.AppointmentSortedRepository;
import com.women.empowerment.repositories.UserRepository;


@Service
public class AppointmentService implements IAppointmentService{
	@Autowired
    private AppointmentRepository appointmentRepository ;
	
	@Autowired
	private AppointmentSortedRepository sortedRepository;
	
    private UserRepository userRepository ;

    
	
    @Override
    public void ajouterAppointment(Appointment appointment) {
    	
        this.appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAppointment() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(int id) {
        return appointmentRepository.findById(id).get();
    }

    @Override
    public void deleteAppointment(int id) {
    	appointmentRepository.deleteById(id);
    }
    
 
    @Override
    public List<Appointment> listAppointmentsByTitle( String motCle) {
        return this.appointmentRepository.findAllByTitle_Id(motCle);
    }

	public List<Appointment> getAllAppointment(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
 
        Page<Appointment> pagedResult = sortedRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Appointment>();
        }}
        
    	@Override
    	public void affecterAppointmentToUser(int idUser,int idApp){
    		Appointment appointment = appointmentRepository.findById(idApp).get();
    		User u=new User();
    		u.setIdUser(idUser);
    		appointment.setUser(u);
    		appointmentRepository.save(appointment);
    }


}
