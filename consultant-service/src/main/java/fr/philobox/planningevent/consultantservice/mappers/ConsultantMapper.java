package fr.philobox.planningevent.consultantservice.mappers;

import fr.philobox.planningevent.consultantservice.dtos.ConsultantRequestDto;
import fr.philobox.planningevent.consultantservice.dtos.ConsultantResponseDto;
import fr.philobox.planningevent.consultantservice.entities.ConsultantEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConsultantMapper {
    ConsultantResponseDto consultantToConsultantResponseDto(ConsultantEntity consultantEntity);
    ConsultantEntity consultantRequestDtoToConsultant(ConsultantRequestDto consultantResponseDto);
}
