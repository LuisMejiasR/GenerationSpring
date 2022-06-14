package com.generation.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrutamientoRestController {

    /* COMO CREAR RUTAS */
    //http://localhost:8080/usuario
    @RequestMapping("/usuario")
    public String usuario(){
        return "Estamos en la url usuario";
    }

    @RequestMapping("/usuario/inscrito")
    public String inscrito(){
        return "Estamos en la url usuario/inscrito";
    }

    @RequestMapping("/cliente/registrado")
    public String cliente(){
        return "Ruta de cliente";
    }
    //forma más compleja de escribirlo:
    @RequestMapping(value="/proveedor/registrado", method = RequestMethod.GET)
    public String proveedor(){
        return "Ruta de proveedor";
    }
}
