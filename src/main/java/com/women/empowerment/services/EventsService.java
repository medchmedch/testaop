package com.women.empowerment.services;


import com.women.empowerment.entites.Events;

import java.util.Date;
import java.util.List;

public interface EventsService {

    List<Events> afficherTousLesEvenements();

    Events afficherEventById(int idEvent);

    Events afficherEventByDate(Date date);


    Events ajouterEvent(Events events);

    Events modifierEvent(int idEvent,Events events);

    List<Events> supprimerEvent(int idEvent);

    void supprimerTousLesEvenements();

    List<Events> supprimerAllEventsByDate(Date date);

    Events affecterUserAEvent(int idEvent,int idUser);

    List<Events> affecterParticipantAEvent(List<Integer> idParticipant, List<Integer> idEvent);

    Double sommeDonation();

    int nbrDonation();

    int getNbrParticipantByIdEvent(int idEvent);

}
