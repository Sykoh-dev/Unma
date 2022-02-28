package J.r.meTechnobel.Unma.models.form;

import J.r.meTechnobel.Unma.models.entity.Presence;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@Validated
public class PresenceForm {

    private LocalDate date;
    private String nom;
    private String prenom;
    private String cours;

    public Presence toEntity(){
        Presence presence = new Presence();
        presence.setDate(date);
        presence.setNom(nom);
        presence.setPrenom(prenom);
        presence.setCours(cours);
        return presence;
    }
}
