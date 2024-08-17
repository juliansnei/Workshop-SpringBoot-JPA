package org.riwi.tasks.Tasks;

import java.time.LocalDate;
import java.time.LocalTime;

public record TaskResponseDto(
        String title,
        String description,
        LocalDate creationDate,
        LocalTime creationTime,
        String state
) {
}
