package fr.philobox.planningevent.planningservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MeetEntity {

    @Id
    private String id;

    @NotNull
    private int duration;

    private Date date;

    @NotNull
    @OneToMany(fetch = FetchType.EAGER)
    private PlanningEntity planningEntity;
}
