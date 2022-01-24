package com.daw2.fercast.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/proveedores")
public class ProveedoresAdminController {
    @GetMapping
    public String home(){return "admin/proveedores";}
}
