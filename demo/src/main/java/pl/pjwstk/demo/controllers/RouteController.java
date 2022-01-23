package pl.pjwstk.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.pjwstk.demo.model.Root;
import pl.pjwstk.demo.repository.PointRepository;
import pl.pjwstk.demo.service.FastesRouteService;
import pl.pjwstk.demo.service.PointsService;


@Controller
public class RouteController {

    RestTemplate rest;
    PointsService pointsService;
    FastesRouteService fastesRouteService;
    PointRepository pointRepository;
    String apiKey;

    @Autowired
    public RouteController(RestTemplate rest,FastesRouteService fastesRouteService,PointsService pointsService,PointRepository pointRepository){
        this.rest = rest;
        this.pointsService =pointsService;
        this.fastesRouteService = fastesRouteService;
        this.pointRepository = pointRepository;
        this.apiKey = "";
    }

    @GetMapping(path = "/main")
    public String getRoutes(Model model) {
        model.addAttribute("route",pointRepository.findAll());
        return "mainPage";
    }

    @GetMapping(path = "/main/{id}")
    public String getRoutes(Model model, @RequestParam int id) {
        model.addAttribute("route",pointRepository.findByDriverFk(id));
        return "mainPage";
    }

    @GetMapping(path = "/route/calculate")
    public String findFastesRoute(Model model,@RequestParam(value = "id",required = false) int id) {
       Root root = rest.getForEntity("https://maps.googleapis.com/maps/api/directions/json?key="+apiKey+fastesRouteService
               .makeRequest(pointsService.get(id)), Root.class).getBody();
        System.out.println(root.routes.get(0).getWaypoint_order());
        model.addAttribute("optimized",fastesRouteService.correctOrder(root.routes.get(0).getWaypoint_order(),pointsService.get(id)));
        return "optimizedRutePage";
        }
    @GetMapping(path = "/map")
    public String displayOnMap(Model model){

        return "mapPage";
    }
    @GetMapping(path = "/route")
    public String routePage(Model model) {;
        return "routePage";
    }

}
