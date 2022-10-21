package fr.philobox.planningevent.planningservice.dtos;

import fr.philobox.planningevent.planningservice.entities.ConsultantEntity;
import fr.philobox.planningevent.planningservice.entities.MeetEntity;

import java.util.List;

public class PlanningResponseDto {
    private String id;
    private List<MeetEntity> meetEntityList;
    private ConsultantEntity consultantEntity;
}
