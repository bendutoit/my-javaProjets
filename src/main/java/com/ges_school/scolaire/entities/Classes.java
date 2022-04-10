package com.ges_school.scolaire.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import jakarta.persistence.OneToMany;
import lombok.Data;
@Data
@Entity
public class Classes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClasses;
    @Column(unique = true)
    private String codeclasses;
    @OneToMany(mappedBy = "classes")
    private Collection<Eleves> eleves;
}
