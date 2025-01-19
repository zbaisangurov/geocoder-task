package com.tests.geocodertask.service;

import com.opencagedata.jopencage.JOpenCageGeocoder;
import com.opencagedata.jopencage.model.JOpenCageForwardRequest;
import com.opencagedata.jopencage.model.JOpenCageLatLng;
import com.opencagedata.jopencage.model.JOpenCageResponse;
import com.opencagedata.jopencage.model.JOpenCageReverseRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class OpenCage {
    @Value("${opencage.api.key}")
    private String apiKey;
    public Map<String,String> locationToCoordinates(String address){
        JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder(apiKey);
        JOpenCageForwardRequest request = new JOpenCageForwardRequest(address);
        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        JOpenCageLatLng firstResultLatLng = response.getFirstPosition();
        return Map.of(
                "lat", firstResultLatLng.getLat().toString(),
                "lng", firstResultLatLng.getLng().toString()
        );
    }
    public Map<String,String> coordinatesToLocation(Map<String,String> params){
        JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder(apiKey);
        JOpenCageReverseRequest request = new JOpenCageReverseRequest(
                Double.parseDouble(params.get("lat")),
                Double.parseDouble(params.get("lng"))
        );
        request.setLanguage("ru");
        request.setLimit(5);
        request.setNoAnnotations(true);
        request.setMinConfidence(3);
        JOpenCageResponse response = jOpenCageGeocoder.reverse(request);
        return Map.of("address", response.getResults().get(0).getFormatted());
    }
}
