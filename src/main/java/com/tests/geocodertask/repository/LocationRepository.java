package com.tests.geocodertask.repository;

import com.tests.geocodertask.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
