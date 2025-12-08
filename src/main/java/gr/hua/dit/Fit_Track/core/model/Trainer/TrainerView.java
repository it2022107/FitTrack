package gr.hua.dit.Fit_Track.core.model;

/**
 *
 * DTO for returning a trainer from the db to the user
 *
 */


public record TrainerView(
        String firstName,
        String lastName,
        int age,
        String emailAddress,
        String mobilePhoneNumber,
        String specialization,
        String area
) {
}
