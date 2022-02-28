package J.r.meTechnobel.Unma.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Presence {

    @Id
    @Column( name = "date")
    private LocalDate date;

    @Column(nullable = false)
    private String Nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String Cours;



}
