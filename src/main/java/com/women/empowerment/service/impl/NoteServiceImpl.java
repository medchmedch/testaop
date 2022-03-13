package com.example.demo1.service.impl;

import com.example.demo1.entity.Cours;
import com.example.demo1.entity.Question;
import com.example.demo1.entity.Quiz;
import com.example.demo1.repository.ICoursRepository;
import com.example.demo1.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.entity.Note;
import com.example.demo1.repository.INoteRepository;

import java.util.List;

@Service
public class NoteServiceImpl implements INoteService {
	
	@Autowired
	private INoteRepository nr;
	@Autowired
	private ICoursRepository cr;
	

	
	public Note ajouterNote(Note n) {
		
		return nr.save(n);
	}

	public Iterable<Note> afficherNote() {
		return nr.findAll();
	}
	
	public Note modifierNote(long note_id, Note note) {
		Note n = new Note();
		n = nr.findById(note_id).get();
		n.setNote_val(note.getNote_val());		
		return nr.save(n);
	}

	public double calculerNote(long user_id,long cours_id) {


		List<Note> n = nr.findAllByUser_id(user_id, cours_id);
		Cours c = cr.findById(cours_id).get();
		//System.out.println("xxxxxxxxxxxxxxxxxxxxxx"+n.size()+"qqqqqqqqqqqqqqq"+c.getQuizes().size());
		if(n.size()== c.getQuizes().size()){
		double note_fin=0;
		double coef_tot=0;

		for (Note element : n) {
			note_fin=note_fin+(element.getNote_val()* element.getQuiz().getQuiz_coef());
			coef_tot=coef_tot+element.getQuiz().getQuiz_coef();
		}
		return (note_fin/coef_tot);}else{return -1;}

	}
	public void supprimerNotebyuser(long user_id, long cours_id) {

		List<Note> n = nr.findAllByUser_id(user_id, cours_id);

		for (Note element : n) {nr.deleteById(element.getNote_id());}

	}
	public void supprimerNote(long note_id) {
		nr.deleteById(note_id);
		
	}
}
