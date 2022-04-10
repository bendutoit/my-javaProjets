package com.ges_school.scolaire.Iservices;

import java.util.List;

import com.ges_school.scolaire.entities.Classes;

public interface IClassesService {

    List<Classes> getAllClasses();
    Classes saveClasses(Classes cl);
    public void deleteClasses(Long idClasses);
   Classes getClassesById(Long idClasses);
    Classes updateClasses(Classes cl);
    

    
}
