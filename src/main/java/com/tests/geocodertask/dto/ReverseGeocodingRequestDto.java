package com.tests.geocodertask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReverseGeocodingRequestDto {
    private String address;
    private double latitude;
    private double longitude;
}
