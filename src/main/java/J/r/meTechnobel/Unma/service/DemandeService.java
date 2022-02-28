package J.r.meTechnobel.Unma.service;

import J.r.meTechnobel.Unma.models.dto.DemandeDTO;
import J.r.meTechnobel.Unma.models.form.DemandeForm;


import java.util.List;

public interface DemandeService {

    List<DemandeDTO> getAll();
    DemandeDTO getOne(int id);
    DemandeDTO insert(DemandeForm form);
    DemandeDTO delete(int id);
}
