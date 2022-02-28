package J.r.meTechnobel.Unma.models.form;

import J.r.meTechnobel.Unma.models.entity.Demande;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class DemandeForm {

    private int id;
    private String salle;
    private String cours;
    private String numMatricule;

    public Demande toEntity(){
        Demande demande = new Demande();
        demande.setId(id);
        demande.setSalle(salle);
        demande.setCours(cours);
        demande.setNumMatricule(numMatricule);
        return demande;

    }
}
