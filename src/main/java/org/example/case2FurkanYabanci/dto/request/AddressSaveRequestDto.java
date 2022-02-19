package org.example.case2FurkanYabanci.dto.request;

import lombok.Data;
import org.example.case2FurkanYabanci.dto.*;

@Data
public class AddressSaveRequestDto {

    private int doorNumber;
    private int apartmentNumber;
    private CountryDto country;
    private CityDto city;
    private DistrictDto district;
    private NeighborhoodDto neighborhood;
    private StreetDto street;
}
