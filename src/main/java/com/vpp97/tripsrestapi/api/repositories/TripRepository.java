package com.vpp97.tripsrestapi.api.repositories;

import com.vpp97.tripsrestapi.documents.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TripRepository extends MongoRepository<Trip, String> {
    long countByCity_Name(String city);
    long countByCountry_Name(String country);
}