package fr.philobox.planningevent.planningservice.dtos;

import fr.philobox.planningevent.planningservice.entities.PlanningEntity;

import java.util.Date;

public class MeetRequestDto {
    private String id;
    private int duration;
    private Date date;
    private PlanningEntity planningEntity;
}
