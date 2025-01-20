package com.tests.geocodertask.entity;

import com.tests.geocodertask.RequestType;
import jakarta.persistence.*;

@Entity
@Table(name= "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestType type;
    @Column(nullable = false)
    private String address;
    @Column
    private double latitude;
    @Column
    private double longitude;

    public Integer getId() {
        return this.id;
    }

    public RequestType getType() {
        return this.type;
    }

    public String getAddress() {
        return this.address;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
