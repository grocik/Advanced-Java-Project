package pl.pjwstk.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.pjwstk.demo.service.DriversService;


@Controller
@RequestMapping(path = "/drivers")
public class DriversController {

    DriversService driversService;

    @Autowired
    public DriversController(DriversService driverservice){
        this.driversService = driverservice;
    }

    @GetMapping(path = "/main")
    public String getDrivers(Model model) {
        model.addAttribute("drivers",driversService.getAllDrivers());
        return "driverPage";
    }
    @GetMapping(path = "/main/name")
    public String getDriversByname(Model model, @RequestParam(value = "name",required = false) String name) {
        if (name.isEmpty()){
            model.addAttribute("drivers",driversService.getAllDrivers());
            return "driverPage";
        }
        else {
            model.addAttribute("drivers", driversService.getDriversByName(name));
            return "driverPage";
        }
    }
    @GetMapping(path = "/main/surename")
    public String getDriversBySurename(Model model, @RequestParam(value = "surename",required = false) String surename) {
        if (surename.isEmpty()){
            model.addAttribute("drivers",driversService.getAllDrivers());
            return "driverPage";
        }
        else {
            model.addAttribute("drivers", driversService.getDriversBySurename(surename));
            return "driverPage";
        }
    }
    @GetMapping(path = "/main/id")
    public String getDriversById(Model model, @RequestParam(value = "id",required = false) String id) {
        if (id.isEmpty()){
            model.addAttribute("drivers",driversService.getAllDrivers());
            return "driverPage";
        }
        else {
            model.addAttribute("drivers", driversService.getDriversById(Integer.parseInt(id)));
            return "driverPage";
        }

    }

}
