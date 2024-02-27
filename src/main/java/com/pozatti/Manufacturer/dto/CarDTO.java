package com.pozatti.Manufacturer.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pozatti.Manufacturer.model.Manufacturer;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDTO {

    private Long id;
    private String chassi;
    private String name;
    private String manufacturer;
    private Integer year;
    private String color;
    private String status;
    private String placa;

    public CarDTO(Long id, String chassi, String name, Integer year, String color, String status, String placa) {
        this.id = id;
        this.chassi = chassi;
        this.name = name;
        this.year = year;
        this.color = color;
        this.status = status;
        this.placa = placa;
    }
}
