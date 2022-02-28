package J.r.meTechnobel.Unma.service;

import J.r.meTechnobel.Unma.models.dto.UtilisateurDTO;
import J.r.meTechnobel.Unma.models.form.UtilisateurForm;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UtilisateurService extends UserDetailsService {

    UtilisateurDTO insert(UtilisateurForm form);
    UtilisateurDTO update(long id, UtilisateurForm form);
    List<UtilisateurDTO> getAll();

}
