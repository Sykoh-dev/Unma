package J.r.meTechnobel.Unma.controller;

import J.r.meTechnobel.Unma.models.dto.EtudiantDTO;
import J.r.meTechnobel.Unma.models.form.EtudiantForm;
import J.r.meTechnobel.Unma.service.EtudiantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

    private final EtudiantService service;

    public EtudiantController(EtudiantService service) {
        this.service = service;
    }

    @GetMapping(path = {"","/","/all"})
    public ResponseEntity<List<EtudiantDTO>> getAll(){
        return ResponseEntity
                .ok(service.getAll());
    }

    @GetMapping(path = {"/{numMatricule}"})
    public ResponseEntity<EtudiantDTO> getOne(@PathVariable String numMatricule){
        return ResponseEntity
                .ok( service.getOne(numMatricule));

    }

    @PostMapping(path = {"", "/", "/add"})
    public EtudiantDTO insert(@Valid @RequestBody EtudiantForm form){
        System.out.println(form);
        return service.insert(form);
    }

    @DeleteMapping("/{numMatricule}")
    public EtudiantDTO delete(@PathVariable(name = "numMatricule") String numMatricule) {
        return service.delete(numMatricule);
    }
}
