package fr.philobox.planningevent.consultantservice.services;

import fr.philobox.planningevent.consultantservice.dtos.ConsultantRequestDto;
import fr.philobox.planningevent.consultantservice.dtos.ConsultantResponseDto;

import java.util.List;

public interface ConsultantService {
    ConsultantResponseDto save(ConsultantRequestDto consultantRequestDto);
    ConsultantResponseDto update(ConsultantRequestDto consultantRequestDto ) throws Exception;
    void delete(String id) throws Exception;
    ConsultantResponseDto getConsultant(String id);
    ConsultantResponseDto getConsultantByEmail(String email);
    List<ConsultantResponseDto> getAllConsultants();
    List<ConsultantResponseDto> getConsultantsByFirstnameOrLastname(String firstname, String lastname);
}
