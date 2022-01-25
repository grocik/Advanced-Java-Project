package pl.pjwstk.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/map")
public class MapController {

    @GetMapping(path = "/google")
    public String displayOnMap(Model model){

        return "mapPage";
    }
}
