package org.ma.springpagination.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalTime;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getHome(Model model){
        model.addAttribute("title", "EXEMPLE PAGING FROM SPRING-BOOT");
		model.addAttribute("sinc", LocalTime.now());
        return "home";
    }
}
