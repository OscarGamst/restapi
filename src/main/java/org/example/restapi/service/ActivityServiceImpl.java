package org.example.restapi.service;

import org.example.restapi.model.Activity;
import org.example.restapi.model.User;
import org.example.restapi.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    // ----------------- ALL GETS -----------------
    @Override
    public Activity getActivityById(Long id) {
        return activityRepository.findById(id).orElse(null);
    }

    // ----------------- ALL CREATE -----------------

    @Override
    public void createActivity(Activity activity) {
        activityRepository.save(activity);
    }
}
