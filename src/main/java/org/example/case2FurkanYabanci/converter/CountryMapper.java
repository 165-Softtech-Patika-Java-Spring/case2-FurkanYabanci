package org.example.case2FurkanYabanci.converter;

import org.example.case2FurkanYabanci.dto.CountryDto;
import org.example.case2FurkanYabanci.dto.request.CountrySaveRequestDto;
import org.example.case2FurkanYabanci.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    CountryDto convertToCountryDto(Country country);
   // List<CountryDto> convertToCountryDtoList(List<Country> countries);
    Country convertToCountry(CountrySaveRequestDto countrySaveRequestDto);
}
