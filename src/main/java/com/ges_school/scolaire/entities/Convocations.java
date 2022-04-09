package com.ges_school.scolaire.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;


@Data

@Entity
public class Convocations implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConvocations;
    private String objets;
    private String libelles;
    private String heures;
    private Date dates;

    @ManyToMany
    @JoinTable( name = "Eleve_Convocation",
                joinColumns = @JoinColumn( name = "idConvocations" ),
                inverseJoinColumns = @JoinColumn( name = "idEleves " ) )
    private List<Convocations> roles = new ArrayList<>();

   

}
