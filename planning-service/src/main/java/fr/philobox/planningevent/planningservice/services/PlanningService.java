package fr.philobox.planningevent.planningservice.services;

import fr.philobox.planningevent.planningservice.dtos.MeetRequestDto;
import fr.philobox.planningevent.planningservice.dtos.MeetResponseDto;
import fr.philobox.planningevent.planningservice.dtos.PlanningRequestDto;
import fr.philobox.planningevent.planningservice.dtos.PlanningResponseDto;

import java.util.List;

public interface PlanningService {
    PlanningResponseDto savePlanning(PlanningRequestDto planningRequestDto);
    PlanningResponseDto updatePlanning(PlanningRequestDto planningRequestDto) throws Exception;
    void deletePlanning (String id) throws Exception;
    PlanningResponseDto getPlanning(String id);
    List<PlanningResponseDto> getPlannings();

    MeetResponseDto saveMeet(MeetRequestDto meetEntity);
    MeetResponseDto updateMeet(MeetRequestDto meetEntity) throws Exception;
    void deleteMeet(String id) throws Exception;
    MeetResponseDto getMeet(String id) throws Exception;
    List<MeetResponseDto> getAllMeets();
    List<MeetResponseDto> getMeetsByPlanning(String planningId) throws Exception;
}
