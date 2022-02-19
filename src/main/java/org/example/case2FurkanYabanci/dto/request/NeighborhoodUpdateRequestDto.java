package org.example.case2FurkanYabanci.dto.request;

import lombok.Data;
import org.example.case2FurkanYabanci.dto.DistrictDto;

@Data
public class NeighborhoodUpdateRequestDto {

    private long id;
    private String name;
    private DistrictDto district;
}
