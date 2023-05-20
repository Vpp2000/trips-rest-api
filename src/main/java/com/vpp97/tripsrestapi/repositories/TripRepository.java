package com.vpp97.tripsrestapi.repositories;

import com.vpp97.tripsrestapi.documents.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TripRepository extends MongoRepository<Trip, String> {
}