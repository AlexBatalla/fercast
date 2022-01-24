package com.daw2.fercast.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/facturas")
public class FacturasAdminController {
    @GetMapping
    public String home(){return "admin/facturas";}
}
