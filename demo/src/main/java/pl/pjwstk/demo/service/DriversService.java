package pl.pjwstk.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pjwstk.demo.model.Entity.DriversEntity;
import pl.pjwstk.demo.repository.DriversRepository;
import pl.pjwstk.demo.repository.PointRepository;

import java.util.List;

@Service
public class DriversService {

    @Autowired
    DriversRepository driversRepository;
    @Autowired
    PointRepository pointRepository;


    public List<DriversEntity> getDriversByName(String imie){
        return driversRepository.findByImie(imie);
    }
    public List<DriversEntity> getDriversBySurename(String surename){
        return driversRepository.findByNazwisko(surename);
    }
    public List<DriversEntity> getDriversById(int id){
        return driversRepository.findByIdDriver(id);
    }
    public List<DriversEntity> getAllDrivers(){
        return driversRepository.findAll();
    }
    public void  addDriver(int id,String name,String surename){
        driversRepository.save(new DriversEntity(id,name,surename));
    }
    public void removeDriver(int id){
        if (pointRepository.findByDriverFk(id).isEmpty()){
            driversRepository.deleteById(id);
        }
    }
}
