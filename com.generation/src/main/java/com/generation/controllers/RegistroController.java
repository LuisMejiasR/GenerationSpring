package com.generation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class RegistroController {

    //crear una ruta para desplegar el jsp
    @RequestMapping("/registro")
    public String registro(){
        return "registro.jsp";
    }
}
