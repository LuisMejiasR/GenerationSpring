package com.generation.controllers;

import com.generation.models.Auto;
import com.generation.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/registroauto")
public class AutoController {
    @Autowired
    AutoService autoService;

    //hacemos la primera, para desplegar el jsp y pasar el objeto con los atributos vacios
    @RequestMapping("")
    public String auto(@ModelAttribute("auto") Auto auto){
        return "auto.jsp";
    }

    //ruta para capturar datos auto
    @PostMapping("/auto")
    public String guardarAuto(@Valid @ModelAttribute("auto") Auto auto,
                              BindingResult result,
                              Model model){
        if(result.hasErrors()){
            model.addAttribute("msgError","Ingreso incorrecto de datos");
            return "auto.jsp";
        }else {
            //capturamos el objeto con los atributos completos
            System.out.println(auto.getModelo() + " " + auto.getMarca() + " " + auto.getColor() + " " + auto.getVelocidad());

            //y lo pasamos a service para que lo guarde
            autoService.saveAuto(auto);

            //crear la lista de objetos para poderla mostrar en el jsp
            List<Auto> listaAutos = autoService.findAll();
            //con MODEL es que pasamos cosas al JSP
            model.addAttribute("autosCapturados",listaAutos);
            return "ejemploAutos.jsp";
        }
    }


}
