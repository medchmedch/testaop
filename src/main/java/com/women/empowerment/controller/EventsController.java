package com.women.empowerment.controller;
import com.women.empowerment.entites.Events;
import com.women.empowerment.services.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/Event")
public class EventsController {
    @Autowired
    private EventsService eventsService;


    @GetMapping("/all")
    public List<Events> getAllEvents(){
        return eventsService.afficherTousLesEvenements();
    }

    @GetMapping("/{id}")
    public Events getEventById(@PathVariable int id){
        return eventsService.afficherEventById(id);
    }
    @GetMapping("affectUser/{idEvent}/{idUser}")
    public Events affecterUserAEvent(@PathVariable int idEvent,@PathVariable int idUser){
        return eventsService.affecterUserAEvent(idEvent,idUser);
    }

    @GetMapping("affectParticipant/{idEvent}/{idPart}")
    public List<Events> affecterParticipantAEvent(@PathVariable List<Integer> idEvent, @PathVariable List<Integer> idPart){
        return eventsService.affecterParticipantAEvent(idPart,idEvent);
    }

    @GetMapping("/byDate")
    public Events getEventByDate(@PathParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return eventsService.afficherEventByDate(date);
    }



    @DeleteMapping("/{id}")
    public List<Events> deleteEventById(@PathVariable int id){
        return eventsService.supprimerEvent(id);
    }

    @DeleteMapping("/byDate")
    public List<Events> deleteEventById(@PathParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return eventsService.supprimerAllEventsByDate(date);
    }

    @DeleteMapping("/all")
    public String deleteAllEvents(){
        eventsService.supprimerTousLesEvenements();
        return "Tous les évenement a été supprimer !!";
    }

    @PostMapping("/add")
    public Events ajouterEvent(@RequestBody Events events){
        return eventsService.ajouterEvent(events);
    }

    @PutMapping("/{id}")
    public Events updateEventById(@PathVariable int id,@RequestBody Events events){
        return eventsService.modifierEvent(id,events);
    }

    @GetMapping("/Donations")
    public Double sommeDonation(){
        return eventsService.sommeDonation();
    }

    @GetMapping("/NbrDonations")
    public int NbrDonation(){
        return eventsService.nbrDonation();
    }

    @GetMapping("NbrParticipant/{idEvent}")
   public int getNbrParticipantByIdEvent(@PathVariable int idEvent){
        return eventsService.getNbrParticipantByIdEvent(idEvent);
   }


}
