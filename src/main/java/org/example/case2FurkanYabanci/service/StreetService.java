package org.example.case2FurkanYabanci.service;

import lombok.RequiredArgsConstructor;

import org.example.case2FurkanYabanci.converter.StreetMapper;
import org.example.case2FurkanYabanci.dto.StreetDto;
import org.example.case2FurkanYabanci.dto.request.StreetSaveRequestDto;
import org.example.case2FurkanYabanci.dto.request.StreetUpdateRequestDto;
import org.example.case2FurkanYabanci.exception.GenErrorMessage;
import org.example.case2FurkanYabanci.exception.ItemNotFoundException;
import org.example.case2FurkanYabanci.model.Neighborhood;
import org.example.case2FurkanYabanci.model.Street;
import org.example.case2FurkanYabanci.repository.StreetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StreetService {

    private final StreetRepository streetRepository;
    private final NeighborhoodService neighborhoodService;

    public StreetDto save(StreetSaveRequestDto streetSaveRequestDto){
        Neighborhood neighborhood = neighborhoodService.getById(streetSaveRequestDto.getNeighborhood().getId());
        Street street = StreetMapper.INSTANCE.convertToStreet(streetSaveRequestDto);
        street.setNeighborhood(neighborhood);
        streetRepository.save(street);
        StreetDto streetDto = StreetMapper.INSTANCE.convertToStreetDto(street);
        return streetDto;
    }

    public List<StreetDto> getStreetByNeighborhoodId(long neighborhoodId){
        List<Street> streetList = streetRepository.getStreetByNeighborhoodId(neighborhoodId);
        List<StreetDto> streetDtoList = StreetMapper.INSTANCE.convertToStreetDtoList(streetList);
        return streetDtoList;
    }

    public StreetDto update(StreetUpdateRequestDto streetUpdateRequestDto){
        controlIsStreetExist(streetUpdateRequestDto);
        Neighborhood neighborhood = neighborhoodService.getById(streetUpdateRequestDto.getNeighborhood().getId());
        Street street = StreetMapper.INSTANCE.convertToStreet(streetUpdateRequestDto);
        street.setNeighborhood(neighborhood);
        streetRepository.save(street);
        StreetDto streetDto = StreetMapper.INSTANCE.convertToStreetDto(street);
        return streetDto;
    }

    private void controlIsStreetExist(StreetUpdateRequestDto streetUpdateRequestDto){
        long id = streetUpdateRequestDto.getId();
        boolean isExist = streetRepository.existsById(id);
        if (!isExist){
            throw new ItemNotFoundException(GenErrorMessage.STREET_NOT_FOUND);
        }
    }
}
