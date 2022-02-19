package org.example.case2FurkanYabanci.dto.request;

import lombok.Data;
import org.example.case2FurkanYabanci.dto.CityDto;

@Data
public class DistrictSaveRequestDto {

    private String name;
    private CityDto city;
}
