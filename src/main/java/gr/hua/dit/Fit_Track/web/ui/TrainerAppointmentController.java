package gr.hua.dit.Fit_Track.web.ui;


import gr.hua.dit.Fit_Track.core.model.Trainer.Trainer;
import gr.hua.dit.Fit_Track.core.model.Trainer.TrainerView;
import gr.hua.dit.Fit_Track.core.model.TrainerFunctionality.Appointment;
import gr.hua.dit.Fit_Track.core.repository.ApointmentRepository;
import gr.hua.dit.Fit_Track.core.service.impl.AppointmentServiceImpl;
import gr.hua.dit.Fit_Track.core.service.mapper.TrainerMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TrainerAppointmentController {

    private AppointmentServiceImpl appointmentService;


    @GetMapping("/trainerAppointment")
    public String trainerAppointment(
            @RequestParam("gym_id") String trainer_id,
            Model model
            ) {
           List<Appointment> appointmentList = this.appointmentService.findByTrainer_Id(trainer_id);
           model.addAttribute("appointmentList", appointmentList);
           return "trainerAppointment";
    }

}
