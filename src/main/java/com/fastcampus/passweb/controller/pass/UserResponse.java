package com.fastcampus.passweb.controller.pass;

import com.fastcampus.passweb.repository.user.UserStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class UserResponse {
    private String userId;
    private String userName;
    private UserStatus status;
}
