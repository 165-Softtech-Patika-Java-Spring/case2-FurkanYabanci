package org.example.case2FurkanYabanci.dto;

import lombok.Data;

@Data
public class AddressDto {

    private long id;
    private int doorNumber;
    private int apartmentNumber;
    private CountryDto country;
    private CityDto city;
    private DistrictDto district;
    private NeighborhoodDto neighborhood;
    private StreetDto street;
}
