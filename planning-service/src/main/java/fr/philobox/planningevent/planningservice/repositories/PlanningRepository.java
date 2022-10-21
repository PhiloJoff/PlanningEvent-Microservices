package fr.philobox.planningevent.planningservice.repositories;

import fr.philobox.planningevent.planningservice.entities.PlanningEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanningRepository extends JpaRepository<PlanningEntity, String> {
}
