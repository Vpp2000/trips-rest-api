package com.vpp97.tripsrestapi.dtos.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Driver {
    @Field(name = "first_name")
    private String firstName;
    @Field(name = "last_name")
    private String lastName;
}
