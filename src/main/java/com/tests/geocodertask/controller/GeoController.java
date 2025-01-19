package com.tests.geocodertask.controller;

import com.tests.geocodertask.service.OpenCage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Map;

@RestController
public class GeoController {
    @Autowired
    private OpenCage openCage;
    @GetMapping("/locations")
    public Map<String,String> getLocations(@RequestParam String address) {
        return openCage.locationToCoordinates(address);
    }

    @GetMapping("/coordinates")
    public String getCoordinates(@RequestParam Map<String, String> params){
        params.forEach((key, value) -> System.out.println(key + " = " + value));
        return openCage.coordinatesToLocation(params);
    }
}
