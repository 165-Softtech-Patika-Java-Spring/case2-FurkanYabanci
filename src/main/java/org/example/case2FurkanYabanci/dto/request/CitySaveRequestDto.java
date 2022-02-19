package org.example.case2FurkanYabanci.dto.request;

import lombok.Data;
import org.example.case2FurkanYabanci.dto.CountryDto;
import org.example.case2FurkanYabanci.model.Country;

@Data
public class CitySaveRequestDto {

    private String plateCode;
    private String name;
    private CountryDto country;
}
