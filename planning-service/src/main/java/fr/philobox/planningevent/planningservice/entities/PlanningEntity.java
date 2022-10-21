package fr.philobox.planningevent.planningservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PlanningEntity {
    @Id
    private String id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private List<MeetEntity> meetEntityList;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    private ConsultantEntity consultantEntity;


}
