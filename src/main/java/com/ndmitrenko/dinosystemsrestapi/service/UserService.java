package com.ndmitrenko.dinosystemsrestapi.service;

import com.ndmitrenko.dinosystemsrestapi.dto.response.exception.DefaultExceptionResponse;
import com.ndmitrenko.dinosystemsrestapi.dto.response.user.UserDto;
import com.ndmitrenko.dinosystemsrestapi.exception.ApiResult;
import com.ndmitrenko.dinosystemsrestapi.exception.DefaultException;
import com.ndmitrenko.dinosystemsrestapi.model.User;
import com.ndmitrenko.dinosystemsrestapi.repository.UserRepository;
import com.ndmitrenko.dinosystemsrestapi.util.ToUpperCaseString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ndmitrenko.dinosystemsrestapi.dto.response.user.UserDto.toDto;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        System.out.println(users.isEmpty());
        if(!users.isEmpty()){
            return toDto(users);
        }else throw new DefaultException("There is no user");
    }

    public List<UserDto> getUser(String firstName){
        return toDto(userRepository.findByFirstName(firstName).orElseThrow(() -> new DefaultException("User not found")));
    }

    public UserDto createUser(User user){
        String firstName = ToUpperCaseString.toUpperCase(user.getFirstName().toLowerCase().trim());
        String secondName = ToUpperCaseString.toUpperCase(user.getSecondName().toLowerCase().trim());

        userRepository.findUserBySecondName(ToUpperCaseString.toUpperCase(secondName)).ifPresent(ex -> {
            throw new DefaultException(HttpStatus.UNPROCESSABLE_ENTITY, "User is already exist"); });

        if (firstName.isEmpty()){
            throw new DefaultException("Enter first name");
        }
        if(secondName.isEmpty()){
            throw new DefaultException("Enter second name");
        }
        if(user.getAddress().isEmpty()){
            throw new DefaultException("Enter user address");
        }
        if(user.getDateOfBirth() == null){
            throw new DefaultException("Enter date of birth name");
        }
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        userRepository.save(user);

        return toDto(user);
    }

    public UserDto editUserInformation(String secondName, User user){
        User userCandidate = userRepository.findUserBySecondName(secondName).orElseThrow(() ->
                new DefaultException(HttpStatus.NOT_FOUND, "User not found"));
        userCandidate.setFirstName(ToUpperCaseString.toUpperCase(user.getFirstName().trim()));
        userCandidate.setSecondName(ToUpperCaseString.toUpperCase(user.getSecondName().trim()));
        userCandidate.setAddress(user.getAddress());
        userCandidate.setDateOfBirth(user.getDateOfBirth());
        userRepository.save(userCandidate);
        return toDto(userCandidate);
    }

    public DefaultExceptionResponse deleteUser(String secondName){
        User userCandidate = userRepository.findUserBySecondName(secondName).orElseThrow(() ->
                new DefaultException(HttpStatus.NOT_FOUND, "User not found"));
        userRepository.delete(userCandidate);
        return new DefaultExceptionResponse(HttpStatus.ACCEPTED, "User has been successfully deleted", ApiResult.SUCCESS);
    }


}
