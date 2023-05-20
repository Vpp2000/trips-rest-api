package com.vpp97.tripsrestapi.services;

import com.vpp97.tripsrestapi.documents.Trip;
import com.vpp97.tripsrestapi.dtos.LocationDto;
import com.vpp97.tripsrestapi.dtos.db.Car;
import com.vpp97.tripsrestapi.dtos.db.City;
import com.vpp97.tripsrestapi.dtos.db.Country;
import com.vpp97.tripsrestapi.dtos.db.Driver;
import com.vpp97.tripsrestapi.dtos.db.MilestonePoint;
import com.vpp97.tripsrestapi.dtos.db.Passenger;
import com.vpp97.tripsrestapi.dtos.requests.TripRequest;
import com.vpp97.tripsrestapi.dtos.responses.PagedResponse;
import com.vpp97.tripsrestapi.dtos.responses.StatisticsResponse;
import com.vpp97.tripsrestapi.exceptions.IdNotFoundException;
import com.vpp97.tripsrestapi.repositories.TripRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.vpp97.tripsrestapi.utils.GeoJsonUtils.getGeoJsonPointFromLocationDto;

@Service
@Slf4j
@RequiredArgsConstructor
public class TripService {
    private final TripRepository tripRepository;

    public PagedResponse<Trip> findAll(int page, int size){
        var paging = PageRequest.of(page, size);
        var tripsPaged = this.tripRepository.findAll(paging);

        return PagedResponse.<Trip>builder()
                .page(page)
                .size(size)
                .items(tripsPaged.getContent())
                .build();

    }
    public Trip findById(String id){
        var trip = this.tripRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id, "Trips"));
        return trip;
    }
    public StatisticsResponse getStatisticsResponse(String city, String country){
        final long totalTrips = this.tripRepository.count();
        final long tripsByCity = this.tripRepository.countByCity_Name(city);
        final long tripsByCountry = this.tripRepository.countByCountry_Name(country);

        return StatisticsResponse.builder()
                .totalTrips(totalTrips)
                .tripsByCity(tripsByCity)
                .tripsByCountry(tripsByCountry)
                .build();
    }

    public Trip createTripFromTripRequest(TripRequest tripRequest) {

        GeoJsonPoint startLocation = getGeoJsonPointFromLocationDto(tripRequest.getStart().getPickupLocation());
        MilestonePoint start = MilestonePoint.builder()
                .date(LocalDateTime.now())
                .pickupAddress(tripRequest.getStart().getPickupAddress())
                .pickupLocation(startLocation)
                .build();

        GeoJsonPoint endLocation = getGeoJsonPointFromLocationDto(tripRequest.getEnd().getPickupLocation());
        MilestonePoint end = MilestonePoint.builder()
                .date(null)
                .pickupAddress(tripRequest.getEnd().getPickupAddress())
                .pickupLocation(endLocation)
                .build();

        GeoJsonPoint driverLocation = getGeoJsonPointFromLocationDto(tripRequest.getDriverLocation());

        Country country = Country.builder()
                .name(tripRequest.getCountry().getName())
                .build();
        City city = City.builder()
                .name(tripRequest.getCity().getName())
                .build();
        Passenger passenger = Passenger.builder()
                .firstName(tripRequest.getPassenger().getFirstName())
                .lastName(tripRequest.getPassenger().getLastName())
                .build();
        Driver driver = Driver.builder()
                .firstName(tripRequest.getDriver().getFirstName())
                .lastName(tripRequest.getDriver().getLastName())
                .build();
        Car car = Car.builder()
                .plate(tripRequest.getCar().getPlate())
                .build();

        Trip trip = Trip.builder()
                .start(start)
                .end(end)
                .country(country)
                .city(city)
                .passenger(passenger)
                .driver(driver)
                .car(car)
                .status(tripRequest.getStatus())
                .checkCode("18956")
                .price(tripRequest.getPrice())
                .createdAt(LocalDateTime.now())
                .updatedAt(null)
                .driverLocation(driverLocation)
                .build();

        trip = this.tripRepository.insert(trip);

        return trip;
    }




}
