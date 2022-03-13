package com.women.empowerment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.women.empowerment.entites.Claim;
import com.women.empowerment.services.ClaimService;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@Controller
@RequestMapping("/claim")
public class ClaimController {
	  @Autowired
	    private  ClaimService claimService ;
	  
	  
	  @GetMapping("/affectToUser/{idUser}/{idClaim}")
			@ResponseBody
			public void affectToUser(@PathVariable("idUser") int idUser, @PathVariable("idClaim") int IdClaim) {
				claimService.affecterClaimToUser(idUser, IdClaim);
				}
		  

	    @PostMapping("/addClaim")
	    public ResponseEntity<Claim> ajouterClaim (@RequestBody Claim claim) {

	            claimService.ajouterClaim(claim);
	            return ResponseEntity.ok().body(claim);
	    }
	    
	    @GetMapping("/getAllClaim")
	    public ResponseEntity<List<Claim>> getAllClaim() {
	        return ResponseEntity.ok().body(claimService.getClaim());
	    }
	  

	    @GetMapping("/getClaimById/{id}")
	    public ResponseEntity<Claim> getUserById(@PathVariable("id") int id) {
	        return ResponseEntity.ok().body(claimService.getClaimById(id));
	    }

	    @DeleteMapping("/deleteClaim/{id}")
	    public void deleteClaim(@PathVariable("id") int id) {
	        claimService.deleteClaim(id);
	    }
	    
	
	

}
