package fr.philobox.planningevent.consultantservice.entities;

import fr.philobox.planningevent.consultantservice.entities.enums.ShiftEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultantEntity {

    @Id
    private String id;

    @NotNull
    @Size(min = 5, message = "{validation.name.size.too_short}")
    private String firstname;

    @NotNull
    @Size(min = 5, message = "{validation.name.size.too_short}")
    private String lastname;

    @NotNull
    @Size(min = 5, message = "{validation.name.size.too_short}")
    private String email;

    @NotNull
    private int timeCounter = 0;

    private ShiftEnum shiftEnum;
}
