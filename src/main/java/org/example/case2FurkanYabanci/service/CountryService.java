package org.example.case2FurkanYabanci.service;

import lombok.RequiredArgsConstructor;
import org.example.case2FurkanYabanci.converter.CountryMapper;
import org.example.case2FurkanYabanci.dto.CountryDto;
import org.example.case2FurkanYabanci.dto.request.CountrySaveRequestDto;
import org.example.case2FurkanYabanci.exception.GenErrorMessage;
import org.example.case2FurkanYabanci.exception.ItemNotFoundException;
import org.example.case2FurkanYabanci.model.Country;
import org.example.case2FurkanYabanci.repository.CountryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryDto save(CountrySaveRequestDto countrySaveRequestDto){
        Country country = CountryMapper.INSTANCE.convertToCountry(countrySaveRequestDto);
        countryRepository.save(country);
        CountryDto countryDto = CountryMapper.INSTANCE.convertToCountryDto(country);
        return countryDto;
    }

    public Country getById(long id){
        return countryRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(GenErrorMessage.COUNTRY_NOT_FOUND));
    }

    public CountryDto getByCountryCode(String countryCode){
        Country country = countryRepository.getCountryByCountryCode(countryCode);
        CountryDto countryDto = CountryMapper.INSTANCE.convertToCountryDto(country);
        return countryDto;
    }
}
