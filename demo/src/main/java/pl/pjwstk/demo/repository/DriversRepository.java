package pl.pjwstk.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjwstk.demo.model.Entity.DriversEntity;

import javax.persistence.Column;
import java.util.List;


public interface DriversRepository extends JpaRepository<DriversEntity,Integer> {
    @Column(name = "imie")
    List<DriversEntity> findByImie(String name);
    @Column(name = "nazwisko")
    List<DriversEntity> findByNazwisko(String surename);
    @Column(name = "id_driver")
    List<DriversEntity> findByIdDriver(int id);

}
