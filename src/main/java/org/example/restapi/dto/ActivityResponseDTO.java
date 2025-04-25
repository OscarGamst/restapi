package org.example.restapi.dto;

import java.time.LocalDateTime;

public class ActivityResponseDTO {
    private long id;
    private String type;
    private String title;
    private String description;
    private int duration;
    private int calories;
    private LocalDateTime timestamp;
    private String username;

    //run
    private Integer distance;

    //workout
    private Integer sets;
    private Integer reps;
    private Integer weight;

    //custom
    private String test;

    public ActivityResponseDTO(long id, String type, String title, String description, int duration, int calories, LocalDateTime timestamp, String username) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.calories = calories;
        this.timestamp = timestamp;
        this.username = username;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
