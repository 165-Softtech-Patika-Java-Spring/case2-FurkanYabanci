package org.example.case2FurkanYabanci.controller;

import lombok.RequiredArgsConstructor;
import org.example.case2FurkanYabanci.dto.*;
import org.example.case2FurkanYabanci.dto.request.*;
import org.example.case2FurkanYabanci.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final CountryService countryService;
    private final CityService cityService;
    private final DistrictService districtService;
    private final NeighborhoodService neighborhoodService;
    private final StreetService streetService;
    private final AddressService addressService;


    @GetMapping("/getAddress/{id}")
    public ResponseEntity<AddressDto> getAddress(@PathVariable long id){
        AddressDto addressDto = addressService.getAddressById(id);
        return ResponseEntity.ok(addressDto);
    }

    @GetMapping("/getCountry/{countryCode}")
    public ResponseEntity<CountryDto> getCountryByCountryCode(@PathVariable String countryCode){
        CountryDto countryDto = countryService.getByCountryCode(countryCode);
        return ResponseEntity.ok(countryDto);
    }

    @GetMapping("/getCity/{plateCode}")
    public ResponseEntity<CityDto> getCityByPlateCode(@PathVariable String plateCode){
        CityDto cityDto = cityService.getCityByPlateCode(plateCode);
        return ResponseEntity.ok(cityDto);
    }

    @GetMapping("/getDistrictList/{cityId}")
    public ResponseEntity<List<DistrictDto>> getDistrictByCityId(@PathVariable long cityId){
        List<DistrictDto> districtDtoList = districtService.getDistrictByCityId(cityId);
        return ResponseEntity.ok(districtDtoList);
    }

    @GetMapping("/getNeighborhoodList/{districtId}")
    public ResponseEntity<List<NeighborhoodDto>> getNeighborhoodByDistrictId(@PathVariable long districtId){
        List<NeighborhoodDto> neighborhoodDtoList = neighborhoodService.getNeighborhoodByDistrictId(districtId);
        return ResponseEntity.ok(neighborhoodDtoList);
    }

    @GetMapping("/getStreetList/{neighborhoodId}")
    public ResponseEntity<List<StreetDto>> getStreetByNeighborhoodId(@PathVariable long neighborhoodId){
        List<StreetDto> streetDtoList = streetService.getStreetByNeighborhoodId(neighborhoodId);
        return ResponseEntity.ok(streetDtoList);
    }

    @PostMapping("/saveCountry")
    public ResponseEntity<CountryDto> saveCountry(@RequestBody CountrySaveRequestDto countrySaveRequestDto) {
        CountryDto countryDto = countryService.save(countrySaveRequestDto);
        return ResponseEntity.ok(countryDto);
    }

    @PostMapping("/saveCity")
    public ResponseEntity<CityDto> saveCity(@RequestBody CitySaveRequestDto citySaveRequestDto) {
        CityDto cityDto = cityService.save(citySaveRequestDto);
        return ResponseEntity.ok(cityDto);
    }

    @PostMapping("/saveDistrict")
    public ResponseEntity<DistrictDto> saveDistrict(@RequestBody DistrictSaveRequestDto districtSaveRequestDto) {
        DistrictDto districtDto = districtService.save(districtSaveRequestDto);
        return ResponseEntity.ok(districtDto);
    }

    @PostMapping("/saveNeighborhood")
    public ResponseEntity<NeighborhoodDto> saveNeighborhood(@RequestBody NeighborhoodSaveRequestDto neighborhoodSaveRequestDto) {
        NeighborhoodDto neighborhoodDto = neighborhoodService.save(neighborhoodSaveRequestDto);
        return ResponseEntity.ok(neighborhoodDto);
    }

    @PostMapping("/saveStreet")
    public ResponseEntity<StreetDto> saveStreet(@RequestBody StreetSaveRequestDto streetSaveRequestDto) {
        StreetDto streetDto = streetService.save(streetSaveRequestDto);
        return ResponseEntity.ok(streetDto);
    }

    @PostMapping("/saveAddress")
    public ResponseEntity<AddressDto> saveAddress(@RequestBody AddressSaveRequestDto addressSaveRequestDto){
        AddressDto addressDto = addressService.save(addressSaveRequestDto);
        return ResponseEntity.ok(addressDto);
    }

    @PutMapping("/updateNeighborhood")
    public ResponseEntity<NeighborhoodDto> updateNeighborhood(@RequestBody NeighborhoodUpdateRequestDto neighborhoodUpdateRequestDto){
        NeighborhoodDto neighborhoodDto = neighborhoodService.update(neighborhoodUpdateRequestDto);
        return ResponseEntity.ok(neighborhoodDto);
    }

    @PutMapping("/updateStreet")
    public ResponseEntity<StreetDto> updateStreet(@RequestBody StreetUpdateRequestDto streetUpdateRequestDto){
        StreetDto streetDto = streetService.update(streetUpdateRequestDto);
        return ResponseEntity.ok(streetDto);
    }

    @DeleteMapping("/deleteAddress/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable long id){
        addressService.delete(id);
        return ResponseEntity.ok("Address deleted!");
    }
}
