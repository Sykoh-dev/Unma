package J.r.meTechnobel.Unma.controller;

import J.r.meTechnobel.Unma.models.dto.LoginSuccesDTO;
import J.r.meTechnobel.Unma.models.form.LoginForm;
import J.r.meTechnobel.Unma.service.SessionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;

@RestController
public class SessionController {

    private final SessionServiceImpl sessionService;

    public SessionController(SessionServiceImpl sessionService) {
        this.sessionService = sessionService;
    }


    @PostMapping("/login")
    public ResponseEntity<LoginSuccesDTO> login(@Valid @RequestBody LoginForm form){
        return ResponseEntity.ok( sessionService.login(form) );
    }

}
