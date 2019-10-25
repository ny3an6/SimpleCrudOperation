package com.ndmitrenko.dinosystemsrestapi.controller;

import com.ndmitrenko.dinosystemsrestapi.dto.response.exception.DefaultExceptionResponse;
import com.ndmitrenko.dinosystemsrestapi.dto.response.user.UserDto;
import com.ndmitrenko.dinosystemsrestapi.exception.DefaultException;
import com.ndmitrenko.dinosystemsrestapi.model.User;
import com.ndmitrenko.dinosystemsrestapi.repository.UserRepository;
import com.ndmitrenko.dinosystemsrestapi.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Show All")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
    })
    @GetMapping("/showUsers")
    public List<UserDto> getAllUsers(){
       return userService.getAllUsers();
    }

    @GetMapping("/showUser/{firstName}")
    public List<UserDto> getUser(@PathVariable String firstName){
        return userService.getUser(firstName);
    }

    @PostMapping("/create")
    public UserDto addUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/edit/{secondName}")
    public UserDto editUser(@PathVariable String secondName, @Valid @RequestBody User user){
        return userService.editUserInformation(secondName, user);
    }

    @DeleteMapping("/delete/{secondName}")
    public DefaultExceptionResponse deleteUser(@PathVariable String secondName){
        return userService.deleteUser(secondName);
    }
}
