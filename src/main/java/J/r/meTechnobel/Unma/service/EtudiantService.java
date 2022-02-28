package J.r.meTechnobel.Unma.service;

import J.r.meTechnobel.Unma.models.dto.EtudiantDTO;
import J.r.meTechnobel.Unma.models.form.EtudiantForm;

import java.util.List;

public interface EtudiantService {

    List<EtudiantDTO> getAll();
    EtudiantDTO getOne(String numMatricule);
    EtudiantDTO insert(EtudiantForm form);
    EtudiantDTO delete(String numMatricule);
}
