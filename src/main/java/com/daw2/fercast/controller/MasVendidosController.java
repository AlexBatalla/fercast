package com.daw2.fercast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mas-vendidos")
public class MasVendidosController {
    @GetMapping
    public String home(){return "public/mas_vendidos";}
}
