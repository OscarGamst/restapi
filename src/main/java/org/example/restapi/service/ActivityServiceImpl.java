package org.example.restapi.service;

import org.example.restapi.model.Activity;
import org.example.restapi.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActivityServiceImpl implements org.example.restapi.service.ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    //  ------------------ GET ------------------
    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public List<Activity> getActivitiesByType(String type) {
        return activityRepository.findAllByType(type);
    }

    @Override
    public List<Activity> getActivitiesByUsername(String username) {
        return activityRepository.getActivitiesByUsername(username);
    }

    @Override
    public Activity getActivityById(Long id) {
        return activityRepository.findById(id).orElse(null);
    }

    //  ------------------ SAVE ------------------
    @Override
    public Activity saveActivity(Activity activity) {
        return activityRepository.save(activity);
    }


    //  ------------------ DELETE ------------------
    @Override
    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }

    //  ------------------ PUT ------------------
    public Activity updateActivity(long id, Activity updatedactivity) {
        return activityRepository.findById(id)
                .map(existingActivity -> {
                    existingActivity.setType(updatedactivity.getType());
                    existingActivity.setTitle(updatedactivity.getTitle());
                    existingActivity.setDescription(updatedactivity.getDescription());
                    existingActivity.setDuration(updatedactivity.getDuration());
                    return activityRepository.save(existingActivity);
                })
                .orElseThrow(() -> new RuntimeException("Activity not found"));
    }
}