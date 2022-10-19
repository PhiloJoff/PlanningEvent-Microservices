package fr.philobox.planningevent.consultantservice.repositories;

import fr.philobox.planningevent.consultantservice.entities.ConsultantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultantRepository extends JpaRepository<ConsultantEntity, String> {
    ConsultantEntity findByEmail(String email);
    List<ConsultantEntity> findAllByFirstnameContainsOrLastnameContains(String firstname, String lastname);
}
