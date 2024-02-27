package com.pozatti.Manufacturer.controller;

import com.pozatti.Manufacturer.dto.CarDTO;
import com.pozatti.Manufacturer.model.Car;
import com.pozatti.Manufacturer.model.Manufacturer;
import com.pozatti.Manufacturer.service.CarService;
import com.pozatti.Manufacturer.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping
    public ResponseEntity<List<Manufacturer>> findAll(){

        return ResponseEntity.ok().body(manufacturerService.findAll());
    }


    @GetMapping(value = "/{name}")
    public ResponseEntity<Manufacturer> findByName (@PathVariable String name){
        return ResponseEntity.ok().body(manufacturerService.findByName(name));
    }



}
