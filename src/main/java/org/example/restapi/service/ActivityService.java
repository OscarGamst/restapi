package org.example.restapi.service;

import org.example.restapi.model.Activity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ActivityService {

    // ----------------- ALL GETS -----------------
    Activity getActivityById(Long id);

    // ----------------- ALL CREATE -----------------
    void createActivity(Activity activity);

    // ----------------- ALL CREATE -----------------



}