package org.example.case2FurkanYabanci.service;

import lombok.RequiredArgsConstructor;
import org.example.case2FurkanYabanci.converter.AddressMapper;
import org.example.case2FurkanYabanci.dto.AddressDto;
import org.example.case2FurkanYabanci.dto.request.AddressSaveRequestDto;
import org.example.case2FurkanYabanci.exception.GenErrorMessage;
import org.example.case2FurkanYabanci.exception.ItemNotFoundException;
import org.example.case2FurkanYabanci.model.Address;
import org.example.case2FurkanYabanci.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressDto save(AddressSaveRequestDto addressSaveRequestDto){
        Address address = AddressMapper.INSTANCE.convertToAddress(addressSaveRequestDto);
        addressRepository.save(address);
        AddressDto addressDto = AddressMapper.INSTANCE.convertToAddressDto(address);
        return addressDto;
    }

    public Address getByIdWithControl(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(GenErrorMessage.ADDRESS_NOT_FOUND));
    }

    public AddressDto getAddressById(long id){
        Address address = getByIdWithControl(id);
        AddressDto addressDto = AddressMapper.INSTANCE.convertToAddressDto(address);
        return addressDto;
    }

    public void delete(long id){
        Address address = getByIdWithControl(id);
        addressRepository.delete(address);
    }
}
