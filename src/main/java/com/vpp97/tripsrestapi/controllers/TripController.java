package com.vpp97.tripsrestapi.controllers;

import com.vpp97.tripsrestapi.documents.Trip;
import com.vpp97.tripsrestapi.dtos.responses.ErrorResponse;
import com.vpp97.tripsrestapi.dtos.responses.PagedResponse;
import com.vpp97.tripsrestapi.dtos.responses.SuccessfulControllerResponse;
import com.vpp97.tripsrestapi.services.TripService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Trip")
@RestController
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
}