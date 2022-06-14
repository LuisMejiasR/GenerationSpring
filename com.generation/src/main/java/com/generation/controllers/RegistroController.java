package com.generation.controllers;

import com.generation.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("/registro") //con este nos aseguramos que entren
public class RegistroController {

    //crear una ruta para desplegar el jsp, ruta por default
    @RequestMapping("")
    public String registro(@ModelAttribute("usuario") Usuario usuario){ //PASAMOS EL OBJETO CON LOS ATRIBUTOS VACIOS
        return "registro.jsp"; //la pagina a desplegar
    }

    //ruta para capturar los datos del ususario
    @PostMapping("/usuario/respaldo")
    public String registroUsuario(@RequestParam(value = "gato") String nombre,
                                  @RequestParam(value = "apellido") String apellido,
                                  @RequestParam(value = "edad") String edad){
        System.out.println("Parametro gato " + nombre);
        System.out.println("Parametro gato " + apellido);
        System.out.println("Parametro gato " + edad);
        return "registro.jsp";// la pagina a desplegar
    }
    @PostMapping("/usuario")
    public String guardarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, //CAPTURAMOS EL OBJETO CON LOS ATRIBUTOS LLENOS
                                 BindingResult resultado,
                                 Model model){
        if(resultado.hasErrors()){//capturando si existe un error en el ingreso de datos desde el jsp
            model.addAttribute("msgError", "Debe ingresar correctamente los datos");
            return "registro.jsp";
        }

        System.out.println(usuario.getNombre()+" "+usuario.getApellido()+ " "+ usuario.getEdad());
        return "index.jsp";
    }
}
