package org.example.restapi.controller;

import org.example.restapi.dto.ActivityResponseDTO;
import org.example.restapi.dto.CreateActivityRequest;
import org.example.restapi.model.*;
import org.example.restapi.repository.UserRepository;
import org.example.restapi.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/activity")
public class ActivityController {

    @Autowired
    private final ActivityService activityService;

    @Autowired
    private UserRepository userRepository;


    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    // ----------------- ALL GETS -----------------
    @GetMapping("/{id}")
    public ResponseEntity<ActivityResponseDTO> getActivityById(@PathVariable Long id) {
        // Fetch the activity by ID
        Activity activity = activityService.getActivityById(id);

        if (activity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Convert Activity to ActivityResponseDTO
        ActivityResponseDTO response = new ActivityResponseDTO(
                activity.getId(),
                activity.getType(),
                activity.getTitle(),
                activity.getDescription(),
                activity.getDuration(),
                activity.getCalories(),
                activity.getTimestamp(),
                activity.getUser().getUsername()// Only include the username
        );
        // Add specific fields based on the activity type
        if (activity instanceof ActivityRun) {
            ActivityRun run = (ActivityRun) activity;
            response.setDistance(run.getDistance());  // Set the distance for ActivityRun
        } else if (activity instanceof ActivityWorkout) {
            ActivityWorkout workout = (ActivityWorkout) activity;
            response.setSets(workout.getSets());
            response.setReps(workout.getReps());
            response.setWeight(workout.getWeight());
        }



        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    // ----------------- ALL POSTS -----------------

    @PostMapping
    public ResponseEntity<ActivityResponseDTO> createActivity(@RequestBody CreateActivityRequest request) {
        User user = userRepository.findById(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Activity activity;
        switch (request.getType()) {
            case "run":
                ActivityRun run = new ActivityRun();
                run.setDistance(request.getDistance() != null ? request.getDistance() : 0);
                activity = run;
                break;
            case "workout":
                ActivityWorkout workout = new ActivityWorkout();
                workout.setSets(request.getSets() != null ? request.getSets() : 0);
                workout.setReps(request.getReps() != null ? request.getReps() : 0);
                workout.setWeight(request.getWeight() != null ? request.getWeight() : 0);
                activity = workout;
                break;
            default:
                activity = new ActivityCustom();
        }

        //activity.setType(request.getType());
        activity.setTitle(request.getTitle());
        activity.setDescription(request.getDescription());
        activity.setDuration(request.getDuration());
        activity.setCalories(request.getCalories());
        activity.setUser(user);

        activityService.createActivity(activity);

        ActivityResponseDTO response = new ActivityResponseDTO(
                activity.getId(),
                activity.getType(),
                activity.getTitle(),
                activity.getDescription(),
                activity.getDuration(),
                activity.getCalories(),
                activity.getTimestamp(),
                user.getUsername()
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // ----------------- ALL DELETES -----------------

    // ----------------- ALL UPDATES -----------------
}


