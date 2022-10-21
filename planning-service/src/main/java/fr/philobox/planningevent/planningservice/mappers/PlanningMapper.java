package fr.philobox.planningevent.planningservice.mappers;

import fr.philobox.planningevent.planningservice.dtos.PlanningRequestDto;
import fr.philobox.planningevent.planningservice.dtos.PlanningResponseDto;
import fr.philobox.planningevent.planningservice.entities.PlanningEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlanningMapper extends Mapping {
    PlanningEntity planningRequestDtoToPlanningEntity(PlanningRequestDto planningRequestDto);
    PlanningResponseDto planningEntityToPlanningResponseDto(PlanningEntity planningEntity);
}
