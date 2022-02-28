package J.r.meTechnobel.Unma.service;

import J.r.meTechnobel.Unma.models.dto.HoraireDTO;
import J.r.meTechnobel.Unma.models.form.HoraireForm;
import J.r.meTechnobel.Unma.models.form.HoraireUpdateForm;

import java.util.List;

public interface HoraireService {

    List<HoraireDTO> getAll();
    HoraireDTO getOne(Long id);
    HoraireDTO insert(HoraireForm form);
    HoraireDTO delete(Long id);
    HoraireDTO update(Long id, HoraireUpdateForm form);
}
