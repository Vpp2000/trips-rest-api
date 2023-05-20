package com.vpp97.tripsrestapi.documents;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vpp97.tripsrestapi.dtos.db.Car;
import com.vpp97.tripsrestapi.dtos.db.City;
import com.vpp97.tripsrestapi.dtos.db.Country;
import com.vpp97.tripsrestapi.dtos.db.Driver;
import com.vpp97.tripsrestapi.dtos.db.MilestonePoint;
import com.vpp97.tripsrestapi.dtos.db.Passenger;
import com.vpp97.tripsrestapi.dtos.db.TripStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("trips")
public class Trip {
    @Id
    private String id;
    private MilestonePoint start;
    private MilestonePoint end;
    @Field(name = "country")
    private Country country;
    @Field(name = "city")
    private City city;
    private Passenger passenger;
    private Driver driver;
    private Car car;
    @Field(name = "status", targetType = FieldType.STRING)
    private TripStatus status;
    @Field(name = "check_code")
    private String checkCode;
    private BigDecimal price;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime updatedAt;
    @Field(name = "driver_location")
    @JsonIgnoreProperties(value = {"x", "y"})
    private GeoJsonPoint driverLocation;
}
