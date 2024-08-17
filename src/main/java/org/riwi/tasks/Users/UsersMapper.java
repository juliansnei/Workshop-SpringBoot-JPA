package org.riwi.tasks.Users;

import org.springframework.stereotype.Service;

@Service
public class UsersMapper {

    public UserEntity toUser(UsersDto userDto) {
        return new UserEntity(userDto.name(),
                userDto.email());
    }

    public UsersDto toUserDto(UserEntity user){
        return new UsersDto(user.getName(), user.getEmail());
    }
}
