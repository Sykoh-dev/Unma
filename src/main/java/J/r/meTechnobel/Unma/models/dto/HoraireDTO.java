package J.r.meTechnobel.Unma.models.dto;

import J.r.meTechnobel.Unma.models.entity.Cours;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

@Data
@Builder
public class HoraireDTO {

    private Long id;
    private String nomFiliere;
    private LocalDate date;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private Set<CoursDTO> cours;
    private Set<ProfesseurDTO> professeurs;
}
