package fr.philobox.planningevent.planningservice.repositories;

import fr.philobox.planningevent.planningservice.entities.MeetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetRepository extends JpaRepository<MeetEntity, String> {
}
