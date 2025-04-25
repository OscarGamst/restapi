package org.example.restapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "activity_run")
@DiscriminatorValue("run")
public class ActivityRun extends Activity {

    @Column(name = "distance")
    private int distance;

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
