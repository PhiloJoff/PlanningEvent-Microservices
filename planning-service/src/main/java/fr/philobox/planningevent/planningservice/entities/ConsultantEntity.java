package fr.philobox.planningevent.planningservice.entities;

import fr.philobox.planningevent.planningservice.entities.enums.ShiftEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultantEntity {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private int timeCounter;
    private ShiftEnum shift;
    private PlanningEntity planningEntityP;
}
