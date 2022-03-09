package com.women.empowerment.services;

import com.women.empowerment.entites.Events;
import com.women.empowerment.entites.Participant;
import com.women.empowerment.entites.User;
import com.women.empowerment.repositories.EventsRepository;
import com.women.empowerment.repositories.ParticipantRepository;
import com.women.empowerment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventsService{
    @Autowired
    private EventsRepository eventsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Override
    @Transactional
    public List<Events> afficherTousLesEvenements() {
        return eventsRepository.findAll();
    }

    @Override
    @Transactional
    public Events afficherEventById(int idEvent) {
        return eventsRepository.findById(idEvent).orElse(null);
    }

    @Override
    @Transactional
    public Events afficherEventByDate(Date date) {
        return eventsRepository.getEventsByDate(date);
    }

    @Override
    @Transactional
    public Events ajouterEvent(Events events) {
        return eventsRepository.save(events);
    }

    @Override
    @Transactional
    public Events modifierEvent(int idEvent,Events events) {
        Events event=eventsRepository.findById(idEvent).orElse(null);

        if(events.getDate()!=null) event.setDate(events.getDate());
        if(events.getEventTopic()!=null) event.setEventTopic(events.getEventTopic());
        if(events.getDescription()!=null) event.setDescription(events.getDescription());
        if(events.getImagePub()!=null)event.setImagePub(events.getImagePub());
        if(events.getVideoPub()!=null)event.setVideoPub(events.getVideoPub());
        if(events.getUser()!=null)event.setUser(events.getUser());

        return eventsRepository.save(event);
    }

    @Override
    @Transactional
    public List<Events> supprimerEvent(int idEvent) {
        eventsRepository.deleteById(idEvent);
        return this.afficherTousLesEvenements();
    }

    @Override
    @Transactional
    public void supprimerTousLesEvenements() {
        eventsRepository.deleteAll();
    }

    @Override
    @Transactional
    public List<Events> supprimerAllEventsByDate(Date date) {
        return eventsRepository.deleteAllByDate(date);
    }

    @Override
    @Transactional
    public Events affecterUserAEvent(int idEvent, int idUser) {
        Events ev=eventsRepository.findById(idEvent).get();
        User us=userRepository.findById(idUser).get();
        ev.setUser(us);

        return eventsRepository.save(ev);
    }

    @Override
    @Transactional
    public List<Events> affecterParticipantAEvent(List<Integer> idParticipant, List<Integer> idEvent) {

        List<Events> evv=eventsRepository.findAllById(idEvent);
        List<Participant> part=participantRepository.findAllById(idParticipant);

        for (Participant p:part){
            p.setEvents(evv);
            participantRepository.save(p);
        }


        return evv;
    }

    @Override
    @Transactional
    public Double sommeDonation() {
        return eventsRepository.sommeDonation();
    }

    @Override
    @Transactional
    public int nbrDonation() {
        return eventsRepository.nbrDonation();
    }

    @Override
    @Transactional
    public int getNbrParticipantByIdEvent(int idEvent) {
        Events ev=eventsRepository.findById(idEvent).get();
        int nbr=0;
        for (Participant p:ev.getParticipant()){
            nbr+=1;
        }
        return nbr;
    }
}
