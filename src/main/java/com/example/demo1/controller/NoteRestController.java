package com.example.demo1.controller;

import java.util.List;

import com.example.demo1.entity.Cours;
import com.example.demo1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.entity.Note;
import com.example.demo1.service.impl.NoteServiceImpl;

@RestController
@RequestMapping(value="/note")
public class NoteRestController {
	
	private final NoteServiceImpl ns;
	
	@Autowired
	public NoteRestController(NoteServiceImpl ns) {
		this.ns=ns;
		
	}
	
	@GetMapping(value = "/all")
	public MappingJacksonValue getNote() {
		List<Note> notesList=(List<Note>) ns.afficherNote();
		MappingJacksonValue noteMapping = new MappingJacksonValue(notesList);
		
		return noteMapping;
	}
	
	@PostMapping(value = "/add")
	public Note addNote(@RequestBody Note n) {
		return ns.ajouterNote(n);
	}
	
	@PutMapping(value = "/edit")
	public Note editNote(@RequestParam("note_id") long note_id,@RequestParam Note note) {
		
		return ns.modifierNote(note_id, note);
	}
	@PostMapping(value = "/calcul")
	public Note addNote_final(@RequestParam("user_id") long user_id,@RequestParam("cours_id") long cours_id) {

		Note s = new Note();
		User u = new User();
		Cours c = new Cours();
		u.setUser_id(user_id);
		c.setCours_id(cours_id);
		s.setNote_val(ns.calculerNote(user_id,cours_id));
		s.setUser(u);
		s.setCoursn(c);


		if(s.getNote_val()>=0){
		//ns.supprimerNotebyuser(user_id,cours_id);
		return ns.ajouterNote(s);}else{ return s;}
	}
	
	@DeleteMapping(value = "/delete")
	public void deleteNote (@RequestParam("note_id") long note_id) {
		ns.supprimerNote(note_id);
	}


}