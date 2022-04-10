package com.ges_school.scolaire.controlleurs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import com.ges_school.scolaire.Iservices.IClassesService;
import com.ges_school.scolaire.Iservices.IEleveService;
import com.ges_school.scolaire.entities.Classes;
import com.ges_school.scolaire.entities.Eleves;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class EleveController {

    @Autowired
    private IClassesService classeService;
   
    @Autowired
    
    private IEleveService eleveservice;
    @Value("${dir.images}")
    private String imageDir;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping(path = "/eleves")
    public String eleve(Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            @RequestParam(name = "motcle", defaultValue = "") String motcle) {
        Page<Eleves> pageelvs = eleveservice.getAllEleves(motcle, PageRequest.of(page, size));
        model.addAttribute("pageEleves", pageelvs);
        model.addAttribute("currentpage", page);
        model.addAttribute("size", size);
        model.addAttribute("pages", new int[pageelvs.getTotalPages()]);
        model.addAttribute("motcle", motcle);
        return "eleves/eleves";
    }
    
      @RequestMapping(value="/deleteEleve")
      public String delete(Long id,String motcle,String page,String size){
      eleveservice.deleteEleve(id);
      return "redirect:/eleves?page="+page+"&motcle="+motcle+"&size="+size;
     }
     

    @RequestMapping(value = "/eleves/new", method = RequestMethod.GET)
    public String shownewEleveform(Model model) {
        List<Classes> listclasses = classeService.getAllClasses();
        model.addAttribute("listclasses", listclasses);
        model.addAttribute("eleves", new Eleves());

        return "eleves/eleve_form";
    }

    @PostMapping(value = "/eleves/save")
    public String saveEleve(@ModelAttribute("eleves") Eleves eleves, @RequestParam(name = "picture") MultipartFile file,
            BindingResult bindingResult) throws IllegalStateException, IOException {
        if (bindingResult.hasErrors()) {
            return "eleves/eleve_form";
        }
        if (!(file.isEmpty())) {
            eleves.setPhotoEl(file.getOriginalFilename());
        }
        eleveservice.saveEleve(eleves);
        if (!(file.isEmpty())) {
            eleves.setPhotoEl(file.getOriginalFilename());
            file.transferTo(new File(imageDir + eleves.getIdEleves()));
        }

        return "redirect:/eleves";
    }

    @RequestMapping(value = "/getphoto", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getphoto(Long idEleves) throws Exception {
        File f = new File(imageDir + idEleves);
        return IOUtils.toByteArray(new FileInputStream(f));
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editEleveForm(Long idEleves, Model model) {
        model.addAttribute("eleves", eleveservice.getEleveById(idEleves));
        List<Classes> listclasses = classeService.getAllClasses();
        model.addAttribute("listClasse", listclasses);
       
        return "eleves/eleve_form";
    }

   
}