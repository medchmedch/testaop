package com.example.demo1.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1.entity.Note;

import java.util.List;

@Repository
public interface INoteRepository extends CrudRepository<Note, Long>  {
    @Query(value="SELECT * FROM note n WHERE n.user_user_id = ?1 AND n.coursn_cours_id = ?2 AND n.quiz_quiz_id IS NOT NULL", nativeQuery = true)
    List<Note> findAllByUser_id(long user_id, long cours_id);
    @Query(value="SELECT * FROM note n WHERE n.user_user_id = ?1 AND n.coursn_cours_id = ?2 AND n.quiz_quiz_id IS NULL", nativeQuery = true)
    Note findPdf(long user_id, long cours_id);


}