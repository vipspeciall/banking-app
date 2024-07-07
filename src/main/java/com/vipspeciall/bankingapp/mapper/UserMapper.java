package com.vipspeciall.bankingapp.mapper;

import com.vipspeciall.bankingapp.dto.UserDTO;
import com.vipspeciall.bankingapp.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface UserMapper {

    User userDTOToUser(UserDTO userDTO);
    UserDTO userToUserDTO(User user);
}
