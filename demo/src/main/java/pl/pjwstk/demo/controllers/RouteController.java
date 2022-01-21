package pl.pjwstk.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.pjwstk.demo.model.PointEntity;
import pl.pjwstk.demo.service.PointsService;
import java.io.IOException;
import java.util.HashMap;


@RestController
public class RouteController {
    @Autowired
    RestTemplate rest;
    @Autowired
    PointsService pointsService;



    @GetMapping(path = "/route")
    public void test() throws IOException {
        int id = 1;
        //var root = rest.getForEntity("https://maps.googleapis.com/maps/api/directions/json?key=keyhere&origin=Gdynia+Witolda+17&destination=Gdynia+Witolda+39A&waypoints=optimize:true|Gdynia+Starowiejska+40C|Gdynia+Wiczlinska+4"
        //,Route.class).getBody();
        HashMap<Integer, PointEntity> segregatedPoints = pointsService.convert(id);
        }
}
