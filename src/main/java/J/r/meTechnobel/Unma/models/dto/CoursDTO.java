package J.r.meTechnobel.Unma.models.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class CoursDTO {

    private Long id;
    private String intitule;
}
