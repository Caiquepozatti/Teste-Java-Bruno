package com.pozatti.Manufacturer.controller;

import com.pozatti.Manufacturer.dto.CarDTO;
import com.pozatti.Manufacturer.model.Car;
import com.pozatti.Manufacturer.service.CarService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> findAll(){
        return ResponseEntity.ok().body(carService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Car> findByID(@PathVariable Long id){
        return ResponseEntity.ok().body(carService.findByID(id));
    }

    @GetMapping(value ="/filtered")
    public ResponseEntity<List<Car>> search (@RequestParam(required = false) String car,
                                             @RequestParam(required = false) String manufacturer,
                                             @RequestParam(required = false) String year){
        List<Car> list = carService.search(car,manufacturer,year);
        return ResponseEntity.ok().body(list);

    }

    @PostMapping
    public ResponseEntity<Car> insert (@RequestBody CarDTO objDTO){
        Car obj = carService.fromDTO(objDTO);
        obj = carService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        carService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update (@RequestBody CarDTO objDTO, @PathVariable Long id){
        Car obj = carService.fromDTO(objDTO);
        obj.setId(id);
        obj = carService.update(obj);
        return ResponseEntity.noContent().build();
    }
}
