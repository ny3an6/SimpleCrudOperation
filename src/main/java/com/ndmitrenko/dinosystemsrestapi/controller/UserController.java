package com.ndmitrenko.dinosystemsrestapi.controller;

import com.ndmitrenko.dinosystemsrestapi.dto.response.exception.DefaultExceptionResponse;
import com.ndmitrenko.dinosystemsrestapi.dto.response.user.UserDto;
import com.ndmitrenko.dinosystemsrestapi.model.User;
import com.ndmitrenko.dinosystemsrestapi.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Show All users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
    })
    @GetMapping("/showUsers") // Show all existing user
    public List<UserDto> getAllUsers(){
       return userService.getAllUsers();
    }

    @ApiOperation(value = "Show user by firstName")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
    })
    @GetMapping("/showUser/{firstName}") // show user by firstName
    public List<UserDto> getUser(@PathVariable String firstName){
        return userService.getUser(firstName);
    }

    @ApiOperation(value = "Create user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
    })
    @PostMapping("/create") // Create new user
    public UserDto addUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @ApiOperation(value = "Edit user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "editing was successful"),
    })
    @PutMapping("/edit/{secondName}") //Edit user Information
    public UserDto editUser(@PathVariable String secondName, @Valid @RequestBody User user){
        return userService.editUserInformation(secondName, user);
    }

    @ApiOperation(value = "Delete user by second name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "deleting was successful"),
    })
    @DeleteMapping("/delete/{secondName}") // delete user by secondName
    public DefaultExceptionResponse deleteUser(@PathVariable String secondName){
        return userService.deleteUser(secondName);
    }
}
