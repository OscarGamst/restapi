package org.example.restapi.dto;

import org.example.restapi.model.ActivityRun;

// Run DTO
public class ActivityRunResponseDTO extends BaseActivityResponseDTO {
    private int distance;

    public ActivityRunResponseDTO(ActivityRun run) {
        super(run.getId(), run.getType(), run.getTitle(), run.getDescription(),
                run.getDuration(), run.getCalories(), run.getTimestamp(), run.getUser().getUsername());
        this.distance = run.getDistance();
    }

    public int getDistance() {
        return distance;
    }
}
