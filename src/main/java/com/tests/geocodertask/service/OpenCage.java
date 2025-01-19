package com.tests.geocodertask.service;

import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class OpenCage {
    public Map<String,String> locationToCoordinates(String address){
        Map<String, String> map = Map.of(
                "lat", "value1",
                "lng", "value2"
        );
        return map;
    }
    public String coordinatesToLocation(Map<String,String> params){
        return "держи свой ебучий адрес";
    }
}
