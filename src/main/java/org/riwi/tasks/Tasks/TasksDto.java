package org.riwi.tasks.Tasks;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.time.LocalTime;

public record TasksDto(
        @NotEmpty
        String title,
        @NotEmpty
        String description,
        LocalDate creationDate,
        LocalTime creationTime,
        String state,
        Integer id_user
) {
}
