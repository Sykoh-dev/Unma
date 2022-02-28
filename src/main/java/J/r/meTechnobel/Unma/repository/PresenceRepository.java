package J.r.meTechnobel.Unma.repository;

import J.r.meTechnobel.Unma.models.entity.Presence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PresenceRepository extends JpaRepository<Presence, LocalDate> {
}
