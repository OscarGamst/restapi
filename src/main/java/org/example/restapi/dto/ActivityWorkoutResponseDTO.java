package org.example.restapi.dto;

import org.example.restapi.model.ActivityWorkout;

// Workout DTO
public class ActivityWorkoutResponseDTO extends BaseActivityResponseDTO {
    private int sets;
    private int reps;
    private int weight;

    public ActivityWorkoutResponseDTO(ActivityWorkout workout) {
        super(workout.getId(), workout.getType(), workout.getTitle(), workout.getDescription(),
                workout.getDuration(), workout.getCalories(), workout.getTimestamp(), workout.getUser().getUsername());
        this.sets = workout.getSets();
        this.reps = workout.getReps();
        this.weight = workout.getWeight();
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public int getWeight() {
        return weight;
    }
}
