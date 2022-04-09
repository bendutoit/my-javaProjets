package com.ges_school.scolaire.serviceImpl;

import com.ges_school.scolaire.Iservices.IEleveService;
import com.ges_school.scolaire.dao.EleveRepository;
import com.ges_school.scolaire.entities.Eleves;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor
public class EleveServiceImpl implements IEleveService {
private EleveRepository eleveRepository;

    @Override
    public Page<Eleves> getAllEleves(String mc,Pageable pageable) {

        return eleveRepository.findByNomElvContains(mc, pageable);
    }

    @Override
    public Eleves saveEleve(Eleves eleve) {
    
        return eleveRepository.save(eleve);
    }

    @Override
    public Eleves getEleveById(Long idEleves) {
    
        return eleveRepository.findElevesById(idEleves);
    }

    @Override
    public Eleves updatEleve(Eleves eleve) {
        return eleveRepository.save(eleve);
    }

    @Override
    public void deleteEleve(Long idEleves) {
    
        eleveRepository.deleteById(idEleves);
    }

   

   

   
   
    
}

