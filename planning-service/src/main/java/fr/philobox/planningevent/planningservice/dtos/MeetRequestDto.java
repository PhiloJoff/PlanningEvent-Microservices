package fr.philobox.planningevent.planningservice.dtos;

import fr.philobox.planningevent.planningservice.entities.PlanningEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class MeetRequestDto {
    private String id;
    private int duration;
    private Date date;
    private PlanningEntity planningEntity;
}
