package J.r.meTechnobel.Unma.models.form;

import J.r.meTechnobel.Unma.models.entity.Etudiant;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
@Validated
public class EtudiantForm {

    @NotBlank
    private String numMatricule;

    @NotBlank
    private String nom;

    @NotBlank
    private String prenom;

    @NotBlank
    private String adresse;

    public Etudiant toEntity(){
        Etudiant etudiant = new Etudiant();
        etudiant.setNumMatricule(numMatricule);
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setAdresse(adresse);
        return etudiant;
    }

}
