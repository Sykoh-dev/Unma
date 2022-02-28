package J.r.meTechnobel.Unma.mapper;

import J.r.meTechnobel.Unma.models.dto.CoursDTO;
import J.r.meTechnobel.Unma.models.entity.Cours;
import J.r.meTechnobel.Unma.models.form.CoursForm;
import org.springframework.stereotype.Service;

@Service
public class CoursMapper {

    public CoursDTO toDto(Cours entity){
        if( entity == null )
            return null;

        return CoursDTO.builder()
                .id(entity.getId())
                .intitule(entity.getIntitule())
                .build();
    }

    public Cours formToEntity(CoursForm form){
        if( form == null )
            return null;

        Cours entity = new Cours();
        entity.setId(form.getId());
        entity.setIntitule(form.getIntitule());
        return entity;
    }
}
