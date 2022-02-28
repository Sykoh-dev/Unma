package J.r.meTechnobel.Unma.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Horaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomFiliere;
    @Column
    private LocalDate date;
    @Column
    private LocalTime heureDebut;
    @Column
    private LocalTime heureFin;





    @ManyToMany
    @JoinTable(name = "HoraireCours",
            joinColumns = @JoinColumn(name = "horaireId"),
            inverseJoinColumns = @JoinColumn(name = "coursId")
    )
    private Set<Cours> cours;

    @ManyToMany
    @JoinTable(name = "HoraireProf",
            joinColumns = @JoinColumn(name = "horaireId"),
            inverseJoinColumns = @JoinColumn(name = "profId")
    )
    private Set<Professeur> professeurs;

}
