package fr.philobox.planningevent.consultantservice.services;

import fr.philobox.planningevent.consultantservice.dtos.ConsultantRequestDto;
import fr.philobox.planningevent.consultantservice.dtos.ConsultantResponseDto;
import fr.philobox.planningevent.consultantservice.entities.ConsultantEntity;
import fr.philobox.planningevent.consultantservice.mappers.ConsultantMapper;
import fr.philobox.planningevent.consultantservice.repositories.ConsultantRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class ConsultantServiceImpl implements ConsultantService {
    private ConsultantRepository consultantRepository;
    private ConsultantMapper consultantMapper;

    @Override
    public ConsultantResponseDto save(ConsultantRequestDto consultantRequestDto) {
        ConsultantEntity consultantEntity = consultantMapper.consultantRequestDtoToConsultant(consultantRequestDto);
        consultantEntity.setId(UUID.randomUUID().toString());
        ConsultantEntity consultantSaved = consultantRepository.save(consultantEntity);

        return consultantMapper.consultantToConsultantResponseDto(consultantSaved);
    }

    @Override
    public ConsultantResponseDto update(ConsultantRequestDto consultantRequestDto) {
        return null;
    }

    @Override
    public void delete(ConsultantResponseDto consultant$ntity) {

    }

    @Override
    public ConsultantResponseDto getConsultant(String id) {
        return null;
    }

    @Override
    public ConsultantResponseDto getConsultantByEmail(String email) {
        return null;
    }

    @Override
    public List<ConsultantResponseDto> getConsultants(String id) {
        return null;
    }
}
