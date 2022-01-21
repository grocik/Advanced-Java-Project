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
    HashMap<Integer, PointEntity> segregatedPoints = new HashMap<>();
    int a = 1;

    public HashMap<Integer, PointEntity> convert(int id){
        List<PointEntity> pointEntities = new ArrayList<>(pointRepository.findByDriverFk(id));
        pointEntities.forEach(pointEntity -> {
            segregatedPoints.put(a,pointEntity);
            a++;
        });
        return segregatedPoints;
    }
}
