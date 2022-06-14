package com.generation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/registro") //con este nos aseguramos que entren
public class RegistroController {

    //crear una ruta para desplegar el jsp, ruta por default
    @RequestMapping("")
    public String registro(){ //localhost:8080/registro
        return "registro.jsp"; //la pagina a desplegar
    }

    //ruta para capturar los datos del ususario
    @PostMapping("/usuario")
    public String registroUsuario(@RequestParam(value = "gato") String nombre,
                                  @RequestParam(value = "apellido") String apellido,
                                  @RequestParam(value = "edad") String edad){
        System.out.println("Parametro gato " + nombre);
        System.out.println("Parametro gato " + apellido);
        System.out.println("Parametro gato " + edad);
        return "registro.jsp";// la pagina a desplegar
    }
}
