package com.ges_school.scolaire.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Evenements implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvenements;
    private String titre;
    private String objets;
    private String heureDebut;
    private String heureFin;
    private Date dateDebut;
    private Date dateFin;

    @ManyToMany
    @JoinTable( name = "Eleve_Evenement",
                joinColumns = @JoinColumn( name = "idEvenements" ),
                inverseJoinColumns = @JoinColumn( name = "idEleves " ) )
    private List<Eleves> roles = new ArrayList<>();

}