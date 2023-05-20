package com.vpp97.tripsrestapi.controllers;

import com.vpp97.tripsrestapi.documents.Trip;
import com.vpp97.tripsrestapi.dtos.responses.PagedResponse;
import com.vpp97.tripsrestapi.dtos.responses.SuccessfulControllerResponse;
import com.vpp97.tripsrestapi.services.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("trip")
@RequiredArgsConstructor
public class TripController {
    private final TripService tripService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SuccessfulControllerResponse<PagedResponse<Trip>>> getAll(@RequestParam(value = "size", defaultValue = "5") int size, @RequestParam(value = "page", defaultValue = "0") int page) {
        PagedResponse<Trip> tripsPaged = this.tripService.findAll(page, size);
        SuccessfulControllerResponse genericControllerResponse = SuccessfulControllerResponse.<PagedResponse>builder()
                .message("Trips were obtained successfully")
                .data(tripsPaged)
                .build();
        return ResponseEntity.ok(genericControllerResponse);
    }

}