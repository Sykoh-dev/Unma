package J.r.meTechnobel.Unma.service;

import J.r.meTechnobel.Unma.models.dto.PresenceDTO;
import J.r.meTechnobel.Unma.models.form.PresenceForm;

import java.time.LocalDate;
import java.util.List;

public interface PresenceService {

    List<PresenceDTO> getAll();
    PresenceDTO getOne (LocalDate date);
    PresenceDTO insert (PresenceForm form);

}
