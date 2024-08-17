package org.riwi.tasks.Users;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UsersMapper usersMapper;
    private final UserRepository userRepository;

    public UserService(UsersMapper usersMapper, UserRepository userRepository) {
        this.usersMapper = usersMapper;
        this.userRepository = userRepository;
    }

    public UsersDto create(UsersDto userDto
    ){
        var user = usersMapper.toUser(userDto);
        userRepository.save(user);
        return userDto;
    }

    public UsersDto update(UsersDto userDto){
        var user = usersMapper.toUser(userDto);
        userRepository.save(user);
        return userDto;
    }

   /* public UsersDto updateById(Integer id){
        var userFound = findUserById(id);
        userRepository.save(userFound);
        return userFound;
    }*/

    public List<UsersDto> findAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(usersMapper::toUserDto)
                .collect(Collectors.toList());
    }

    public UsersDto findUserById(Integer id
    ) {
        return userRepository.findById(id)
                .map(usersMapper::toUserDto)
                .orElse(null);
    }

    public List<UsersDto> findUsersByName(String name
    ){
        return userRepository.findAllByNameContaining(name)
                .stream()
                .map(usersMapper::toUserDto)
                .collect(Collectors.toList());
    }

    public void delete(Integer id
    ){
        userRepository.deleteById(id);
    }
}
