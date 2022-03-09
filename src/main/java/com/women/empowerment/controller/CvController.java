package com.women.empowerment.controller;
import com.women.empowerment.entites.Cv;
import com.women.empowerment.services.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Cv")
public class CvController {
    @Autowired
    private CvService cvService;

    @GetMapping("/{id}")
    public Cv getCvById(@PathVariable int id){
        return cvService.getCvById(id);
    }
    @GetMapping("/all")
    public List<Cv> getAllCv(){
        return cvService.getAllCv();
    }
    @GetMapping("getCvByPostulant/{idPostulant}")
    public Cv getCvByPostulant(@PathVariable int idPostulant){
        return cvService.getCvByPostulant(idPostulant);
    }
    @DeleteMapping("/{idCv}")
    public List<Cv> deleteCvById(@PathVariable int idCv){
        return cvService.deleteCvById(idCv);
    }

    @DeleteMapping("/all")
    public String deleteAllCvs(){
        cvService.deleteAllCvs();
        return "All cv deleted";
    }

    @PutMapping("/update/{id}")
    public Cv updateCv(@PathVariable int id,@RequestBody Cv cv){
        return cvService.updateCv(cv,id);
    }

    @PostMapping ("/add")
    public Cv ajouterCv(@RequestBody Cv cv){
        return cvService.ajouterCv(cv);
    }
}
