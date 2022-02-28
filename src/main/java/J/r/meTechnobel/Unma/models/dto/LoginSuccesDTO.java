package J.r.meTechnobel.Unma.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginSuccesDTO {

    private String jwt;
    private String username;

}
