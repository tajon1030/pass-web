package com.fastcampus.passweb.service.pass;


import com.fastcampus.passweb.repository.pass.BulkPass;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BulkPassMapper {
    BulkPassMapper INSTANCE = Mappers.getMapper(BulkPassMapper.class);

    BulkPassResponse map(BulkPass bulkPass);

    List<BulkPassResponse> map(List<BulkPass> bulkPass);


}
