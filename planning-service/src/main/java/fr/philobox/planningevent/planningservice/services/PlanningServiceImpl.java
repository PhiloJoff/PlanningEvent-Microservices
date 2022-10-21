package fr.philobox.planningevent.planningservice.services;

import fr.philobox.planningevent.planningservice.dtos.MeetRequestDto;
import fr.philobox.planningevent.planningservice.dtos.MeetResponseDto;
import fr.philobox.planningevent.planningservice.dtos.PlanningRequestDto;
import fr.philobox.planningevent.planningservice.dtos.PlanningResponseDto;
import fr.philobox.planningevent.planningservice.entities.MeetEntity;
import fr.philobox.planningevent.planningservice.entities.PlanningEntity;
import fr.philobox.planningevent.planningservice.mappers.MeetMapper;
import fr.philobox.planningevent.planningservice.mappers.PlanningMapper;
import fr.philobox.planningevent.planningservice.repositories.MeetRepository;
import fr.philobox.planningevent.planningservice.repositories.PlanningRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
public class PlanningServiceImpl implements PlanningService {
    PlanningRepository planningRepository;
    MeetRepository meetRepository;
    MeetMapper meetMapper;
    PlanningMapper planningMapper;


    @Override
    public PlanningResponseDto savePlanning(PlanningRequestDto planningRequestDto) {
        PlanningEntity planningEntity = planningMapper.planningRequestDtoToPlanningEntity(planningRequestDto);
        planningEntity.setId(UUID.randomUUID().toString());
        PlanningEntity planningSaved = planningRepository.save(planningEntity);
        return planningMapper.planningEntityToPlanningResponseDto(planningSaved);
    }

    @Override
    public PlanningResponseDto updatePlanning(PlanningRequestDto planningRequestDto) throws Exception {
        PlanningEntity planningToUpdate = planningMapper.planningRequestDtoToPlanningEntity(planningRequestDto);
        PlanningEntity planningEntity = planningRepository.findById(planningToUpdate.getId()).orElse(null);
        if(planningEntity == null)
            throw new Exception("Planning not found");
        if(planningEntity.getConsultantEntity()!= planningToUpdate.getConsultantEntity())
            planningEntity.setConsultantEntity(planningToUpdate.getConsultantEntity());
        if(planningEntity.getMeetEntityList()!= planningToUpdate.getMeetEntityList())
            planningEntity.setMeetEntityList(planningToUpdate.getMeetEntityList());

        PlanningEntity planningSaved = planningRepository.save(planningEntity);
        return planningMapper.planningEntityToPlanningResponseDto(planningSaved);
    }

    @Override
    public void deletePlanning(String id) throws Exception {
        PlanningEntity planningEntity = planningRepository.findById(id).orElse(null);
        if(planningEntity == null)
            throw new Exception("Planning not found");
        planningRepository.delete(planningEntity);
    }

    @Override
    public PlanningResponseDto getPlanning(String id) {
        PlanningEntity planningEntity = planningRepository.findById(id).orElse(null);
        if(planningEntity == null)
            return null;

        return planningMapper.planningEntityToPlanningResponseDto(planningEntity);
    }

    @Override
    public List<PlanningResponseDto> getPlannings() {
        List<PlanningResponseDto> planningResponseDtos = planningRepository.findAll().stream()
                .map(planning -> planningMapper.planningEntityToPlanningResponseDto(planning)).collect(Collectors.toList());
        return planningResponseDtos;
    }

    @Override
    public MeetResponseDto saveMeet(MeetRequestDto meetRequestDto) {
        MeetEntity meetEntity = meetMapper.meetRequestDtoToMeetEntity(meetRequestDto);
        meetEntity.setId(UUID.randomUUID().toString());
        MeetEntity meetSaved = meetRepository.save(meetEntity);
        return meetMapper.meetEntityToMeetResponseDto(meetSaved);
    }

    @Override
    public MeetResponseDto updateMeet(MeetRequestDto meetRequestDto) throws Exception {
        MeetEntity meetToUpdate = meetMapper.meetRequestDtoToMeetEntity(meetRequestDto);
        MeetEntity meetEntity = meetRepository.findById(meetToUpdate.getId()).orElse(null);
        if(meetEntity == null)
            throw new Exception("Meet not found");
        if(meetEntity.getDate()!= meetToUpdate.getDate())
            meetEntity.setDate(meetToUpdate.getDate());
        if(meetEntity.getDuration()!= meetToUpdate.getDuration())
            meetEntity.setDuration(meetToUpdate.getDuration());
        if(meetEntity.getPlanningEntity()!= meetToUpdate.getPlanningEntity())
            meetEntity.setPlanningEntity(meetToUpdate.getPlanningEntity());

        MeetEntity meetSaved = meetRepository.save(meetEntity);
        return meetMapper.meetEntityToMeetResponseDto(meetSaved);
    }

    @Override
    public void deleteMeet(String id) throws Exception {
        MeetEntity meetEntity = meetRepository.findById(id).orElse(null);
        meetRepository.delete(meetEntity);
        if(meetEntity == null)
            throw new Exception("Meet not found");
        PlanningEntity planningEntity = planningRepository.findById(meetEntity.getId()).orElse(null);
        planningEntity.getMeetEntityList().remove(meetEntity);
        planningRepository.save(planningEntity);
    }

    @Override
    public MeetResponseDto getMeet(String id) throws Exception {
        MeetEntity meetEntity = meetRepository.findById(id).orElse(null);
        if(meetEntity == null)
            throw new Exception("Meet not found");
        return meetMapper.meetEntityToMeetResponseDto(meetEntity);
    }

    @Override
    public List<MeetResponseDto> getAllMeets() {
        List<MeetResponseDto> meetResponseDtos = meetRepository.findAll().stream()
                .map(meet -> meetMapper.meetEntityToMeetResponseDto(meet)).collect(Collectors.toList());
        return meetResponseDtos;
    }

    @Override
    public List<MeetResponseDto> getMeetsByPlanning(String planningId) throws Exception {
        PlanningEntity planningEntity = planningRepository.findById(planningId).orElse(null);
        if(planningEntity == null)
            throw new Exception("Planning not found");
        List<MeetResponseDto> meetResponseDtos = planningEntity.getMeetEntityList().stream()
                .map(meet -> meetMapper.meetEntityToMeetResponseDto(meet)).collect(Collectors.toList());
        return meetResponseDtos;
    }
}
