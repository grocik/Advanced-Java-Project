package pl.pjwstk.demo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.pjwstk.demo.model.Route;
import pl.pjwstk.demo.repository.DriversRepository;
import pl.pjwstk.demo.repository.PointRepository;

import java.io.IOException;

@RestController
public class RouteController {

    @Autowired
    DriversRepository driversRepository;
    @Autowired
    PointRepository pointRepository;
    @Autowired
    RestTemplate rest;



    @GetMapping(path = "/drivers")
    public void test() throws IOException {

        var root = rest.getForEntity("https://maps.googleapis.com/maps/api/directions/json?key=keyhere&origin=Gdynia+Witolda+17&destination=Gdynia+Witolda+39A&waypoints=optimize:true|Gdynia+Starowiejska+40C|Gdynia+Wiczlinska+4"
        ,Route.class).getBody();
        }


}
