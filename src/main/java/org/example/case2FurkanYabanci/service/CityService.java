package org.example.case2FurkanYabanci.service;

import lombok.RequiredArgsConstructor;
import org.example.case2FurkanYabanci.converter.CityMapper;
import org.example.case2FurkanYabanci.dto.CityDto;
import org.example.case2FurkanYabanci.dto.request.CitySaveRequestDto;
import org.example.case2FurkanYabanci.exception.GenErrorMessage;
import org.example.case2FurkanYabanci.exception.ItemNotFoundException;
import org.example.case2FurkanYabanci.model.City;
import org.example.case2FurkanYabanci.model.Country;
import org.example.case2FurkanYabanci.repository.CityRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CountryService countryService;

    public CityDto save(CitySaveRequestDto citySaveRequestDto){
        Country country = countryService.getById(citySaveRequestDto.getCountry().getId());
        City city = CityMapper.INSTANCE.convertToCity(citySaveRequestDto);
        city.setCountry(country);
        cityRepository.save(city);
        CityDto cityDto = CityMapper.INSTANCE.convertToCityDto(city);
        return cityDto;
    }

    public City getById(long id){
        return cityRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(GenErrorMessage.CITY_NOT_FOUND));
    }

    public CityDto getCityByPlateCode(String plateCode){
        City city = cityRepository.getCityByPlateCode(plateCode);
        CityDto cityDto = CityMapper.INSTANCE.convertToCityDto(city);
        return cityDto;
    }
}
