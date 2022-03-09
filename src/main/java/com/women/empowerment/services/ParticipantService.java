package com.women.empowerment.services;

import com.women.empowerment.entites.Participant;

import java.util.List;

public interface ParticipantService {
    Participant ajouterParticipant(Participant participant, int idUser);
    List<Participant> afficherTousLesParticipants();

}
