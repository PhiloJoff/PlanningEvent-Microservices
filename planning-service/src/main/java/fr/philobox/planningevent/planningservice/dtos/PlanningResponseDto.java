package fr.philobox.planningevent.planningservice.dtos;

import fr.philobox.planningevent.planningservice.entities.ConsultantEntity;
import fr.philobox.planningevent.planningservice.entities.MeetEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PlanningResponseDto {
    private String id;
    private List<MeetEntity> meetEntityList;
    private ConsultantEntity consultantEntity;
}
