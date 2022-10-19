package fr.philobox.planningevent.consultantservice;

import fr.philobox.planningevent.consultantservice.dtos.ConsultantRequestDto;
import fr.philobox.planningevent.consultantservice.entities.ConsultantEntity;
import fr.philobox.planningevent.consultantservice.repositories.ConsultantRepository;
import fr.philobox.planningevent.consultantservice.services.ConsultantService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ConsultantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsultantServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(ConsultantRepository consultantRepository) {
        return args -> {
            Stream.of("John", "Johanna", "Alex").forEach(name -> {
                ConsultantEntity consultantRequestDto = new ConsultantEntity(UUID.randomUUID().toString(), name, name, name+"@mail.com",0, ShiftEnum.COLLECTIVE);
                consultantRepository.save(consultantRequestDto);
            });
            Stream.of("Jade", "Leona", "Camille").forEach(name -> {
                ConsultantEntity consultantRequestDto = new ConsultantEntity(UUID.randomUUID().toString(), name, name, name+"@mail.com",0, ShiftEnum.INDIVIDUAL);
                consultantRepository.save(consultantRequestDto);
            });
            Stream.of("Alexia", "Rachid", "Diana").forEach(name -> {
                ConsultantEntity consultantRequestDto = new ConsultantEntity(UUID.randomUUID().toString(), name, name, name+"@mail.com",0, ShiftEnum.BOTH);
                consultantRepository.save(consultantRequestDto);
            });
        };
    }

}
