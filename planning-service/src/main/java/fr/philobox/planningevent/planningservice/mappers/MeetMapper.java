package fr.philobox.planningevent.planningservice.mappers;

import fr.philobox.planningevent.planningservice.dtos.MeetRequestDto;
import fr.philobox.planningevent.planningservice.dtos.MeetResponseDto;
import fr.philobox.planningevent.planningservice.entities.MeetEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MeetMapper {
    MeetEntity meetRequestDtoToMeetEntity(MeetRequestDto meetRequestDto);
    MeetResponseDto meetEntityToMeetResponseDto(MeetEntity meetEntity);
}
