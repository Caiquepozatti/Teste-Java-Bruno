package com.pozatti.Manufacturer.config;

import com.pozatti.Manufacturer.model.Car;
import com.pozatti.Manufacturer.model.Manufacturer;
import com.pozatti.Manufacturer.repository.CarRepository;
import com.pozatti.Manufacturer.repository.ManufacturerRepository;
import com.pozatti.Manufacturer.service.ManufacturerService;
import org.hibernate.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class config implements CommandLineRunner {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public void run(String... args) throws Exception {

        Manufacturer manufacturer1= new Manufacturer(1L,"Volkswagem");
        Manufacturer manufacturer2= new Manufacturer(2L,"GM");

        Car car1 = new Car(1L,"abc123","Gol",2010,"Preto","RENTED","abc123");
        Car car2 = new Car(2L,"abc124","Gol",2020,"Preto","RENTED","abc124");
        Car car3 = new Car(3L,"abc125","Corsa",2020,"Preto","RENTED","abc124");

        manufacturerRepository.saveAll(Arrays.asList(manufacturer1,manufacturer2));

        car1.setManufacturer(manufacturer2);
        car2.setManufacturer(manufacturer2);
        car3.setManufacturer(manufacturer1);

        carRepository.saveAll(Arrays.asList(car1,car2,car3));
    }
}
