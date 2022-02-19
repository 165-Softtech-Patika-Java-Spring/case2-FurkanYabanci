package org.example.case2FurkanYabanci.converter;

import org.example.case2FurkanYabanci.dto.StreetDto;
import org.example.case2FurkanYabanci.dto.request.StreetSaveRequestDto;
import org.example.case2FurkanYabanci.dto.request.StreetUpdateRequestDto;
import org.example.case2FurkanYabanci.model.Street;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StreetMapper {

    StreetMapper INSTANCE = Mappers.getMapper(StreetMapper.class);

    StreetDto convertToStreetDto(Street street);
    List<StreetDto> convertToStreetDtoList(List<Street> streets);
    Street convertToStreet(StreetSaveRequestDto streetSaveRequestDto);
    Street convertToStreet(StreetUpdateRequestDto streetUpdateRequestDto);
}
