package fr.philobox.planningevent.consultantservice.dtos;

import fr.philobox.planningevent.consultantservice.ShiftEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.mapstruct.Mapping;

@AllArgsConstructor
@Data
public class ConsultantRequestDto {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private int timeCounter;
    private ShiftEnum shift;
}
