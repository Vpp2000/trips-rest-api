package com.vpp97.tripsrestapi.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SuccessfulControllerResponse<P>{
    private String message;
    private P data;
}
