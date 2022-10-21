package fr.philobox.planningevent.planningservice.controllers;

import fr.philobox.planningevent.planningservice.dtos.PlanningResponseDto;
import fr.philobox.planningevent.planningservice.services.PlanningService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/planning")
@Controller
@AllArgsConstructor
public class PlanningController {
    private PlanningService planningService;

    @GetMapping(value = "/")
    public List<PlanningResponseDto> getAllPlanning() {
        return planningService.getPlannings();
    }
}
