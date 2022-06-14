package com.generation.controllers;

//import org.springframework.stereotype.Controller;
import com.generation.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// esto es lo que instancia que es un controlador:
@Controller
public class IndexController {

    //lo de abajo es parecido a decir: http://localhost:8080/
    @RequestMapping("/")//anotacion para capturar las rutas
    public String index(Model model){
        model.addAttribute("apellidos","Mejias Rojas");
        model.addAttribute("nombres","Luis Alfredo");
        model.addAttribute("edad",28);

        //instanciamos el objeto usuario:
        Usuario usuario = new Usuario("Teresa","Bettoni",27);
        //pasamos el objeto a la vista:
        model.addAttribute("usuario", usuario);

        return "index.jsp";
    }


}
