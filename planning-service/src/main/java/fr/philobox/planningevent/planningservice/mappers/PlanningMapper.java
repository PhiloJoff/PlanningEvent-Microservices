package fr.philobox.planningevent.planningservice.mappers;

import fr.philobox.planningevent.planningservice.dtos.PlanningRequestDto;
import fr.philobox.planningevent.planningservice.dtos.PlanningResponseDto;
import fr.philobox.planningevent.planningservice.entities.PlanningEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlanningMapper {
    PlanningEntity planningRequestDtoToPlanningEntity(PlanningRequestDto planningRequestDto);
    PlanningResponseDto planningEntityToPlanningResponseDto(PlanningEntity planningEntity);
}
