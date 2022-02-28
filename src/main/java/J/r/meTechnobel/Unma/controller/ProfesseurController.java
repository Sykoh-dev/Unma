package J.r.meTechnobel.Unma.controller;

import J.r.meTechnobel.Unma.models.dto.HoraireDTO;
import J.r.meTechnobel.Unma.models.dto.ProfesseurDTO;
import J.r.meTechnobel.Unma.models.form.HoraireForm;
import J.r.meTechnobel.Unma.models.form.ProfesseurForm;
import J.r.meTechnobel.Unma.service.ProfesseurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/professeur")
public class ProfesseurController {

    private final ProfesseurService service;

    public ProfesseurController(ProfesseurService service) {
        this.service = service;
    }

    @GetMapping(path = {"","/","/all"})
    public ResponseEntity<List<ProfesseurDTO>> getAll(){
        return ResponseEntity
                .ok(service.getAll());
    }

    @GetMapping(path = {"/{numMatricule}"})
    public ResponseEntity<ProfesseurDTO> getOne(@PathVariable String numMatricule){
        return ResponseEntity
                .ok( service.getOne(numMatricule));

    }

    @PostMapping(path = {"", "/", "/add"})
    public ProfesseurDTO insert(@Valid @RequestBody ProfesseurForm form){
        System.out.println(form);
        return service.insert(form);
    }

    @DeleteMapping("/{numMatricule}")
    public ProfesseurDTO delete(@PathVariable(name = "numMatricule") String numMatricule){

        return service.delete(numMatricule);
    }
}
