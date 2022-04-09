package com.ges_school.scolaire.dao;

import com.ges_school.scolaire.entities.Notes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Notes,Long> {
    
}
