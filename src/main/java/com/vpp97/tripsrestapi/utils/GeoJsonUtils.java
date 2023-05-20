package com.vpp97.tripsrestapi.utils;

import com.vpp97.tripsrestapi.dtos.LocationDto;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

public class GeoJsonUtils {
    public static GeoJsonPoint getGeoJsonPointFromLocationDto(LocationDto locationDto){
        return new GeoJsonPoint(locationDto.getLatitude(), locationDto.getLongitude());
    }

}
