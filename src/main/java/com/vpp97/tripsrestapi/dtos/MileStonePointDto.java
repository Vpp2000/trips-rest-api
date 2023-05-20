package com.vpp97.tripsrestapi.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MileStonePointDto {
    @NotNull
    @NotEmpty(message = "Name may not be empty")
    private String pickupAddress;
    @NotNull
    private LocationDto pickupLocation;
}
