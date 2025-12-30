package gr.hua.dit.Fit_Track.web;

import gr.hua.dit.Fit_Track.core.model.Trainer.Trainer;
import gr.hua.dit.Fit_Track.core.model.Type;
import gr.hua.dit.Fit_Track.core.repository.TrainerRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;


@RestController
public class TestController {

    private final TrainerRepository trainerRepository;

    public TestController(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @GetMapping(value="test", produces=MediaType.TEXT_PLAIN_VALUE)
    public String test(){
        Trainer trainer = new Trainer();
        trainer.setFirstName("John");
        trainer.setLastName("Jones");
        trainer.setId(null); //auto generated
        trainer.setType(Type.TRAINER);
        trainer.setAge(20);
        trainer.setArea("L.A");
        trainer.setSpecialization("mma");
        trainer.setMobilePhoneNumber("69000000");
        trainer.setEmailAddress("JohnJones@gmail.com");
        trainer.setPasswordHash("password");
        trainer.setCreatedAt(Instant.now());

        trainer = this.trainerRepository.save(trainer);

        return trainer.toString();
    }

}
