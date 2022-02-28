package J.r.meTechnobel.Unma.models.form;

import J.r.meTechnobel.Unma.models.entity.Horaire;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.time.LocalTime;
import java.util.Date;

@Data
@Validated
public class HoraireUpdateForm {

    private Long id;
    private String nomFiliere;
    private LocalTime heureDebut;
    private LocalTime heureFin;

    public Horaire toEntity(){
        Horaire horaire = new Horaire();
        horaire.setId(id);
        horaire.setNomFiliere(nomFiliere);
        horaire.setHeureDebut(heureDebut);
        horaire.setHeureFin(heureFin);
        return horaire;
    }
}
