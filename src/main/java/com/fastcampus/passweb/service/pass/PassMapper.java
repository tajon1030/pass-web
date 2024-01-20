package com.fastcampus.passweb.service.pass;


import com.fastcampus.passweb.controller.pass.PassResponse;
import com.fastcampus.passweb.repository.pass.Pass;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PassMapper {
    PassMapper INSTANCE = Mappers.getMapper(PassMapper.class);

    @Mapping(target = "packageName", source = "packaze.packageName")
    PassResponse map(Pass pass);

    List<PassResponse> map(List<Pass> pass);


}
