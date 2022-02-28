package J.r.meTechnobel.Unma.repository;

import J.r.meTechnobel.Unma.models.entity.Horaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;


public interface HoraireRepository extends JpaRepository<Horaire, Long> {

    @Query(value = "SELECT * FROM horaire h " +
            " " +
            "join horaire_prof p " +
            "ON h.id = p.horaire_id " +
            " " +
            "join horaire_cours c " +
            "ON h.id = c.horaire_id " +
            " " +
            "join professeur pr " +
            "ON prof_id = pr.num_matricule " +
            " " +
            "join cours cr " +
            "ON cours_id = cr.id", nativeQuery = true)
    Set<Horaire> findAllHoraire();
}
