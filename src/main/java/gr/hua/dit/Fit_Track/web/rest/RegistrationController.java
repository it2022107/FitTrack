package gr.hua.dit.Fit_Track.web.rest;


import gr.hua.dit.Fit_Track.core.model.Trainer.Trainer;
import gr.hua.dit.Fit_Track.core.model.Type;
import gr.hua.dit.Fit_Track.core.repository.TrainerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ResistrationController {

    final TrainerRepository trainerRepository;

    public ResistrationController(TrainerRepository trainerRepository) {
        if(trainerRepository == null) throw new NullPointerException("trainerRepository is null");
        this.trainerRepository = trainerRepository;
    }

    /**
     *
     * serves the registration form for a trainer
     */
    @GetMapping("/register/trainer")
    public String showResistrationTrainer(final Model model) {
        //Initial Data For The Form
        model.addAttribute("trainer", new Trainer(null,null,"",
                "",0, Type.TRAINER,"",
                "","","",""));
        return "registerTrainer"; // name of template
    }

    /**
     *
     * handles the registration form submission (POST HTTP REQUEST)
     */

    @PostMapping("/register/trainer")
    public String handleResistrationTrainer(
            @ModelAttribute("trainer")  Trainer trainer,
            final Model model
            ) {
        System.out.println(trainer.toString()); //pre save
        trainer = this.trainerRepository.save(trainer);
        System.out.println(trainer.toString()); //post save
        model.addAttribute("trainer", trainer);
        return "redirect:/login";
    }

}
