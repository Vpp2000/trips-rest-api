package com.vpp97.tripsrestapi.services;

import com.vpp97.tripsrestapi.documents.Trip;
import com.vpp97.tripsrestapi.dtos.db.Car;
import com.vpp97.tripsrestapi.dtos.db.City;
import com.vpp97.tripsrestapi.dtos.db.Country;
import com.vpp97.tripsrestapi.dtos.db.Driver;
import com.vpp97.tripsrestapi.dtos.db.MilestonePoint;
import com.vpp97.tripsrestapi.dtos.db.Passenger;
import com.vpp97.tripsrestapi.dtos.responses.PagedResponse;
import com.vpp97.tripsrestapi.repositories.TripRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
        var trip = this.tripRepository.findById(id).orElseThrow(() -> new RuntimeException("Trip not found"));
        return trip;
    }
}
