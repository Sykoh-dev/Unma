package J.r.meTechnobel.Unma.mapper;

import J.r.meTechnobel.Unma.models.dto.DemandeDTO;
import J.r.meTechnobel.Unma.models.entity.Demande;
import J.r.meTechnobel.Unma.models.entity.Horaire;
import J.r.meTechnobel.Unma.models.form.DemandeForm;
import org.springframework.stereotype.Service;

@Service
public class DemandeMapper {

    public DemandeDTO toDto(Demande entity){
        if( entity == null )
            return null;

        return DemandeDTO.builder()
                .id(entity.getId())
                .numMatricule(entity.getNumMatricule())
                .cours(entity.getCours())
                .salle(entity.getSalle())
                .build();

    }

    public Demande formToEntity(DemandeForm form){
        if( form == null )
            return null;

        Demande entity = new Demande();
        entity.setNumMatricule(form.getNumMatricule());
        entity.setCours(form.getCours());
        entity.setSalle(form.getSalle());
        return entity;
    }
}
