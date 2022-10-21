package fr.philobox.planningevent.consultantservice.dtos;

import fr.philobox.planningevent.consultantservice.entities.enums.ShiftEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ConsultantResponseDto {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private int timeCounter;
    private ShiftEnum shift;
}
