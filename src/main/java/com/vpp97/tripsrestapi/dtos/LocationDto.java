package com.vpp97.tripsrestapi.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationDto {
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;
}
