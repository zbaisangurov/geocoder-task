package com.tests.geocodertask.service;

import com.tests.geocodertask.RequestType;
import com.tests.geocodertask.entity.Location;
import com.tests.geocodertask.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.tests.geocodertask.RequestType.FORWARD;
import static com.tests.geocodertask.RequestType.REVERSE;

@Service
public class CacheService {
    private final LocationRepository locationRepository;

    public CacheService(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }


    public void saveToCache(RequestType type, String address, Double latitude, Double longitude){
        Location cacheEntry = new Location();
        cacheEntry.setType(type);
        cacheEntry.setAddress(address);
        cacheEntry.setLatitude(latitude);
        cacheEntry.setLongitude(longitude);
        locationRepository.save(cacheEntry);
    }


    public Optional<Location> getForwardCache(String address){
        return locationRepository.findByTypeAndAddress(FORWARD, address);
    }


    public Optional<Location> getReverseCache(Double latitude, Double longitude){
        return locationRepository.findByTypeAndLatitudeAndLongitude(REVERSE, latitude, longitude);
    }

}
