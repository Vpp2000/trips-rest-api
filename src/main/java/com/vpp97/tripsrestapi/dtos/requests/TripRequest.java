package com.vpp97.tripsrestapi.dtos.requests;

import com.vpp97.tripsrestapi.dtos.CarDto;
import com.vpp97.tripsrestapi.dtos.CityDto;
import com.vpp97.tripsrestapi.dtos.CountryDto;
import com.vpp97.tripsrestapi.dtos.DriverDto;
import com.vpp97.tripsrestapi.dtos.LocationDto;
import com.vpp97.tripsrestapi.dtos.MileStonePointDto;
import com.vpp97.tripsrestapi.dtos.PassengerDto;
import com.vpp97.tripsrestapi.dtos.db.TripStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripRequest {
    @NotNull
    @Valid
    private MileStonePointDto start;
    @NotNull
    @Valid
    private MileStonePointDto end;
    @NotNull
    @Valid
    private PassengerDto passenger;
    @NotNull
    @Valid
    private CarDto car;
    @NotNull
    @Valid
    private DriverDto driver;
    @NotNull
    @Valid
    private CountryDto country;
    @NotNull
    @Valid
    private CityDto city;
    @NotNull
    @Valid
    private TripStatus status;
    @NotNull
    @Min(1)
    private BigDecimal price;
    @NotNull
    @Valid
    private LocationDto driverLocation;
}
