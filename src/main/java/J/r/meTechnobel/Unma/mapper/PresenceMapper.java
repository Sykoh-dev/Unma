package J.r.meTechnobel.Unma.mapper;

import J.r.meTechnobel.Unma.models.dto.PresenceDTO;
import J.r.meTechnobel.Unma.models.entity.Presence;
import J.r.meTechnobel.Unma.models.form.PresenceForm;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

@Service
public class PresenceMapper {

    public PresenceDTO toDto(Presence entity){
        if( entity == null )
            return null;

        return PresenceDTO.builder()
                .date(entity.getDate())
                .Nom(entity.getNom())
                .prenom(entity.getPrenom())
                .Cours(entity.getCours())
                .build();
    }

    public Presence formToEntity(PresenceForm form){
        if( form == null )
            return null;

        Presence entity = new Presence();
        entity.setDate(form.getDate());
        entity.setNom(form.getNom());
        entity.setPrenom(form.getPrenom());
        entity.setCours(form.getCours());
        return entity;
    }

}
