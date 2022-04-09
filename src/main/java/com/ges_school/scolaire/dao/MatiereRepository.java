package com.ges_school.scolaire.dao;

import com.ges_school.scolaire.entities.Matieres;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MatiereRepository extends JpaRepository<Matieres,Long> {
    
}