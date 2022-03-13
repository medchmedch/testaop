package com.women.empowerment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.women.empowerment.entites.Appointment;
import com.women.empowerment.services.AppointmentService;


@Controller
@RequestMapping("/appointment")
public class AppointmentController {

	  @Autowired
	    private  AppointmentService appointmentService ;
	  
	  @GetMapping("/affectToUser/{idUser}/{idApp}")
		@ResponseBody
		public void affectToUser(@PathVariable("idUser") int idUser, @PathVariable("idApp") int IdApp) {
			appointmentService.affecterAppointmentToUser(idUser, IdApp);
			}
	  


	    @PostMapping("/addAppointment")
	    public ResponseEntity<Appointment> ajouterClaim (@RequestBody Appointment appointment) {

	    	appointmentService.ajouterAppointment(appointment);
	            return ResponseEntity.ok().body(appointment);
	    }
	    
	    @GetMapping("/getAllAppointment")
	    public ResponseEntity<List<Appointment>> getAllClaim() {
	        return ResponseEntity.ok().body(appointmentService.getAppointment());
	    }

	    @GetMapping("/getAppointmentById/{id}")
	    public ResponseEntity<Appointment> getUserById(@PathVariable("id") int id) {
	        return ResponseEntity.ok().body(appointmentService.getAppointmentById(id));
	    }

	    @DeleteMapping("/deleteAppointment/{id}")
	    public void deleteAppointment(@PathVariable("id") int id) {
	    	appointmentService.deleteAppointment(id);
	    }
	    
	    @GetMapping("/recherche/{motCle}")
	    public  ResponseEntity< List<Appointment>> listAppointmentsByTitle(  @PathVariable("motCle") String motCle){
	                                     
	        return ResponseEntity.ok().body(appointmentService.listAppointmentsByTitle("%"+motCle+"%"));
	    }
	
	    
	    @GetMapping ("/pagination")
	    public ResponseEntity<List<Appointment>> getAllEmployees(
	                        @RequestParam(defaultValue = "0") Integer pageNo, 
	                        @RequestParam(defaultValue = "2") Integer pageSize,
	                        @RequestParam(defaultValue = "title") String sortBy) 
	    {
	        List<Appointment> list = appointmentService.getAllAppointment(pageNo, pageSize, sortBy);

	        return new ResponseEntity<List<Appointment>>(list, new HttpHeaders(), HttpStatus.OK); 
	    }

}
