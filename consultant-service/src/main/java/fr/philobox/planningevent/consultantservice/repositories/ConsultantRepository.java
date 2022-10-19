package fr.philobox.planningevent.consultantservice.repositories;

import fr.philobox.planningevent.consultantservice.entities.ConsultantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultantRepository extends JpaRepository<ConsultantEntity, String> {
    ConsultantEntity findByEmail(String email);
}
