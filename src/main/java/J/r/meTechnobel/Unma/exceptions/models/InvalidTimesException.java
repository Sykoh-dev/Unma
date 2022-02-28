package J.r.meTechnobel.Unma.exceptions.models;

import J.r.meTechnobel.Unma.exceptions.AdviserHandled;
import lombok.Getter;

import javax.persistence.Column;
import java.time.LocalTime;

@Getter
@AdviserHandled
public class InvalidTimesException extends RuntimeException{

    private LocalTime heureDebut;
    private LocalTime heureFin;

    public InvalidTimesException(LocalTime heureDebut, LocalTime heureFin) {
        super("Les heures sont invalides, l'heure de fin doit être après l'heure de début");
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }
}
