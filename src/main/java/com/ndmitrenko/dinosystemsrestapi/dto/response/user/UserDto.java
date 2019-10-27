package com.ndmitrenko.dinosystemsrestapi.dto.response.user;

import com.ndmitrenko.dinosystemsrestapi.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class UserDto {

    private String firstName;
    private String secondName;
    private Date datOfBirth;
    private String address;

    public static UserDto toDto(User user){
        return UserDto.builder()
                .firstName(user.getFirstName())
                .secondName(user.getSecondName())
                .datOfBirth(user.getDateOfBirth())
                .address(user.getAddress())
                .build();
    }
    public static List<UserDto> toDto(List<User> users) {
        return users.stream().map(UserDto::toDto).collect(Collectors.toList());
    }
}
