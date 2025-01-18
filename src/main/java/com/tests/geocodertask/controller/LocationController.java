package com.tests.geocodertask.controller;

import com.tests.geocodertask.entity.Location;
import com.tests.geocodertask.repository.LocationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {
    private final LocationRepository locationRepository;

    public LocationController (LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    @GetMapping
    public List<Location> getAllLocations(){
        return locationRepository.findAll();
    }

    @PostMapping
    public Location createLocation (@RequestBody Location location){
        return locationRepository.save(location);
    }
}
