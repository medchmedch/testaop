package com.women.empowerment.services;

import com.women.empowerment.entites.Participant;
import com.women.empowerment.entites.User;
import com.women.empowerment.repositories.ParticipantRepository;
import com.women.empowerment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService{
    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public Participant ajouterParticipant(Participant participant, int idUser) {
        User us=userRepository.findById(idUser).get();
        participant.setUser(us);
        return participantRepository.save(participant);
    }

    @Override
    @Transactional
    public List<Participant> afficherTousLesParticipants() {
        return participantRepository.findAll();
    }
}
