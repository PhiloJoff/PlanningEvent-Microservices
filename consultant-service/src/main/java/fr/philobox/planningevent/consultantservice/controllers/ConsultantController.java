package fr.philobox.planningevent.consultantservice.controllers;

import fr.philobox.planningevent.consultantservice.dtos.ConsultantRequestDto;
import fr.philobox.planningevent.consultantservice.dtos.ConsultantResponseDto;
import fr.philobox.planningevent.consultantservice.services.ConsultantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "/consultants")
@AllArgsConstructor
public class ConsultantController {
    private ConsultantService consultantService;

    @GetMapping(path="/consultant")
    public ConsultantResponseDto getConsultant(@RequestBody(required = true) String id) {
        return consultantService.getConsultant(id);
    }

    @PostMapping(path="/consultant")
    public ConsultantResponseDto saveConsultant(@RequestBody ConsultantRequestDto consultantRequestDto) {
        return consultantService.save(consultantRequestDto);
    }

    @PutMapping(path = "/consultant")
    public ConsultantResponseDto updateConsultant(@RequestBody ConsultantRequestDto consultantRequestDto) throws Exception {
        return consultantService.update(consultantRequestDto);
    }

    @DeleteMapping(path = "/consultant")
    public void deleteConsultant(@RequestBody String id) throws Exception {
        consultantService.delete(id);
    }

    @GetMapping(path="/all")
    public List<ConsultantResponseDto> getAllConsultants() {
        return consultantService.getAllConsultants();
    }

    @GetMapping(path="/all")
    public List<ConsultantResponseDto> getAllConsultants(@RequestParam(value="name", defaultValue = "") String name) {
        return consultantService.getConsultantsByName(name);
    }
}
