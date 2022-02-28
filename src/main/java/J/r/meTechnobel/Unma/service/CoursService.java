package J.r.meTechnobel.Unma.service;

import J.r.meTechnobel.Unma.models.dto.CoursDTO;
import J.r.meTechnobel.Unma.models.form.CoursForm;

import java.util.List;

public interface CoursService {

    List<CoursDTO> getAll();
    CoursDTO getOne(Long id);
    CoursDTO insert(CoursForm form);
    CoursDTO delete(Long id);
}
