package com.pozatti.Manufacturer.repository;

import com.pozatti.Manufacturer.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    @Query("SELECT c FROM Car c WHERE (:manufacturerName is null or c.manufacturer.name = :manufacturerName) and (:carName is null or c.name = :carName) and (:year is null or c.year = :year)")
    List<Car> findByManufacturerNameAndCarNameAndYear(@Param("manufacturerName") String manufacturerName, @Param("carName") String carName, @Param("year") String year);
}