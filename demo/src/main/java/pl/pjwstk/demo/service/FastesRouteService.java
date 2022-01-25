package pl.pjwstk.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pjwstk.demo.model.Entity.PointEntity;
import pl.pjwstk.demo.repository.DriversRepository;
import pl.pjwstk.demo.repository.PointRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FastesRouteService {

    @Autowired
    DriversRepository driversRepository;
    @Autowired
    PointRepository pointRepository;
    String request;

    public String makeRequest(List<PointEntity> pointEntities){
        request = "";
        AtomicInteger i = new AtomicInteger();
        pointEntities.forEach(pointEntity -> {
            if(i.get() ==0){
                request = "&origin=" + pointEntity.getCity() + "+" + pointEntity.getStreet().replace(" ", "") + "+" + pointEntity.getStnumber()
                        +"&destination="+pointEntities.get(pointEntities.size()-1).getCity()
                        +"+"+pointEntities.get(pointEntities.size()-1).getStreet().replace(" ", "")
                        +"+"+pointEntities.get(pointEntities.size()-1).getStnumber()
                        +"&waypoints=optimize:true";
            }
            else if(i.get() >0 && i.get() <pointEntities.size()-1){
                request = request+"|"+pointEntity.getCity()+"+"+pointEntity.getCity()
                        +"+"+pointEntity.getStreet().replace(" ", "")
                        +"+"+pointEntity.getStnumber();
            }
            i.getAndIncrement();
        });
        return request;
    }
    public List<PointEntity> correctOrder(List<Integer> order, List<PointEntity> pointEntities){
        AtomicInteger i = new AtomicInteger();
        List<PointEntity> side = new ArrayList<>();
        pointEntities.forEach(pointEntity -> {
            if(i.get()==0){
                side.add(pointEntity);
            }
            else if(i.get()>0 && i.get() < pointEntities.size()-2){
                side.add(pointEntities.get(order.get(i.get()-1)+1));
            }
            else if(i.get()==pointEntities.size()-1){
                side.add(pointEntity);
            }
            i.getAndIncrement();
        });

        return side;

    }
}
