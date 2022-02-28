package J.r.meTechnobel.Unma.mapper;

import J.r.meTechnobel.Unma.models.dto.EtudiantDTO;
import J.r.meTechnobel.Unma.models.entity.Etudiant;
import J.r.meTechnobel.Unma.models.form.EtudiantForm;
import org.springframework.stereotype.Service;

@Service
public class EtudiantMapper {

    public EtudiantDTO toDto(Etudiant entity){
        if( entity == null )
            return null;

        return EtudiantDTO.builder()
                .numMatricule(entity.getNumMatricule())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .adresse(entity.getAdresse())
                .build();
    }

    public Etudiant formToEntity(EtudiantForm form){
        if( form == null )
            return null;

        Etudiant entity = new Etudiant();
        entity.setNumMatricule(form.getNumMatricule());
        entity.setNom(form.getNom());
        entity.setPrenom(form.getPrenom());
        entity.setAdresse(form.getAdresse());
        return entity;
    }
}
