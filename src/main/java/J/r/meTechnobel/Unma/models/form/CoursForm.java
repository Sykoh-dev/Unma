package J.r.meTechnobel.Unma.models.form;

import J.r.meTechnobel.Unma.models.entity.Cours;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
@Validated
public class CoursForm {


    private Long id;
    @NotBlank
    private String intitule;

    public Cours toEntity(){
        Cours cours = new Cours();
        cours.setId(id);
        cours.setIntitule(intitule);
        return cours;
    }
}
