package com.pozatti.Manufacturer.repository;

import com.pozatti.Manufacturer.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {

    Manufacturer findByName(String name);
}
