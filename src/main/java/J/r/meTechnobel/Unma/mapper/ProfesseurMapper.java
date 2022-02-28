package J.r.meTechnobel.Unma.mapper;

import J.r.meTechnobel.Unma.models.dto.ProfesseurDTO;
import J.r.meTechnobel.Unma.models.entity.Professeur;
import J.r.meTechnobel.Unma.models.form.ProfesseurForm;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

@Service
public class ProfesseurMapper {

    public ProfesseurDTO toDto(Professeur entity){
        if( entity == null )
            return null;

        return ProfesseurDTO.builder()
                .numMatricule(entity.getNumMatricule())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .adresse(entity.getAdresse())
                .build();
    }

    public Professeur formToEntity(ProfesseurForm form){
        if( form == null )
            return null;

        Professeur entity = new Professeur();
        entity.setNumMatricule(form.getNumMatricule());
        entity.setNom(form.getNom());
        entity.setPrenom(form.getPrenom());
        entity.setAdresse(form.getAdresse());
        return entity;
    }
}
