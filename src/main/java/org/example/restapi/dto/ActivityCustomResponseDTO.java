package org.example.restapi.dto;

import org.example.restapi.model.ActivityCustom;

import java.time.LocalDateTime;

// Custom DTO
public class ActivityCustomResponseDTO extends BaseActivityResponseDTO {
    private String test;

    public ActivityCustomResponseDTO(long id, String type, String title, String description, int duration, int calories, LocalDateTime timestamp, String username, String test) {
        super(id, type, title, description, duration, calories, timestamp, username);
        this.test = test;
    }
}
