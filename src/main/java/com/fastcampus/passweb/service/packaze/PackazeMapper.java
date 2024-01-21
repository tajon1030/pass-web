package com.fastcampus.passweb.service.packaze;

import com.fastcampus.passweb.controller.admin.PackazeResponse;
import com.fastcampus.passweb.repository.packaze.Packaze;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PackazeMapper {
    PackazeMapper INSTANCE = Mappers.getMapper(PackazeMapper.class);

    PackazeResponse map(Packaze packaze);

    List<PackazeResponse> map(List<Packaze> packaze);
}
