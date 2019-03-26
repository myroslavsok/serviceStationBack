package com.example.demo.repositories;

import com.example.demo.domains.car.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    ArrayList<Model> findByModelName(String modelName);
}
