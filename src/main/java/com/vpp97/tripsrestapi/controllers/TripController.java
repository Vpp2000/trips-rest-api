package com.vpp97.tripsrestapi.controllers;

import com.vpp97.tripsrestapi.documents.Trip;
import com.vpp97.tripsrestapi.dtos.FieldNames;
import com.vpp97.tripsrestapi.dtos.requests.TripRequest;
import com.vpp97.tripsrestapi.dtos.responses.ErrorResponse;
import com.vpp97.tripsrestapi.dtos.responses.PagedResponse;
import com.vpp97.tripsrestapi.dtos.responses.StatisticsResponse;
import com.vpp97.tripsrestapi.dtos.responses.SuccessfulControllerResponse;
import com.vpp97.tripsrestapi.services.TripService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@Tag(name = "Trip")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("trip")
@RequiredArgsConstructor
public class TripController {
    private final TripService tripService;

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Retrieve paginated trips")
    public ResponseEntity<SuccessfulControllerResponse<PagedResponse<Trip>>> getAll(@RequestParam(value = "size", defaultValue = "5") int size, @RequestParam(value = "page", defaultValue = "0") int page) {
        PagedResponse<Trip> tripsPaged = this.tripService.findAll(page, size);
        SuccessfulControllerResponse genericControllerResponse = SuccessfulControllerResponse.<PagedResponse>builder()
                .message("Trips were obtained successfully")
                .data(tripsPaged)
                .build();
        return ResponseEntity.ok(genericControllerResponse);
    }

    @GetMapping(value = "{tripId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Retrieve Trip by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Trip not found",
                    content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class)) }) })
    public ResponseEntity<SuccessfulControllerResponse<Trip>> findByTripId(@PathVariable("tripId") String tripId) {
        Trip trip = this.tripService.findById(tripId);
        String message = String.format("Trip with id %s was obtained successfully", tripId);
        SuccessfulControllerResponse genericControllerResponse = SuccessfulControllerResponse.<Trip>builder()
                .message(message)
                .data(trip)
                .build();

        return ResponseEntity.ok(genericControllerResponse);
    }


    @GetMapping(value = "statistics", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Retrieve basic statistics about Trips")
    public ResponseEntity<SuccessfulControllerResponse<StatisticsResponse>> getStatistics(@RequestParam(value = "city") String city, @RequestParam("country") String country) {
        StatisticsResponse statisticsResponse = this.tripService.getStatisticsResponse(city, country);
        String message = "Statistics about trips were obtained successfully";

        SuccessfulControllerResponse genericControllerResponse = SuccessfulControllerResponse.<StatisticsResponse>builder()
                .message(message)
                .data(statisticsResponse)
                .build();

        return ResponseEntity.ok(genericControllerResponse);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a Trip from our TripRequest")
    public ResponseEntity<SuccessfulControllerResponse<Trip>> create(@RequestBody @Valid TripRequest tripRequest){
        Trip trip = this.tripService.createTripFromTripRequest(tripRequest);
        String message = "Trip was created successfully";
        SuccessfulControllerResponse genericControllerResponse = SuccessfulControllerResponse.<Trip>builder()
                .message(message)
                .data(trip)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(genericControllerResponse);
    }

    @PutMapping(value = "{tripId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a Trip by id from TripRequest")
    public ResponseEntity<SuccessfulControllerResponse<Trip>> update(@RequestBody @Valid TripRequest tripRequest, @PathVariable("tripId") String tripId){
        Trip trip = this.tripService.updateTripById(tripId, tripRequest);
        String message = "Trip was updated successfully";
        SuccessfulControllerResponse genericControllerResponse = SuccessfulControllerResponse.<Trip>builder()
                .message(message)
                .data(trip)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(genericControllerResponse);
    }

    @GetMapping(value =  "count", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Count trips depending on request params")
    public ResponseEntity<SuccessfulControllerResponse<Map<String, Long>>> count(
            @RequestParam(name = "field", required = false) FieldNames fieldName,
            @RequestParam(name = "value", required = false) String value
    ){
        long count = this.tripService.count(fieldName, value);
        String message = "Trip was updated successfully";
        Map<String, Long> data = Collections.singletonMap("count", count);
        SuccessfulControllerResponse genericControllerResponse = SuccessfulControllerResponse.<Map<String, Long>>builder()
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(genericControllerResponse);

    }
}