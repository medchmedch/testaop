package com.women.empowerment.controller;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.women.empowerment.entites.Commentaire;
import com.women.empowerment.services.CommentaireServiceImpl;

import utils.BadWordFilter;


@RestController
@RequestMapping(value = "/commentaire")
public class CommentaireRestController {

	private final CommentaireServiceImpl cs;
	
	@Autowired
	public CommentaireRestController(CommentaireServiceImpl cs) {
		this.cs = cs;
		
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Commentaire>> getCommentaire() {
		List<Commentaire> commentaireList = (List<Commentaire>) cs.afficherCommentaire();
		
		if(commentaireList == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
        		commentaireList
        );
		
	}
	@GetMapping(value = "/toplike")
	public ResponseEntity<Set<Commentaire>> getTopLikeCommentaire() {
		Set<Commentaire> commentaireList =  cs.findRecent();
		
		if(commentaireList == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
        		commentaireList
        );
		
	}
	
	@PostMapping(value = "/add")
	public Commentaire addComment(@RequestBody Commentaire c) {
		String input=c.getContenu();
		String output = BadWordFilter.getCensoredText(input);
		System.out.println(output);
		c.setContenu(output);
		return cs.ajouterCommentaire(c);
	}
	
	@PutMapping(value = "/edit")
	public Commentaire editComment(@RequestParam("idc") int id,@RequestParam("contenu") String contenu) {
		
		return cs.modifierCommentaire(id, contenu);
	}
	
	@DeleteMapping(value = "/delete")
	public void deleteComment (@RequestParam("idc") int idc) {
		cs.supprimerCommentaire(idc);
	}
	@GetMapping("/pub/{idPub}")
	public ResponseEntity<List<Commentaire>> getCommentByIdPublication(@PathVariable int idPub) {
		List<Commentaire> commentaireList = (List<Commentaire>) cs.getCommentByIdPublication(idPub);
		
		if(commentaireList == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
        		commentaireList
        );	
	}
	
	
	
	
	
	
	
}
