package pl.pjwstk.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjwstk.demo.model.DriversEntity;
import pl.pjwstk.demo.repository.DriversRepository;
import pl.pjwstk.demo.repository.PointRepository;

@RestController
public class RouteController {

    @Autowired
    DriversRepository driversRepository;
    @Autowired
    PointRepository pointRepository;



    @GetMapping(path = "/drivers")
    public String test(){
        String testowanko = driversRepository.findById(1).get().getNazwisko();
        System.out.println(testowanko);
        return testowanko;
    }
}
