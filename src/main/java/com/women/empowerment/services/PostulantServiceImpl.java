package com.women.empowerment.services;


import com.women.empowerment.entites.Cv;
import com.women.empowerment.entites.Offers;
import com.women.empowerment.entites.Postulant;
import com.women.empowerment.entites.User;
import com.women.empowerment.repositories.CvRepository;
import com.women.empowerment.repositories.OffersRepository;
import com.women.empowerment.repositories.PostulantRepository;
import com.women.empowerment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PostulantServiceImpl implements PostulantService{
    private static final Logger l = LogManager.getLogger(PostulantServiceImpl.class);

    @Autowired
    private PostulantRepository postulantRepository;

    @Autowired
    private CvRepository cvRepository;

    @Autowired
    private OffersRepository offersRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    CvService cvService;

    @Autowired
    private  EmailService emailService;
    @Override
    @Transactional
    public Postulant ajouterPostulant(Postulant postulant,int idCv,int idOffre,int idUser) {
        User us=userRepository.findById(idUser).get();
        Offers offers=offersRepository.findById(idOffre).get();
        Cv cv=cvRepository.findById(idCv).get();
        postulant.setCv(cv);
        postulant.setOffers(offers);
        postulant.setUser(us);

        return postulantRepository.save(postulant);
    }
    @Scheduled(cron = "*/30 * * * * *")
    public void test(){
       List<Postulant> postulants=postulantRepository.findPostulantByAnswer(true);
       for(Postulant p:postulants){
           emailService.send(p.getUser().getEmail(),"Reponse condidature","Bonjour, " +p.getUser().getPrenom()+"<br/>"+
                   "On vous informe que votre condidature est accepter veillez vennez chez nous pour passer votre entretient.<br/>Cordialement");
           p.setAnswer(false);
           postulantRepository.save(p);
       }

       l.info("sending");
    }
    @Override
    @Transactional
    public Postulant updatePostulant(Postulant postulant, int idPostulant) {
        Postulant p=postulantRepository.findById(idPostulant).orElse(null);
        if(postulant.getCv()!=null) p.setCv(postulant.getCv());
        if(postulant.getDate()!=null)p.setDate(postulant.getDate());
        if(postulant.getOffers()!=null) p.setOffers(postulant.getOffers());
        if(postulant.getName()!=null) p.setName(postulant.getName());
        return postulantRepository.save(p);
    }

    @Override
    @Transactional
    public List<Postulant> getAllPostulant() {
        return postulantRepository.findAll();
    }

    @Override
    @Transactional
    public Postulant getPostulantById(int idPostulant) {
        return postulantRepository.findById(idPostulant).orElse(null);
    }

    @Override
    @Transactional
    public Postulant getPostulantByOffer(int idOffer) {
        return postulantRepository.getPostulantByOffers(offersRepository.findById(idOffer).get());
    }

    @Override
    @Transactional
    public List<Postulant> deletePostulantById(int idPostulant) {
        postulantRepository.deleteById(idPostulant);
        return this.getAllPostulant();
    }

    @Override
    @Transactional
    public void deleteAllPostulant() {
        postulantRepository.deleteAll();
    }

    @Override
    @Transactional
    public List<Postulant> deletePostulantByoffer(Offers offers) {
        return postulantRepository.deletePostulantsByOffers(offers);
    }

    @Override
    @Transactional
    public Postulant affecterOffreToPostulant(int idOffre, int idPostulant) {
        Offers offers=offersRepository.findById(idOffre).get();
        Postulant part=postulantRepository.findById(idPostulant).get();
        part.setOffers(offers);
        return postulantRepository.save(part);
    }

    @Override
    @Transactional
    public Postulant affecterCvToPostulant(int postulantId, int cvId) {
        Postulant postulant=postulantRepository.findById(postulantId).get();
        Cv cv=cvService.getCvById(cvId);
        postulant.setCv(cv);
        return postulantRepository.save(postulant);
    }
}
