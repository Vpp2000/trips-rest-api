package com.vpp97.tripsrestapi.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatisticsResponse {
    private Long totalTrips;
    private Long tripsByCity;
    private Long tripsByCountry;
}
