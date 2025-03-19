package org.example.restapi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserAdvancedDTO {
    private String username;
    private String password;
    private String email;
    private Date birthday;
    private Boolean profile_vis;
}
