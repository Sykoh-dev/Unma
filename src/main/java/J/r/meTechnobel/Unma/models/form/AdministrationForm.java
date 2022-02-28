package J.r.meTechnobel.Unma.models.form;

import J.r.meTechnobel.Unma.models.entity.Administration;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
@Validated
public class AdministrationForm {

    @NotBlank
    private String numMatricule;

    @NotBlank
    private String nom;

    @NotBlank
    private String prenom;

    @NotBlank
    private String adresse;

    public Administration toEntity(){
        Administration administration = new Administration();
        administration.setNumMatricule(numMatricule);
        administration.setNom(nom);
        administration.setPrenom(prenom);
        administration.setAdresse(adresse);
        return administration;
    }
}
