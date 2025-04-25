package org.example.restapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserDetailedDTO {
    private String username;
    private String password;
    private String email;
    private Date birthday;
    private Boolean profile_vis;
}
