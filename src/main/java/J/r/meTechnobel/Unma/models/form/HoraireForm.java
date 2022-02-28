package J.r.meTechnobel.Unma.models.form;

import J.r.meTechnobel.Unma.models.entity.Horaire;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;


@Data
@Validated
public class HoraireForm {

    private Long id;

    private String nomFiliere;
    @Future
    private LocalDate date;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private Set<CoursForm> cours;
    private Set<ProfesseurForm> professeurs;

    public Horaire toEntity(){
        Horaire horaire = new Horaire();
        horaire.setId(id);
        horaire.setNomFiliere(nomFiliere);
        horaire.setDate(date);
        horaire.setHeureDebut(heureDebut);
        horaire.setHeureFin(heureFin);
        return horaire;
    }


}
