package com.fastcampus.passweb.service.user;

import com.fastcampus.passweb.controller.pass.UserResponse;
import com.fastcampus.passweb.repository.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponse map(User user);
}
