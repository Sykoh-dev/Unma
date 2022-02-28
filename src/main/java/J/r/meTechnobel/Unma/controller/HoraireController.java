package J.r.meTechnobel.Unma.controller;

import J.r.meTechnobel.Unma.models.dto.HoraireDTO;
import J.r.meTechnobel.Unma.models.form.HoraireForm;
import J.r.meTechnobel.Unma.models.form.HoraireUpdateForm;
import J.r.meTechnobel.Unma.service.HoraireService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/horaire")
public class HoraireController {

    private final HoraireService service;

    public HoraireController(HoraireService service) {
        this.service = service;
    }

    @GetMapping(path = {"","/","/all"})
    public ResponseEntity<List<HoraireDTO>> getAll(){
        return ResponseEntity
                .ok(service.getAll());
    }

    @GetMapping(path = {"/{nomFiliere}"})
    public ResponseEntity<HoraireDTO> getOne(@PathVariable  Long id){
        return ResponseEntity
                .ok( service.getOne(id));

    }

    @PostMapping(path = {"", "/", "/add"})
    public HoraireDTO insert(@Valid @RequestBody HoraireForm form){
        return service.insert(form);
    }

    @DeleteMapping(path = {"/delete"}, params = {"id"} )
    public HoraireDTO delete(@RequestParam Long id){
        return service.delete(id);
    }

    @PutMapping (params = "id")
    public HoraireDTO update(@RequestParam Long id, @Valid @RequestBody HoraireUpdateForm form){
        return service.update(id, form);
    }
}
