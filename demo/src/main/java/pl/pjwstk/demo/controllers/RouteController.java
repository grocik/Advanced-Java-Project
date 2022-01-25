package pl.pjwstk.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pjwstk.demo.repository.PointRepository;



@Controller
@RequestMapping(path = "/route")
public class RouteController {


    PointRepository pointRepository;

    @Autowired
    public RouteController(PointRepository pointRepository){
        this.pointRepository = pointRepository;
    }

    @GetMapping(path = "/main")
    public String getRoutes(Model model) {
        model.addAttribute("route",pointRepository.findAll());
        return "mainPage";
    }

    @GetMapping(path = "/main/id")
    public String getRoutes(Model model, @RequestParam(value = "fkid",required = false) String fkId) {
        if (fkId.isEmpty()){
            model.addAttribute("route",pointRepository.findAll());
            return "mainPage";
        }
        else {
            model.addAttribute("route",pointRepository.findByDriverFk(Integer.parseInt(fkId)));
            return "mainPage";
        }
    }


}
