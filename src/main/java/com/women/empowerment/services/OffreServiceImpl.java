package com.women.empowerment.services;

import com.women.empowerment.entites.Offers;
import com.women.empowerment.entites.User;
import com.women.empowerment.repositories.OffersRepository;
import com.women.empowerment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OffreServiceImpl implements OffreService{
    @Autowired
    private OffersRepository offersRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional
    public List<Offers> getAllOffers() {
        return offersRepository.findAll();
    }

    @Override
    @Transactional
    public Offers getOfferById(int idOffre) {
        return offersRepository.findById(idOffre).get();
    }

    @Override
    @Transactional
    public List<Offers> getOfferByUser(int iduser) {
        return offersRepository.getOffersByUser(userRepository.findById(iduser).get());
    }

    @Override
    @Transactional
    public Offers addOffer(Offers offers) {
        return offersRepository.save(offers);
    }

    @Override
    @Transactional
    public Offers updateOffer(int idOffre, Offers offers) {
        Offers of=offersRepository.findById(idOffre).orElse(null);
        if(offers.getOfferType()!=null) of.setOfferType(offers.getOfferType());
        if(offers.getPostulants()!=null) of.setPostulants(offers.getPostulants());
        if(offers.getUser()!=null)of.setUser(offers.getUser());
        return offersRepository.save(of);
    }

    @Override
    @Transactional
    public List<Offers> deleteOffreById(int idoffre) {
        offersRepository.deleteById(idoffre);
        return this.getAllOffers();
    }

    @Override
    @Transactional
    public void deleteAllOffres() {
        offersRepository.deleteAll();
    }

    @Override
    @Transactional
    public Offers affecterUserToOffer(int idOffre, int idUser) {
        Offers of=offersRepository.findById(idOffre).get();
        User us=userRepository.findById(idUser).get();
        of.setUser(us);
        return offersRepository.save(of);
    }
}
