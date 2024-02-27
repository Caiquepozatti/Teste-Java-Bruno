package com.pozatti.Manufacturer.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String chassi;

    private String name;

    @ManyToOne
    @JoinColumn(name ="manufacturer_id")
    @JsonIgnore
    private Manufacturer manufacturer;

    @Column(name="year_car")
    private Integer year;

    private String color;

    private String status;

    private String placa;

    public Car(){

    }
    public Car(Long id, String chassi, String name, Integer year, String color, String status, String placa) {
        this.id = id;
        this.chassi = chassi;
        this.name = name;
        this.year = year;
        this.color = color;
        this.status = status;
        this.placa = placa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", chassi='" + chassi + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer=" + manufacturer +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", status='" + status + '\'' +
                ", placa='" + placa + '\'' +
                '}';
    }
}
