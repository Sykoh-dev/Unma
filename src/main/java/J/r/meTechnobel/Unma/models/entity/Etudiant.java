package J.r.meTechnobel.Unma.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table( name="Etudiant")
@DiscriminatorValue("Etudiant")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Etudiant extends Utilisateur {

//    @Id
//    @Column( name = "Etudiant")
//    private String numMatricule;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String adresse;



}
