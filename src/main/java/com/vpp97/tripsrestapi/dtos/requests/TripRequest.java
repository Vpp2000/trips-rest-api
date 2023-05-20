package com.vpp97.tripsrestapi.dtos.requests;

import com.vpp97.tripsrestapi.dtos.CarDto;
import com.vpp97.tripsrestapi.dtos.CityDto;
import com.vpp97.tripsrestapi.dtos.CountryDto;
import com.vpp97.tripsrestapi.dtos.DriverDto;
import com.vpp97.tripsrestapi.dtos.LocationDto;
import com.vpp97.tripsrestapi.dtos.MileStonePointDto;
import com.vpp97.tripsrestapi.dtos.PassengerDto;
import com.vpp97.tripsrestapi.dtos.db.TripStatus;
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
    private MileStonePointDto start;
    @NotNull
    private MileStonePointDto end;
    @NotNull
    private PassengerDto passenger;
    @NotNull
    private CarDto car;
    @NotNull
    private DriverDto driver;
    @NotNull
    private CountryDto country;
    @NotNull
    private CityDto city;
    @NotNull
    private TripStatus status;
    @NotNull
    private BigDecimal price;
    @NotNull
    private LocationDto driverLocation;
}
