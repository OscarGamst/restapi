package org.example.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBasicDTO {
    private String username;
    private String email;
    private Date birthday;
}
