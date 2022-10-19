package fr.philobox.planningevent.consultantservice.dtos;

import fr.philobox.planningevent.consultantservice.ShiftEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ConsultantResponseDto {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private ShiftEnum shift;
}
