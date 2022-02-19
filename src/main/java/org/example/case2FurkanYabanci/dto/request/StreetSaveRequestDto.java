package org.example.case2FurkanYabanci.dto.request;

import lombok.Data;
import org.example.case2FurkanYabanci.dto.NeighborhoodDto;

@Data
public class StreetSaveRequestDto {

    private String name;
    private NeighborhoodDto neighborhood;
}
