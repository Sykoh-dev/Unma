package J.r.meTechnobel.Unma.mapper;

import J.r.meTechnobel.Unma.models.dto.AdministrationDTO;
import J.r.meTechnobel.Unma.models.entity.Administration;
import J.r.meTechnobel.Unma.models.form.AdministrationForm;
import org.springframework.stereotype.Service;

@Service
public class AdministrationMapper {

    public AdministrationDTO toDto(Administration entity){
        if( entity == null )
            return null;

        return AdministrationDTO.builder()
                .numMatricule(entity.getNumMatricule())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .adresse(entity.getAdresse())
                .build();
    }

    public Administration formToEntity(AdministrationForm form){
        if( form == null )
            return null;

        Administration entity = new Administration();
        entity.setNumMatricule(form.getNumMatricule());
        entity.setNom(form.getNom());
        entity.setPrenom(form.getPrenom());
        entity.setAdresse(form.getAdresse());
        return entity;
    }
}
