package org.example.case2FurkanYabanci.service;

import lombok.RequiredArgsConstructor;
import org.example.case2FurkanYabanci.converter.DistrictMapper;
import org.example.case2FurkanYabanci.dto.DistrictDto;
import org.example.case2FurkanYabanci.dto.request.DistrictSaveRequestDto;
import org.example.case2FurkanYabanci.exception.GenErrorMessage;
import org.example.case2FurkanYabanci.exception.ItemNotFoundException;
import org.example.case2FurkanYabanci.model.City;
import org.example.case2FurkanYabanci.model.District;
import org.example.case2FurkanYabanci.repository.DistrictRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictService {

    private final DistrictRepository districtRepository;
    private final CityService cityService;

    public DistrictDto save(DistrictSaveRequestDto districtSaveRequestDto){
        City city = cityService.getById(districtSaveRequestDto.getCity().getId());
        District district = DistrictMapper.INSTANCE.convertToDistrict(districtSaveRequestDto);
        district.setCity(city);
        districtRepository.save(district);
        DistrictDto districtDto = DistrictMapper.INSTANCE.convertToDistrictDto(district);
        return districtDto;
    }

    public District getById(long id){
        return districtRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(GenErrorMessage.DISTRICT_NOT_FOUND));
    }

    public List<DistrictDto> getDistrictByCityId(long cityId){
        List<District> districts = districtRepository.getDistrictByCityId(cityId);
        List<DistrictDto> districtDtoList = DistrictMapper.INSTANCE.convertToDistrictDtoList(districts);
        return districtDtoList;
    }
}
