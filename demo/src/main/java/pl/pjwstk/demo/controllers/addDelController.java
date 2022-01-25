package pl.pjwstk.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.pjwstk.demo.service.DriversService;
import pl.pjwstk.demo.service.FastesRouteService;
import pl.pjwstk.demo.service.PointsService;

@Controller
@RequestMapping(path = "/operation")
public class addDelController {


    PointsService pointsService;
    FastesRouteService fastesRouteService;
    DriversService driversService;

    @Autowired
    public addDelController(PointsService pointsService, FastesRouteService fastesRouteService, DriversService driversService) {
        this.pointsService = pointsService;
        this.fastesRouteService = fastesRouteService;
        this.driversService = driversService;
    }

    @GetMapping(path = "/add/point")
    public String addPoint(Model model, @RequestParam(value = "city", required = false) String city,
                                @RequestParam(value = "street", required = false) String street,
                                @RequestParam(value = "stNumber", required = false) String stNumber,
                                @RequestParam(value = "fkId", required = false) String fkKey) {
        if (city==null || stNumber==null || street==null || fkKey==null) {
            return "pointAddPage";
        }
        else {
            pointsService.addPoint(pointsService.getAllPoints().size()+2,city,street,stNumber,Integer.parseInt(fkKey));
            return "mainPage";
        }
    }
    @GetMapping(path = "/remove/point")
    public String removePoint(Model model,@RequestParam(value = "id" ,required = false)String id){
        if (id==null){
            return "pointRemovePage";
        }
        else {
            pointsService.removePoint(Integer.parseInt(id));
            return "mainPage";
        }
    }


}

