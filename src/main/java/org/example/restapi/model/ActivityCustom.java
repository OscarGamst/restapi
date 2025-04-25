package org.example.restapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "activity_custom")
@DiscriminatorValue("custom")
public class ActivityCustom extends Activity {

    @Column(name = "test")
    private String test;
}
