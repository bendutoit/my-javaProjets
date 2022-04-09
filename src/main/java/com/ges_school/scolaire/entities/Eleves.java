package com.ges_school.scolaire.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Eleves implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idEleves;
    private String matriculeEl;
    private String nomElv;
    private String photoEl;
    private String prenomEl;
    private String sexeEl;
    private String quartierEl;
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date dateNais;

    @OneToMany(mappedBy = "eleves", fetch = FetchType.LAZY)
    private Collection<Notes> notes;
    @ManyToOne
    private Classes classes;

    @ManyToMany
    @JoinTable( name = "Eleve_Convocation",
                joinColumns = @JoinColumn( name = "idEleves" ),
                inverseJoinColumns = @JoinColumn( name = "idConvocations" ) )
    private List<Convocations> convocationlList = new ArrayList<>();

    @ManyToMany
    @JoinTable( name = "Eleve_Evenement",
                joinColumns = @JoinColumn( name = "idEleves" ),
                inverseJoinColumns = @JoinColumn( name = "idEvenements " ) )
    private List<Evenements> evenementList = new ArrayList<>();

}

