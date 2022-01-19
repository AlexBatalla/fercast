package com.daw2.fercast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/novedades")
public class NovedadesController {
    @GetMapping
    public String home(){return "public/novedades";}
}
