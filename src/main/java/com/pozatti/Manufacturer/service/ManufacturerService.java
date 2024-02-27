package com.pozatti.Manufacturer.service;


import com.pozatti.Manufacturer.model.Manufacturer;

import com.pozatti.Manufacturer.repository.ManufacturerRepository;
import com.pozatti.Manufacturer.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository repo;

    public List<Manufacturer> findAll(){
        return repo.findAll();
    }

    public Manufacturer findByID(String name){
        return repo.findByName(name);
    }

    public Manufacturer findByName(String name){
        return repo.findByName(name);
    }

    public Manufacturer insert(String obj){
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(obj);
        return repo.save(manufacturer);
    }

}
