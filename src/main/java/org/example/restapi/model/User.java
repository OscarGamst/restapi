package org.example.restapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "username", unique = true, nullable = false)
    private String username;


    @Column(name = "email")
    private String email;


    @Column(name = "password")
    private String password;


    @Column(name = "birthdate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthdate;


    @Column(name = "profile_vis")
    private boolean profile_vis;

    @OneToMany(mappedBy = "user")
    private List<Activity> activities;


    public User(String username, String email, String password, Date birthdate, boolean profile_vis) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
        this.profile_vis = profile_vis;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isProfile_vis() {
        return profile_vis;
    }

    public void setProfile_vis(boolean profile_vis) {
        this.profile_vis = profile_vis;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
