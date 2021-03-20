package com.example.demo.servlet;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.PersonRepository;

@Controller
public class controller {
	@GetMapping("/")
public String home(Model m) {
		m.addAttribute("title", "EXEMPLE PAGING FROM SPRING-BOOT");
		m.addAttribute("sinc", LocalTime.now());
		return "home";
}
}
