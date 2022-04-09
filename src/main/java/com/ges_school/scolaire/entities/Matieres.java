package com.ges_school.scolaire.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Data
@Entity
public class Matieres implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatiere;
    private String codeMat;
    private Double coef;
    private String appreciation;
    private String libelleMat;

    @OneToMany(mappedBy = "matieres", fetch = FetchType.LAZY)
    private Collection<Notes> notes;

    @ManyToOne
    private Enseignants enseignants;
}

