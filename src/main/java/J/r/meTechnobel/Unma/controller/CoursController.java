package J.r.meTechnobel.Unma.controller;

import J.r.meTechnobel.Unma.models.dto.CoursDTO;
import J.r.meTechnobel.Unma.models.form.CoursForm;
import J.r.meTechnobel.Unma.service.CoursService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {

    private final CoursService service;

    public CoursController(CoursService service) {
        this.service = service;
    }

    @GetMapping(path = {"","/","/all"})
    public ResponseEntity<List<CoursDTO>> getAll(){
        return ResponseEntity
                .ok(service.getAll());
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<CoursDTO> getOne(@PathVariable Long id){
        return ResponseEntity
                .ok( service.getOne(id));

    }

    @PostMapping(path = {"", "/", "/add"})
    public CoursDTO insert(@Valid @RequestBody CoursForm form){
        System.out.println(form);
        return service.insert(form);
    }

    @DeleteMapping("/{id}")
    public CoursDTO delete(@PathVariable(name = "id") Long id){

        return service.delete(id);
    }
}
