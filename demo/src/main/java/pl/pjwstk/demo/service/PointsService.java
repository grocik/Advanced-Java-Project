package pl.pjwstk.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pjwstk.demo.model.Entity.PointEntity;
import pl.pjwstk.demo.repository.PointRepository;
import java.util.List;

@Service
public class PointsService {

    @Autowired
    PointRepository pointRepository;


    public List<PointEntity> getByDriverFK(int id){
        return pointRepository.findByDriverFk(id);
    }
    public List<PointEntity> getAllPoints(){
        return pointRepository.findAll();
    }
    public void removePoint(int id){
        pointRepository.deleteById(id);
    }
    public void addPoint(int id,String city, String street, String stnumber,int driverFk){
        pointRepository.save(new PointEntity(id,city,street,stnumber,driverFk));
    }
}
