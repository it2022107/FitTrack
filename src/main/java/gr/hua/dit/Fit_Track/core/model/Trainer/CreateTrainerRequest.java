package gr.hua.dit.Fit_Track.core.model;

import java.time.Instant;

/**
 *
 * DTO for creating a trainer
 *
 */

public record CreateTrainerRequest(
        Long id,
        String firstName,
        String lastName,
        int age,
        String emailAddress,
        String mobilePhoneNumber,
        String password,
        String specialization,
        String area,
        Instant createdAt
) {
}
