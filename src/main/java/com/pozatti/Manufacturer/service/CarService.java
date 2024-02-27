package com.pozatti.Manufacturer.service;

import com.pozatti.Manufacturer.dto.CarDTO;
import com.pozatti.Manufacturer.model.Car;
import com.pozatti.Manufacturer.model.Manufacturer;
import com.pozatti.Manufacturer.model.enums.Status;
import com.pozatti.Manufacturer.repository.CarRepository;
import com.pozatti.Manufacturer.service.exception.ObjectAlreadyExist;
import com.pozatti.Manufacturer.service.exception.ObjectNotFoundException;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository repo;

    @Autowired
    private ManufacturerService manufacturerService;

    public List<Car> findAll(){
        return repo.findAll();
    }

    public Car findByID(Long id){
        Optional<Car> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Id not found"));
    }

    public Car insert(Car obj){
        chassiPlaca(obj);

        Manufacturer manufacturer = obj.getManufacturer();
        if(manufacturer != null){
            Manufacturer existingManufacturer = manufacturerService.findByName(obj.getManufacturer().getName());
            if(existingManufacturer == null){
                manufacturer = manufacturerService.insert(manufacturer.getName());
            }else{
                manufacturer = existingManufacturer;
            }
        }
        obj.setManufacturer(manufacturer);
        return repo.save(obj);
    }

    public void delete(Long id){
        findByID(id);
        repo.deleteById(id);
    }

    public Car update (Car obj) {
        chassiPlaca(obj);
        Car newObj = findByID(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(Car newObj, Car obj) {
        newObj.setChassi(obj.getChassi());
        newObj.setName(obj.getName());
        newObj.setYear(obj.getYear());
        newObj.setColor(obj.getColor());
        newObj.setStatus(obj.getStatus());
        newObj.setPlaca(obj.getPlaca());

        Manufacturer manufacturer = obj.getManufacturer();
        if(manufacturer != null){
            Manufacturer existingManufacturer = manufacturerService.findByName(manufacturer.getName());
            if(existingManufacturer == null){
                manufacturer = manufacturerService.insert(manufacturer.getName());
            }else{
                manufacturer = existingManufacturer;
            }
        }newObj.setManufacturer(manufacturer);

        try{
            Status status = Status.valueOf(obj.getStatus());
        }catch(IllegalArgumentException e){
            throw new ObjectNotFoundException("Invalid car status: ACTIVATED, DEACTIVATED, RESERVED, RENTED");
        }

    }

    public Car fromDTO (CarDTO objDTO){
        return new Car(null, objDTO.getChassi(), objDTO.getName(),new Manufacturer(null, objDTO.getManufacturer()), objDTO.getYear(), objDTO.getColor(), objDTO.getStatus(), objDTO.getPlaca());
    }

    public List<Car> search (String manufacturerName, String carName, String year){
        return repo.findByManufacturerNameAndCarNameAndYear(manufacturerName,carName, year);
    }

    private void chassiPlaca(Car obj){
        List<Car> cars = repo.findAll();
        for(Car car: cars){
            if(car.getChassi().equals(obj.getChassi())){
                throw new ObjectAlreadyExist("Chassi already registred");
            }
            if(car.getPlaca().equals(obj.getPlaca())){
                throw new ObjectAlreadyExist("License already registred");
            }
        }
    }


}
