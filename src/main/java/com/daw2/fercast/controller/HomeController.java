package com.daw2.fercast.controller;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class HomeController {

   @Autowired
   private MessageSource messageSource;
    @GetMapping
    public String home(Model model, Locale locale){
       // model.addAttribute("test",messageSource.getMessage("text.prueba",null,locale));


        return "index";
    }

    @GetMapping("locale")//Entra como locala
    public String locale(HttpServletRequest request){
        String urlOrigen = request.getHeader("referer");//Devuelve a la pagina anterior
        if (urlOrigen == null)
            urlOrigen = "/";
        return "redirect:"+urlOrigen;
    }


}
