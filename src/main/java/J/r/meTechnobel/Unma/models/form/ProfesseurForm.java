package J.r.meTechnobel.Unma.models.form;

import J.r.meTechnobel.Unma.models.entity.Professeur;
import lombok.Data;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
@Validated
public class ProfesseurForm {

    @NotBlank
    private String numMatricule;

    @NotBlank
    private String nom;

    @NotBlank
    private String prenom;

    @NotBlank
    private String adresse;

    public Professeur toEntity(){
        Professeur professeur = new Professeur();
        professeur.setNumMatricule(numMatricule);
        professeur.setNom(nom);
        professeur.setPrenom(prenom);
        professeur.setAdresse(adresse);
        return professeur;
    }
}
