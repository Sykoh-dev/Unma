package J.r.meTechnobel.Unma.controller;

import J.r.meTechnobel.Unma.models.dto.PresenceDTO;
import J.r.meTechnobel.Unma.models.form.PresenceForm;
import J.r.meTechnobel.Unma.service.PresenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/presence")
public class PresenceController {

    private final PresenceService service;

    public PresenceController(PresenceService service) {
        this.service = service;
    }

    @GetMapping(path = {"","/","/all"})
    public ResponseEntity<List<PresenceDTO>> getAll(){
        return ResponseEntity
                .ok(service.getAll());
    }

    @GetMapping(path = {"/{date}"})
    public ResponseEntity<PresenceDTO> getOne(@PathVariable LocalDate date){
        return ResponseEntity
                .ok( service.getOne(date));

    }

    @PostMapping(path = {"", "/", "/add"})
    public PresenceDTO insert(@Valid @RequestBody PresenceForm form){
        return service.insert(form);
    }
}
