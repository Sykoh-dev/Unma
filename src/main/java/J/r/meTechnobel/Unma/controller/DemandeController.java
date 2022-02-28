package J.r.meTechnobel.Unma.controller;

import J.r.meTechnobel.Unma.models.dto.DemandeDTO;
import J.r.meTechnobel.Unma.models.form.DemandeForm;
import J.r.meTechnobel.Unma.service.DemandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/demande")
public class DemandeController {

    private final DemandeService service;

    public DemandeController(DemandeService service) {
        this.service = service;
    }

    @GetMapping(path = {"","/","/all"})
    public ResponseEntity<List<DemandeDTO>> getAll(){
        return ResponseEntity
                .ok(service.getAll());
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<DemandeDTO> getOne(@PathVariable int id){
        return ResponseEntity
                .ok( service.getOne(id));

    }

    @PostMapping(path = {"", "/", "/add"})
    public DemandeDTO insert(@Valid @RequestBody DemandeForm form){
        return service.insert(form);
    }

    @DeleteMapping("/{id}")
    public DemandeDTO delete(@PathVariable(name = "id") int id){
        return service.delete(id);
    }

}
