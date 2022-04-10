package com.ges_school.scolaire.controlleurs;

import java.util.List;

import com.ges_school.scolaire.Iservices.IClassesService;
import com.ges_school.scolaire.entities.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller 
public class ClassesController {
@Autowired
    private IClassesService classeService;
    

    @GetMapping(path = "/classes")
    public String afficheClasse(Model model){
List<Classes> listClasse=classeService.getAllClasses();
model.addAttribute("listClasse", listClasse);
        return "classes/classes_list";
    }

    @GetMapping(path ="/classes/new")
    public String shownewEleveform(Model model){
        
        model.addAttribute("classes", new Classes());
    
    return "classes/classe_form";
    }

    @PostMapping(path ="/classes/save")
    public String saveClasse(Classes clas){  
     classeService.saveClasses(clas);
    return "redirect:/classes";
    }

    @RequestMapping("/deleteClasse")
    public String delete( Long id){
        classeService.deleteClasses(id);
        return "redirect:/classes";
    }

    

    @RequestMapping(value ="/classes/edit" ,method = RequestMethod.GET)
    public String showeditEleveform(Model model,Long id){
        
        model.addAttribute("classes", classeService.getClassesById(id));
    
    return "classes/classe_edit";
    }
   
}
