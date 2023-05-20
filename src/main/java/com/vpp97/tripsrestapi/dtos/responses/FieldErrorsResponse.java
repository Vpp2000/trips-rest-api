package com.vpp97.tripsrestapi.dtos.responses;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FieldErrorsResponse{
    private String message;
    private Map<String, String> fieldsErrors;
}
