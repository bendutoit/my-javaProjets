package com.ges_school.scolaire.dao;

import com.ges_school.scolaire.entities.Evenements;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementsRepository extends JpaRepository<Evenements,Long> {
    
}
