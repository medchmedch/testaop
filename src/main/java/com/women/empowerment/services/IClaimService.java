package com.women.empowerment.services;

import java.util.List;

import com.women.empowerment.entites.Claim;

public interface IClaimService {
    void ajouterClaim (Claim claim);
    List<Claim> getClaim();
    Claim getClaimById(int id );
    void deleteClaim(int id);
	void affecterClaimToUser( int idUser,int idClaim);


}
