package org.example.restapi.controller;

import org.example.restapi.model.Activity;
import org.example.restapi.service.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/activities")
public class ActivityController {
    private final ActivityService activityService;


    // Constructor
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    //  ------------------ GET ------------------
    //  ---------INSERT ALL GETTERS HERE---------

    @GetMapping()
    public List<Activity> getActivities() {
        return activityService.getAllActivities();
    }

    @GetMapping("/type/{type}")
    public List<Activity> getActivitiesByType(@PathVariable String type) {
        return activityService.getActivitiesByType(type);
    }

    @GetMapping("/username/{username}")
    public List<Activity> getActivitiesByUsername(@PathVariable String username) {
        return activityService.getActivitiesByUsername(username);
    }

    @GetMapping("/{id}")
    public Activity getActivityById(@PathVariable Long id) {
        return activityService.getActivityById(id);
    }

    //  ------------------ POST ------------------
    //  ---------INSERT ALL POSTERS HERE----------

    @PostMapping
    public ResponseEntity<Activity> addActivity(@RequestBody Activity activity) {
        Activity savedActivity = activityService.saveActivity(activity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedActivity);
    }



    //  ------------------ DELETE ------------------
    //  ---------INSERT ALL DELETES HERE------------
    @DeleteMapping("/{id}")
    public void deleteActivityById(@PathVariable Long id) {
        activityService.deleteActivity(id);
    }

    //  ------------------ PUT ------------------
    //  ---------INSERT ALL PUTTERS HERE---------
    @PutMapping("/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable long id, @RequestBody Activity updatedactivity) {
        try {
            Activity activity = activityService.updateActivity(id, updatedactivity);
            return new ResponseEntity<>(activity, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
