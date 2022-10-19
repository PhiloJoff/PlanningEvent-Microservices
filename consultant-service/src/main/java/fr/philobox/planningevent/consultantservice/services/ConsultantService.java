package fr.philobox.planningevent.consultantservice.services;

import fr.philobox.planningevent.consultantservice.dtos.ConsultantRequestDto;
import fr.philobox.planningevent.consultantservice.dtos.ConsultantResponseDto;

import java.util.List;

public interface ConsultantService {
    public ConsultantResponseDto save(ConsultantRequestDto consultantRequestDto);
    public ConsultantResponseDto update(ConsultantRequestDto consultantRequestDto ) throws Exception;
    public void delete(String id) throws Exception;
    public ConsultantResponseDto getConsultant(String id);
    public ConsultantResponseDto getConsultantByEmail(String email);
    public List<ConsultantResponseDto> getAllConsultants();
    public List<ConsultantResponseDto> getConsultantsByFirstnameOrLastname(String firstname, String lastname);
}
