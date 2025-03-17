package org.example.restapi.service;

import org.example.restapi.model.Activity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ActivityService {
    //  ------------------ GET------------------
    List<Activity> getAllActivities();
    List<Activity> getActivitiesByType(String type);
    List<Activity> getActivitiesByUsername(String username);
    Activity getActivityById(Long id);

    //  ------------------ SAVE ------------------
    Activity saveActivity(Activity activity);

    //  ------------------ DELETE ------------------
    void deleteActivity(Long id);

    //  ------------------ PUT ------------------
    Activity updateActivity(long id, Activity activity);
}