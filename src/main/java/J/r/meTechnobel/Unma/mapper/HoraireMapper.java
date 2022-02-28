package J.r.meTechnobel.Unma.mapper;

import J.r.meTechnobel.Unma.models.dto.HoraireDTO;
import J.r.meTechnobel.Unma.models.entity.Horaire;
import J.r.meTechnobel.Unma.models.form.HoraireForm;
import J.r.meTechnobel.Unma.models.form.HoraireUpdateForm;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class HoraireMapper{

    private final CoursMapper coursMapper;
    private final ProfesseurMapper professeurMapper;

    public HoraireMapper(CoursMapper coursMapper, ProfesseurMapper professeurMapper) {
        this.coursMapper = coursMapper;
        this.professeurMapper = professeurMapper;
    }

    public HoraireDTO toDto(Horaire entity) {
        if( entity == null )
            return null;

        return HoraireDTO.builder()
                .id(entity.getId())
                .date(entity.getDate())
                .nomFiliere(entity.getNomFiliere())
                .heureDebut(entity.getHeureDebut())
                .heureFin(entity.getHeureFin())
                .cours(entity.getCours().stream().map(coursMapper::toDto).collect(Collectors.toSet()))
                .professeurs(entity.getProfesseurs().stream().map(professeurMapper::toDto).collect(Collectors.toSet()))
                .build();

    }


    public Horaire formToEntity(HoraireForm form) {
        if( form == null )
            return null;

        Horaire entity = new Horaire();
        entity.setId(form.getId());
        entity.setNomFiliere(form.getNomFiliere());
        entity.setDate(form.getDate());
        entity.setHeureDebut(form.getHeureDebut());
        entity.setHeureFin(form.getHeureFin());
        return entity;
    }

    public Horaire updateFormToEntity(HoraireUpdateForm form) {
        if( form == null )
            return null;

        Horaire entity = new Horaire();
        entity.setId(form.getId());
        entity.setNomFiliere(form.getNomFiliere());
        entity.setHeureDebut(form.getHeureDebut());
        entity.setHeureFin(form.getHeureFin());
        return entity;
    }

}
