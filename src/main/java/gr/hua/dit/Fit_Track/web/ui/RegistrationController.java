package gr.hua.dit.Fit_Track.web.rest;


import gr.hua.dit.Fit_Track.core.model.Trainer.CreateTrainerRequest;
import gr.hua.dit.Fit_Track.core.model.Trainer.CreateTrainerResult;
import gr.hua.dit.Fit_Track.core.repository.TrainerRepository;
import gr.hua.dit.Fit_Track.core.service.TrainerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
    final TrainerRepository trainerRepository;
    final TrainerService trainerService;

    public RegistrationController(TrainerRepository trainerRepository, TrainerService trainerService) {
        this.trainerService = trainerService;
        if(trainerRepository == null) throw new NullPointerException("trainerRepository is null");
        if(trainerService == null) throw new NullPointerException("trainerService is null");
        this.trainerRepository = trainerRepository;
    }

    /**
     *
     * serves the registration form for a trainer
     */
    @GetMapping("/register/trainer")
    public String showRegistrationTrainer(final Model model) {
        //Initial Data For The Form
        model.addAttribute("createTrainerRequest", new CreateTrainerRequest(
                null,
                null,
                null,
                0,
                "",
                "",
                "",
                "",
                ""));
        return "registerTrainer"; // name of template
    }

    /**
     *
     * handles the registration form submission (POST HTTP REQUEST)
     */

    @PostMapping("/register/trainer")
    public String handleRegistrationTrainer(
            @ModelAttribute("createTrainerRequest")  CreateTrainerRequest createTrainerRequest,
            final Model model
            ) {
        final CreateTrainerResult createTrainerResult = this.trainerService.createTrainer(createTrainerRequest);
        if(createTrainerResult.created()){
            logger.info("Trainer created, redirecting to login page", createTrainerRequest.lastName());
            return "redirect:/login"; //redirection successful -redirect to log in form
        }
        model.addAttribute("createTrainerRequest", createTrainerRequest); //Pass the same form data
        model.addAttribute("errorMessage", createTrainerResult.reason()); // show an error message
        logger.error("Failed to create trainer", createTrainerResult.reason());
        return "registerTrainer";

    }

}
