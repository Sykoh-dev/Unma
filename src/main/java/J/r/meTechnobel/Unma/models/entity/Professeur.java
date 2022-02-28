package J.r.meTechnobel.Unma.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table( name="Professeur")
@DiscriminatorValue("Professeur")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Professeur  extends Utilisateur{

//    @Id
//    @Column( name = "Professeur")
//    private String numMatricule;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String adresse;

    @ManyToMany(mappedBy = "professeurs", fetch = FetchType.LAZY)
    private Set<Horaire> horaires;



}
