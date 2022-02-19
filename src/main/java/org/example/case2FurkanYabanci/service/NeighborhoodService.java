package org.example.case2FurkanYabanci.service;

import lombok.RequiredArgsConstructor;
import org.example.case2FurkanYabanci.converter.NeighborhoodMapper;
import org.example.case2FurkanYabanci.dto.NeighborhoodDto;
import org.example.case2FurkanYabanci.dto.request.NeighborhoodSaveRequestDto;
import org.example.case2FurkanYabanci.dto.request.NeighborhoodUpdateRequestDto;
import org.example.case2FurkanYabanci.exception.GenErrorMessage;
import org.example.case2FurkanYabanci.exception.ItemNotFoundException;
import org.example.case2FurkanYabanci.model.District;
import org.example.case2FurkanYabanci.model.Neighborhood;
import org.example.case2FurkanYabanci.repository.NeighborhoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NeighborhoodService {

    private final NeighborhoodRepository neighborhoodRepository;
    private final DistrictService districtService;

    public NeighborhoodDto save(NeighborhoodSaveRequestDto neighborhoodSaveRequestDto){
        District district = districtService.getById(neighborhoodSaveRequestDto.getDistrict().getId());
        Neighborhood neighborhood = NeighborhoodMapper.INSTANCE.convertToNeighborhood(neighborhoodSaveRequestDto);
        neighborhood.setDistrict(district);
        neighborhoodRepository.save(neighborhood);
        NeighborhoodDto neighborhoodDto = NeighborhoodMapper.INSTANCE.convertToNeighborhoodDto(neighborhood);
        return neighborhoodDto;
    }

    public Neighborhood getById(long id){
        return neighborhoodRepository.getById(id);
    }

    public List<NeighborhoodDto> getNeighborhoodByDistrictId(long districtId){
        List<Neighborhood> neighborhoodList = neighborhoodRepository.getNeighborhoodByDistrictId(districtId);
        List<NeighborhoodDto> neighborhoodDtoList = NeighborhoodMapper.INSTANCE.convertToNeighborhoodDtoList(neighborhoodList);
        return neighborhoodDtoList;
    }

    public NeighborhoodDto update(NeighborhoodUpdateRequestDto neighborhoodUpdateRequestDto){
        controlIsNeighborhoodExist(neighborhoodUpdateRequestDto);
        District district = districtService.getById(neighborhoodUpdateRequestDto.getDistrict().getId());
        Neighborhood neighborhood = NeighborhoodMapper.INSTANCE.convertToNeighborhood(neighborhoodUpdateRequestDto);
        neighborhood.setDistrict(district);
        neighborhoodRepository.save(neighborhood);
        NeighborhoodDto neighborhoodDto = NeighborhoodMapper.INSTANCE.convertToNeighborhoodDto(neighborhood);
        return neighborhoodDto;
    }

    private void controlIsNeighborhoodExist(NeighborhoodUpdateRequestDto neighborhoodUpdateRequestDto){
        long id = neighborhoodUpdateRequestDto.getId();
        boolean isExist = neighborhoodRepository.existsById(id);
        if (!isExist){
            throw new ItemNotFoundException(GenErrorMessage.NEIGHBORHOOD_NOT_FOUND);
        }
    }
}
