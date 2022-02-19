package org.example.case2FurkanYabanci.converter;

import org.example.case2FurkanYabanci.dto.NeighborhoodDto;
import org.example.case2FurkanYabanci.dto.request.NeighborhoodSaveRequestDto;
import org.example.case2FurkanYabanci.dto.request.NeighborhoodUpdateRequestDto;
import org.example.case2FurkanYabanci.model.Neighborhood;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NeighborhoodMapper {

    NeighborhoodMapper INSTANCE = Mappers.getMapper(NeighborhoodMapper.class);

    NeighborhoodDto convertToNeighborhoodDto(Neighborhood neighborhood);
    List<NeighborhoodDto> convertToNeighborhoodDtoList(List<Neighborhood> neighborhoods);
    Neighborhood convertToNeighborhood(NeighborhoodSaveRequestDto neighborhoodSaveRequestDto);
    Neighborhood convertToNeighborhood(NeighborhoodUpdateRequestDto neighborhoodUpdateRequestDto);
}
