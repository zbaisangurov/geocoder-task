package com.tests.geocodertask.controller;

import com.tests.geocodertask.entity.Location;
import com.tests.geocodertask.service.CacheService;
import com.tests.geocodertask.service.OpenCage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

import static com.tests.geocodertask.RequestType.FORWARD;
import static com.tests.geocodertask.RequestType.REVERSE;

@RestController
public class GeoController {
    @Autowired
    private OpenCage openCage;
    @Autowired
    private CacheService cacheService;

    public GeoController(OpenCage openCage, CacheService cacheService){
        this.openCage = openCage;
        this.cacheService = cacheService;
    }
    @GetMapping("/locations")
    public Map<String,Double> getLocations(@RequestParam String address) {
        Optional<Location> request = cacheService.getForwardCache(address);
        if (request.isPresent()){
            System.out.println("Cached data");
            return Map.of(
                    "lat", request.get().getLatitude(),
                    "lng", request.get().getLongitude()
            );
        } else {
            Map<String, Double> response = openCage.locationToCoordinates(address);
            cacheService.saveToCache(FORWARD, address, response.get("lat"), response.get("lng"));
            return response;
        }
    }

    @GetMapping("/coordinates")
    public Map<String, String> getCoordinates(@RequestParam Map<String, String> params){
        Optional<Location> request = cacheService.getReverseCache(Double.parseDouble(params.get("lat")),
                Double.parseDouble(params.get("lng")));
        if (request.isPresent()){
            System.out.println("Cached data");
            return Map.of("address", request.get().getAddress());
        } else {
            //params.forEach((key, value) -> System.out.println(key + " = " + value));
            Map<String, String> response = openCage.coordinatesToLocation(params);
            cacheService.saveToCache(REVERSE, response.get("address"), Double.parseDouble(params.get("lat")),
                    Double.parseDouble(params.get("lng")));
            return response;
        }
    }
}
