package com.tests.geocodertask.repository;

import com.tests.geocodertask.RequestType;
import com.tests.geocodertask.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    Optional<Location> findByTypeAndAddress(RequestType type, String address);
    Optional<Location> findByTypeAndLatitudeAndLongitude(RequestType type, Double latitude, Double longitude);
}
