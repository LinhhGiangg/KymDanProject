package com.kymdan.backend.repository;

import com.kymdan.backend.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperRepository extends JpaRepository<Shipper, Long> {
    Shipper findByFullName(String name);

    Shipper findByEmail(String email);
}
