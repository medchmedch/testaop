package com.women.empowerment.controller;
import com.women.empowerment.entites.Participant;
import com.women.empowerment.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/participant")

public class ParticipantController {
    @Autowired
    private ParticipantService participantService;


    @GetMapping("/all")
    public List<Participant> getAllParticipants(){
        return participantService.afficherTousLesParticipants();
    }

    @PostMapping("/add/{idUser}")
    public List<Participant> ajouterParticipant(@RequestBody Participant participant,@PathVariable int idUser){
        participantService.ajouterParticipant(participant,idUser);
        return this.getAllParticipants();
    }


}
