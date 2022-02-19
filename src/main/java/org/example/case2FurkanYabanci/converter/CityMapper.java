package org.example.case2FurkanYabanci.converter;

import org.example.case2FurkanYabanci.dto.CityDto;
import org.example.case2FurkanYabanci.dto.request.CitySaveRequestDto;
import org.example.case2FurkanYabanci.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityMapper {

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    CityDto convertToCityDto(City city);
    List<CityDto> convertToCityDtoList(List<City> cities);
    City convertToCity(CitySaveRequestDto citySaveRequestDto);
}
