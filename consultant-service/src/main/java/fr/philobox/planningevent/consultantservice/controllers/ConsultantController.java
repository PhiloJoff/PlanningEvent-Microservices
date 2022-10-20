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

    @GetMapping(path="/consultant/{id}")
    public ConsultantResponseDto getConsultant(@PathVariable String id) {
        return consultantService.getConsultant(id);
    }

    @PostMapping(path="/consultant/add")
    public ConsultantResponseDto saveConsultant(@RequestBody ConsultantRequestDto consultantRequestDto) {
        return consultantService.save(consultantRequestDto);
    }

    @PutMapping(path = "/consultant/update")
    public ConsultantResponseDto updateConsultant(@RequestBody ConsultantRequestDto consultantRequestDto) throws Exception {
        return consultantService.update(consultantRequestDto);
    }

    @DeleteMapping(path = "/consultant/delete")
    public void deleteConsultant(@PathVariable String id) throws Exception {
        consultantService.delete(id);
    }

    @GetMapping(path="/all")
    public List<ConsultantResponseDto> getAllConsultants() {
        return consultantService.getAllConsultants();
    }

    @GetMapping(path="/all/filters")
    public List<ConsultantResponseDto> getAllConsultantsByFirstnameOrLastname(@RequestParam(value="firstname", defaultValue = "") String firstname,
                                                                              @RequestParam(value = "lastname", defaultValue = "") String lastname) {
        return consultantService.getConsultantsByFirstnameOrLastname(firstname, lastname);
    }

    @GetMapping(path="/consultant/{email}")
    public ConsultantResponseDto getConsultantsByEmail(@PathVariable String email) {
        return consultantService.getConsultantByEmail(email);
    }
}
