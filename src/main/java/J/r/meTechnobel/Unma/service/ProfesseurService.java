package J.r.meTechnobel.Unma.service;

import J.r.meTechnobel.Unma.models.dto.ProfesseurDTO;
import J.r.meTechnobel.Unma.models.form.ProfesseurForm;

import java.util.List;

public interface ProfesseurService {

    List<ProfesseurDTO> getAll();
    ProfesseurDTO getOne(String numMatricule);
    ProfesseurDTO insert(ProfesseurForm form);
    ProfesseurDTO delete(String numMatricule);
}
