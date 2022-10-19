package fr.philobox.planningevent.consultantservice.services;

import fr.philobox.planningevent.consultantservice.dtos.ConsultantRequestDto;
import fr.philobox.planningevent.consultantservice.dtos.ConsultantResponseDto;

import java.util.List;

public interface ConsultantService {
    public ConsultantResponseDto save(ConsultantRequestDto consultantRequestDto);
    public ConsultantResponseDto update(ConsultantRequestDto consultantRequestDto );
    public void delete(ConsultantResponseDto consultantEntity);
    public ConsultantResponseDto getConsultant(String id);
    public ConsultantResponseDto getConsultantByEmail(String email);
    public List<ConsultantResponseDto> getConsultants(String id);
}
