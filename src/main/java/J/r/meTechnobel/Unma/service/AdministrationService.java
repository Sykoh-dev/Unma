package J.r.meTechnobel.Unma.service;

import J.r.meTechnobel.Unma.models.dto.AdministrationDTO;
import J.r.meTechnobel.Unma.models.form.AdministrationForm;

import java.util.List;

public interface AdministrationService {

    List<AdministrationDTO> getAll();
    AdministrationDTO getOne(String numMatricule);
    AdministrationDTO insert(AdministrationForm form);
    AdministrationDTO delete(String numMatricule);
}
