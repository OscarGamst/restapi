package org.example.restapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "activity_run")
@DiscriminatorValue("run")
public class ActivityRun extends Activity {

    @Column(name = "distance")
    private Integer distance;

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
