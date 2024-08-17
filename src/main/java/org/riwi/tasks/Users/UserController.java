package org.riwi.tasks.Users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/users")
    public UsersDto create(
            @RequestBody UsersDto userDto
    ){
        return userService.create(userDto);
    }

    @PutMapping("/update")
    public UsersDto update(
            @RequestBody UsersDto userDto
    ){
        return userService.update(userDto);
    }

    /*@PutMapping("/update/{id}")
    public UsersDto updateById(
            @PathVariable("user-id") Integer id
    ){
        return userService.updateById(id);
    }*/


    @GetMapping("/users/{user-id}")
    public UsersDto findUserById(
            @PathVariable("user-id") Integer id
    ) {
        return userService.findUserById(id);
    }

    @GetMapping("/users")
    public String findAllUsers(Model model){
        List<UsersDto> usersDtos = userService.findAllUsers();
        model.addAttribute("usersDtos", usersDtos);
        return "usersDtos/index";
    }

    @GetMapping("/users/search/{user-name}")
    public List<UsersDto> findUsersByName(
            @PathVariable("user-name") String name
    ){
        return userService.findUsersByName(name);
    }

    @DeleteMapping("users/{user-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("user-id") Integer id
    ){
        userService.delete(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ) {
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
