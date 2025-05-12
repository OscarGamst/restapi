package org.example.restapi.mapper;

import org.example.restapi.dto.UserBasicDTO;
import org.example.restapi.dto.UserDetailedDTO;
import org.example.restapi.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserBasicDTO userToUserBasicDTO(User user);
    UserDetailedDTO userToUserDetailedDTO(User user);

    List<UserBasicDTO> usersToUserBasicDTOs(List<User> users);
    List<UserDetailedDTO> usersToUserDetailedDTOs(List<User> users);


}
