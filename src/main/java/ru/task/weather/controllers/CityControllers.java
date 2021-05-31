package ru.task.weather.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.task.weather.models.Temperature;
import ru.task.weather.repository.CityRepository;
import ru.task.weather.repository.TemperatureRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class CityControllers {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private TemperatureRepository temperatureRepository;

    @GetMapping("/city")
    public String test(Model model) {
        model.addAttribute("city", cityRepository.findAll());
        return "/city/index";
    }

    @GetMapping("/city/show")
    public String show(@RequestParam("task") Long id, Model model) {
        if (id != 0) {
            List<Temperature> list = temperatureRepository.receiveTemperatureIdCity(id);
            Collections.reverse(list);
            model.addAttribute("temp", list);
            return "/city/show";
        } else {
            model.addAttribute("temp", cityRepository.findAll());
            return "/city/allcity";
        }
    }

    @GetMapping("/city/temperature")
    public String shows(@RequestParam("id") Long id, Model model) {
        List<Temperature> list = temperatureRepository.receiveTemperatureIdCity(id);
        float temperature = 0;
        for (Temperature temp : list) {
            temperature = temperature + temp.getTemperature();
        }
        temperature = temperature / list.size();
        String s = String.format("%.2f", temperature);

        model.addAttribute("temp", s);
        return "city/shows";
    }
}
