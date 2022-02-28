package J.r.meTechnobel.Unma.models.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@Builder
public class PresenceDTO {

    private LocalDate date;
    private String Nom;
    private String prenom;
    private String Cours;
}
