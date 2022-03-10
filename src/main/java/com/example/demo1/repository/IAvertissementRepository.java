package com.example.demo1.repository;

import com.example.demo1.entity.Avertissement;
import com.example.demo1.entity.Cours;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAvertissementRepository extends CrudRepository<Avertissement, Long> {
}
