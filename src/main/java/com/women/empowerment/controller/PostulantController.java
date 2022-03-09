package com.women.empowerment.controller;

import com.women.empowerment.entites.Postulant;
import com.women.empowerment.services.OffreService;
import com.women.empowerment.services.PostulantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/postulant")
public class PostulantController {
    @Autowired
    private PostulantService postulantService;

    @Autowired
    private OffreService offreService;
    @GetMapping("/all")
    public List<Postulant> getAllPostulant(){
        return postulantService.getAllPostulant();
    }

    @GetMapping("/{id}")
    public Postulant getPostulantById(@PathVariable int id){
        return postulantService.getPostulantById(id);
    }

    @GetMapping("offre/{idoffre}")
    public Postulant getPostulantByOffre(@PathVariable int idoffre){
        return postulantService.getPostulantByOffer(idoffre);
    }

    @PostMapping("/add/{idCv}/{idOffre}/{idUser}")
    public Postulant addPostulant(@RequestBody Postulant postulant,@PathVariable int idCv,@PathVariable int idOffre,@PathVariable int idUser){
        return postulantService.ajouterPostulant(postulant,idCv,idOffre,idUser);
    }


    @PutMapping("/update/{id}")
    public Postulant updatePostulant(@PathVariable int id,@RequestBody Postulant postulant){
        return postulantService.updatePostulant(postulant,id);
    }

    @DeleteMapping("/{id}")
    public List<Postulant> deletePostulant(@PathVariable int id){
        postulantService.deletePostulantById(id);
        return this.getAllPostulant();
    }

    @DeleteMapping("offre/{idoffre}")
    public List<Postulant> deletePostulantByoffre(@PathVariable int idoffre){
        postulantService.deletePostulantByoffer(offreService.getOfferById(idoffre));
        return this.getAllPostulant();
    }

    @DeleteMapping("/all")
    public String deleteAllPostulant(){
        postulantService.deleteAllPostulant();
        return "All postulant deleted";
    }


}
