package pl.pjwstk.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pjwstk.demo.repository.DriversRepository;
import pl.pjwstk.demo.repository.PointRepository;

@Service
public class FastesRouteService {

    @Autowired
    DriversRepository driversRepository;
    @Autowired
    PointRepository pointRepository;

    public void optimize(int id){

    }
}
