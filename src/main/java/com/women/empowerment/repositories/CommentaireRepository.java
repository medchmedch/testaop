package com.women.empowerment.repositories;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.women.empowerment.entites.Commentaire;




@Repository
public interface CommentaireRepository extends CrudRepository<Commentaire, Integer>  {

	Set<Commentaire> findTop3ByOrderByLikesNbrLikeDesc();
	Set<Commentaire> findByOrderByPublicationDesc();
	//@Query("select c from commentaire c where c.publication.publication_id=:idPub ")
	//List<Commentaire> findByPubOrderByDateCreation(@Param("idPub") int idPub);
}
