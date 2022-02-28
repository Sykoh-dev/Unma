package J.r.meTechnobel.Unma.models.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@Builder
public class DemandeDTO {


    private int id;
    private String salle;
    private String cours;
    private String numMatricule;
}
