package org.example.case2FurkanYabanci.converter;

import org.example.case2FurkanYabanci.dto.AddressDto;
import org.example.case2FurkanYabanci.dto.request.AddressSaveRequestDto;
import org.example.case2FurkanYabanci.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDto convertToAddressDto(Address address);
    List<AddressDto> convertToAddressDtoList(List<Address> addresses);
    Address convertToAddress(AddressSaveRequestDto addressSaveRequestDto);
}
