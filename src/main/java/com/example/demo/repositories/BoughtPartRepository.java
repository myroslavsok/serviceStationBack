package com.example.demo.repositories;

import com.example.demo.domains.car.BoughtPart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoughtPartRepository extends JpaRepository<BoughtPart, Long> {
}
