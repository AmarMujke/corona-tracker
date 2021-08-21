package com.example.coronatracker.controllers;

import com.example.coronatracker.Models.LocationStats;
import com.example.coronatracker.Services.CoronaServiceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class homeController {
    @Autowired
     CoronaServiceData coronaData;
    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> allStats = coronaData.getAllStats();
        int totalCases = allStats.stream().mapToInt(stat -> stat.getLatestCases()).sum();
        model.addAttribute("locationStats",allStats);
        model.addAttribute("totalCases",totalCases);

        return "home";

    }
}
