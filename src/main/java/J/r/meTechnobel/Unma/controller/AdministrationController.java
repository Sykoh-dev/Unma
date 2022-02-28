package J.r.meTechnobel.Unma.controller;

import J.r.meTechnobel.Unma.models.dto.AdministrationDTO;
import J.r.meTechnobel.Unma.models.form.AdministrationForm;
import J.r.meTechnobel.Unma.service.AdministrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/administration")
public class AdministrationController {

    private final AdministrationService service;

    public AdministrationController(AdministrationService service) {
        this.service = service;
    }

    @GetMapping(path = {"","/","/all"})
    public ResponseEntity<List<AdministrationDTO>> getAll(){
        return ResponseEntity
                .ok(service.getAll());
    }

    @GetMapping(path = {"/{numMatricule}"})
    public ResponseEntity<AdministrationDTO> getOne(@PathVariable String numMatricule){
        return ResponseEntity
                .ok( service.getOne(numMatricule));

    }

    @PostMapping(path = {"", "/", "/add"})
    public AdministrationDTO insert(@Valid @RequestBody AdministrationForm form){
        System.out.println(form);
        return service.insert(form);
    }

    @DeleteMapping("/{numMatricule}")
    public AdministrationDTO delete(@PathVariable(name = "numMatricule") String numMatricule){
        return service.delete(numMatricule);
    }
}

