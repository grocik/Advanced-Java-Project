package pl.pjwstk.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pjwstk.demo.model.PointEntity;
import pl.pjwstk.demo.repository.DriversRepository;
import pl.pjwstk.demo.repository.PointRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PointsService {

    @Autowired
    PointRepository pointRepository;
    @Autowired
    DriversRepository driversRepository;

    public List<PointEntity> get(int id){
        return pointRepository.findByDriverFk(id);
    }
}
