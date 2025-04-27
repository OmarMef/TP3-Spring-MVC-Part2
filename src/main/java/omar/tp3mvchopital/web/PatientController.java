package omar.tp3mvchopital.web;


import lombok.AllArgsConstructor;
import omar.tp3mvchopital.entities.Patient;
import omar.tp3mvchopital.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;

    @GetMapping ("/index")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "5") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String kw
                        ) {

        Page<Patient> pagePatients = patientRepository.findByNameContains(kw, PageRequest.of(page, size));
        model.addAttribute("ListPatients", pagePatients);
        model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword", kw);
        return "patient";
    }

    @GetMapping("/delete")
    public String delete(Long id, String keyword, int page){

        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }


}
