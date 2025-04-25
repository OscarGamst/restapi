package org.example.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class UserBasicDTO {
    private String username;
    private String email;
    private Boolean profile_vis;
}
