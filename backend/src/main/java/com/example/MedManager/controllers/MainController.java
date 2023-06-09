package com.example.MedManager.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/") // главная страница
    public String index(Model model) {
        model.addAttribute("title", "Главная страница");
        return "index";
    }
}
