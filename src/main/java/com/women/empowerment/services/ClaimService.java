package com.women.empowerment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.women.empowerment.entites.Claim;
import com.women.empowerment.entites.User;
import com.women.empowerment.repositories.ClaimRepository;
import com.women.empowerment.repositories.UserRepository;
import com.women.empowerment.services.IClaimService;

@Service
public class ClaimService implements IClaimService {

    @Autowired
    private ClaimRepository claimRepository ;
    
    private UserRepository userRepository;
    
    @Override
    public void ajouterClaim(Claim claim) {
    	
        this.claimRepository.save(claim);
    }

    @Override
    public List<Claim> getClaim() {
        return claimRepository.findAll();
    }

    @Override
    public Claim getClaimById(int id) {
        return claimRepository.findById(id).get();
    }
    
    
    @Override
    public void deleteClaim(int id) {
        claimRepository.deleteById(id);
    }

    
    @Override
    public void affecterClaimToUser(int idUser,int idClaim){
		Claim claim = claimRepository.findById(idClaim).get();
		User u=new User();
		u.setIdUser(idUser);
		claim.setUser(u);
		claimRepository.save(claim);
    
    }
}
