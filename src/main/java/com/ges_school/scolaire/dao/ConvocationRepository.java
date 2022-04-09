package com.ges_school.scolaire.dao;

import com.ges_school.scolaire.entities.Convocations;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvocationRepository extends JpaRepository<Convocations,Long> {
    
}
