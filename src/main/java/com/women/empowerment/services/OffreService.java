package com.women.empowerment.services;

import com.women.empowerment.entites.Offers;

import java.util.List;

public interface OffreService {

    List<Offers> getAllOffers();
    Offers getOfferById(int idOffre);
    List<Offers> getOfferByUser(int iduser);

    Offers addOffer(Offers offers);
    Offers updateOffer(int idOffre,Offers offers);

    List<Offers> deleteOffreById(int idoffre);
    void deleteAllOffres();

    Offers affecterUserToOffer(int idOffre,int idUser);
}
