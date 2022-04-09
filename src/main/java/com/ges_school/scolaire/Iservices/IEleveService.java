package com.ges_school.scolaire.Iservices;

import com.ges_school.scolaire.entities.Eleves;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEleveService {

    Page<Eleves> getAllEleves(String mc,Pageable pageable);

    Eleves saveEleve(Eleves eleve);

    Eleves getEleveById(Long idEleves);
    Eleves updatEleve(Eleves eleve);
    public void deleteEleve(Long idEleves);
    
}
