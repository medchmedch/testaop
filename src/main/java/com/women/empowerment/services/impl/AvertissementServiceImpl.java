package com.example.demo1.service.impl;

import com.example.demo1.entity.Avertissement;
import com.example.demo1.entity.Reponse;
import com.example.demo1.repository.IAvertissementRepository;
import com.example.demo1.repository.IReponseRepository;
import com.example.demo1.service.IAvertissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvertissementServiceImpl implements IAvertissementService {
    @Autowired
    IAvertissementRepository rr;



    public Avertissement ajouterAvertissement(Avertissement r) {

        return rr.save(r);
    }

    public Iterable<Avertissement> afficherAvertissement() {
        return rr.findAll();
    }


    public void supprimerAvertissement(long r_id) {
        rr.deleteById(r_id);

    }
}
