package com.ges_school.scolaire.serviceImpl;

import java.util.List;

import com.ges_school.scolaire.Iservices.IClasseService;
import com.ges_school.scolaire.dao.ClasseRepository;
import com.ges_school.scolaire.entities.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service 
public class ClasseServiceImpl implements IClasseService {
    @Autowired
private ClasseRepository classeRepository;
    @Override
    public List<Classes> getAllClasses() {
        
        return classeRepository.findAll();
    }

    @Override
    public Classes saveClasses(Classes cl) {
        
        return classeRepository.save(cl);
    }

   

    @Override
    public Classes updateClasses(Classes cl) {
        
        return classeRepository.save(cl);
    }

    @Override
    public void deleteClasses(Long idClasses) {
       
        classeRepository.deleteById(idClasses);
    }

     @Override
   public Classes getClassesById(Long idClasses) {
        
        return classeRepository.findClassesById(idClasses);
    }
    
}

