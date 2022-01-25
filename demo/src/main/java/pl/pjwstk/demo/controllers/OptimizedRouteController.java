package pl.pjwstk.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import pl.pjwstk.demo.model.Entity.PointEntity;
import pl.pjwstk.demo.model.GoogleEntity.Root;
import pl.pjwstk.demo.service.FastesRouteService;
import pl.pjwstk.demo.service.PointsService;

import java.util.List;

@Controller
@RequestMapping(path = "/route")
public class OptimizedRouteController {

    RestTemplate rest;
    PointsService pointsService;
    FastesRouteService fastesRouteService;
    String apiKey;

    @Autowired
    public OptimizedRouteController(RestTemplate rest,FastesRouteService fastesRouteService,PointsService pointsService){
        this.rest = rest;
        this.pointsService =pointsService;
        this.fastesRouteService = fastesRouteService;
        this.apiKey = "";
    }
    @GetMapping(path = "/calculator")
    public String mainPage(Model model) {
       model.addAttribute(pointsService.getAllPoints());
        return "optimizedRutePage";
    }

    @GetMapping(path = "/calculator/calculate")
    public String findFastesRoute(Model model, @RequestParam(value = "id",required = false) String id) {
        if (id.isEmpty()){
            return "optimizedRutePage";
        }
        else {
            String request = fastesRouteService.makeRequest(pointsService.getByDriverFK(Integer.parseInt(id)));
            Root root = rest.getForEntity("https://maps.googleapis.com/maps/api/directions/json?key=" + apiKey + request, Root.class).getBody();
            System.out.println(root.routes.get(0).getWaypoint_order());
            List<PointEntity> pointEntities = fastesRouteService.correctOrder(root.routes.get(0).getWaypoint_order(), pointsService.getByDriverFK(Integer.parseInt(id)));
            model.addAttribute("optimized", pointEntities);
            return "optimizedRutePage";
        }

    }
}
