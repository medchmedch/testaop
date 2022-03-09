package com.women.empowerment.controller;
import com.women.empowerment.entites.Offers;
import com.women.empowerment.services.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/offre")
public class OffreController {
    @Autowired
    private OffreService offreService;

    @GetMapping("/all")
    public List<Offers> getAllOffers(){
        return offreService.getAllOffers();
    }

    @GetMapping("/{id}")
    public Offers getOfferById(@PathVariable int id){
        return offreService.getOfferById(id);
    }

    @PostMapping(value = "/add" )
    public Offers addoffre(@RequestBody Offers offers){

        return offreService.addOffer(offers) ;
    }

    @GetMapping("/AffectUser/{idOffre}/{iduser}")
    public Offers affectUserToOffre(@PathVariable int idOffre, @PathVariable int iduser){
        return offreService.affecterUserToOffer(idOffre,iduser);
    }

    @GetMapping("/offreByUser/{idUser}")
    public List<Offers> getOffreByUser(@PathVariable  int idUser){
        return offreService.getOfferByUser(idUser);
    }
    @DeleteMapping("/delete/{id}")
    public List<Offers> deleteOffreById(@PathVariable int id){
        return offreService.deleteOffreById(id);
    }

    @DeleteMapping("/delete")
    public String deleteAllOffres(){
        offreService.deleteAllOffres();
        return "All offers deleted ";
    }



}
