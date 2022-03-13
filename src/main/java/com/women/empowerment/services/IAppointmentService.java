package com.women.empowerment.services;

import java.util.List;

import com.women.empowerment.entites.Appointment;

public interface IAppointmentService {

	 void ajouterAppointment (Appointment appointment);
	    List<Appointment> getAppointment();
	    Appointment getAppointmentById(int id );
	    void deleteAppointment(int id);
		List<Appointment> listAppointmentsByTitle(String motCle);
		public List<Appointment> getAllAppointment(Integer pageNo, Integer pageSize, String sortBy);

		void affecterAppointmentToUser( int idUser,int idApp);





}
