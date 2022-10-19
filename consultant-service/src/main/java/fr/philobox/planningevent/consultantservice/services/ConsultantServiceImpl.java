package fr.philobox.planningevent.consultantservice.services;

import fr.philobox.planningevent.consultantservice.dtos.ConsultantRequestDto;
import fr.philobox.planningevent.consultantservice.dtos.ConsultantResponseDto;
import fr.philobox.planningevent.consultantservice.entities.ConsultantEntity;
import fr.philobox.planningevent.consultantservice.mappers.ConsultantMapper;
import fr.philobox.planningevent.consultantservice.repositories.ConsultantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
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
    public ConsultantResponseDto update(ConsultantRequestDto consultantRequestDto) throws Exception {
        ConsultantEntity consultantEntityToUpdate = consultantMapper.consultantRequestDtoToConsultant(consultantRequestDto);
        ConsultantEntity consultantEntity = consultantRepository.findById(consultantEntityToUpdate.getId()).orElse(null);
        if (consultantEntity == null)
            throw new Exception("Consultant to update does not exist");

        if (!consultantEntity.getFirstname().equals(consultantEntityToUpdate.getFirstname()))
            consultantEntity.setFirstname(consultantEntityToUpdate.getFirstname());

        if (!consultantEntity.getLastname().equals(consultantEntityToUpdate.getLastname()))
            consultantEntity.setLastname(consultantEntityToUpdate.getLastname());

        if (!consultantEntity.getEmail().equals(consultantEntityToUpdate.getEmail()))
            consultantEntity.setEmail(consultantEntityToUpdate.getEmail());

        if (consultantEntity.getTimeCounter() != (consultantEntityToUpdate.getTimeCounter()))
            consultantEntity.setTimeCounter(consultantEntityToUpdate.getTimeCounter());

        if (!consultantEntity.getShiftEnum().equals(consultantEntityToUpdate.getShiftEnum()))
            consultantEntity.setShiftEnum(consultantEntityToUpdate.getShiftEnum());

        ConsultantEntity consultantSaved = consultantRepository.save(consultantEntity);

        return consultantMapper.consultantToConsultantResponseDto(consultantSaved);
    }

    @Override
    public void delete(String id) throws Exception {
        ConsultantEntity consultantEntity = consultantRepository.findById(id).orElse(null);
        if(consultantEntity != null)
            consultantRepository.delete(consultantEntity);
        else
            throw new Exception("Consultant to delete does not exist");

    }

    @Override
    public ConsultantResponseDto getConsultant(String id) {
        ConsultantEntity consultantEntity = consultantRepository.findById(id).orElse(null);
        if (consultantEntity == null)
            return null;
        return consultantMapper.consultantToConsultantResponseDto(consultantEntity);
    }

    @Override
    public ConsultantResponseDto getConsultantByEmail(String email) {
        ConsultantEntity consultantEntity = consultantRepository.findByEmail(email);
        return consultantMapper.consultantToConsultantResponseDto(consultantEntity);
    }

    @Override
    public List<ConsultantResponseDto> getAllConsultants() {
        List<ConsultantResponseDto> consultantResponseDtos = consultantRepository.findAll().stream().map(consultant -> consultantMapper.consultantToConsultantResponseDto(consultant)).collect(Collectors.toList());

        return consultantResponseDtos;
    }

    @Override
    public List<ConsultantResponseDto> getConsultantsByFirstnameOrLastname(String firstname, String lastname) {
        List<ConsultantResponseDto> consultantResponseDtos = consultantRepository.findAllByFirstnameContainsOrLastnameContains(firstname, lastname).stream().map(consultant -> consultantMapper.consultantToConsultantResponseDto(consultant)).collect(Collectors.toList());
        return consultantResponseDtos;
    }

}
