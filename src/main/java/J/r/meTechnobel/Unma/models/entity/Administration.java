package J.r.meTechnobel.Unma.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table( name="Administration")
@DiscriminatorValue("Administration")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Administration  extends Utilisateur {

//    @Id
//    @Column( name = "Administration")
//    private String numMatricule;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String adresse;

}
