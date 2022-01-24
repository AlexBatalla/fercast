package com.daw2.fercast.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/usuarios")
public class UsuariosAdminController {
    @GetMapping
    public String home(){return "admin/usuarios";}
}