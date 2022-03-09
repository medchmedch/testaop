package com.women.empowerment.services;

import com.women.empowerment.entites.Cv;
import com.women.empowerment.repositories.CvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class cvSericeImpl implements CvService {

    @Autowired
    private CvRepository cvRepository;

    @Autowired
    PostulantService postulantService;
    @Override
    @Transactional
    public Cv ajouterCv(Cv cv) {
        return cvRepository.save(cv);
    }

    @Override
    @Transactional
    public Cv getCvById(int cv) {
        return cvRepository.findById(cv).get();
    }

    @Override
    @Transactional
    public List<Cv> getAllCv() {
        return cvRepository.findAll();
    }

    @Override
    @Transactional
    public Cv getCvByPostulant(int idPostulant) {
        return cvRepository.getCvByPostulants(idPostulant);
    }

    @Override
    @Transactional
    public List<Cv> deleteCvById(int idCv) {
        cvRepository.deleteById(idCv);
        return this.getAllCv();
    }

    @Override
    @Transactional
    public void deleteAllCvs() {
        cvRepository.deleteAll();
    }

    @Override
    @Transactional
    public Cv updateCv(Cv cv, int idCv) {
        Cv cv1=cvRepository.findById(idCv).get();
        if(cv.getFirstName()!=null)cv1.setFirstName(cv.getFirstName());
        if(cv.getLastName()!=null)cv1.setLastName(cv.getLastName());
        if(cv.getBirthdate()!=null)cv1.setBirthdate(cv.getBirthdate());
        if(cv.getHobies()!=null)cv1.setHobies(cv.getHobies());
        if(cv.getPostulants()!=null)cv1.setPostulants(cv.getPostulants());
        if(cv.getProffession()!=null)cv1.setProffession(cv.getProffession());
        if(cv.getEducation()!=null)cv1.setEducation(cv.getEducation());
        if(cv.getSkils()!=null)cv1.setSkils(cv.getSkils());
        return cvRepository.save(cv1);
    }
}
