package J.r.meTechnobel.Unma.models.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class EtudiantDTO {

    private String numMatricule;

    private String nom;


    private String prenom;


    private String adresse;
}
