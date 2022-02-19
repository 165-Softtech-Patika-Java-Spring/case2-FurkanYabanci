package org.example.case2FurkanYabanci.converter;

import org.example.case2FurkanYabanci.dto.DistrictDto;
import org.example.case2FurkanYabanci.dto.request.DistrictSaveRequestDto;
import org.example.case2FurkanYabanci.model.District;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DistrictMapper {

    DistrictMapper INSTANCE = Mappers.getMapper(DistrictMapper.class);

    DistrictDto convertToDistrictDto(District district);
    List<DistrictDto> convertToDistrictDtoList(List<District> districts);
    District convertToDistrict(DistrictSaveRequestDto districtSaveRequestDto);
}
