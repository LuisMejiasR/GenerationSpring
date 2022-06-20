package com.generation.controllers;

import com.generation.models.Auto;
import com.generation.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    //una URL "SOLO PARA MOSTRAR" el jsp de la lista de autos
    @RequestMapping("/mostrar")
    public String mostrar(Model model){
        //crear la lista de objetos para poderla mostrar en el jsp
        List<Auto> listaAutos = autoService.findAll();
        //con MODEL es que pasamos cosas al JSP
        model.addAttribute("autosCapturados",listaAutos);
        return "ejemploAutos.jsp";
    }

    @RequestMapping("/editar/{id}")//editar para el DESPLIEGUE DE INFORMACIÓN
    public String editar(@PathVariable("id") Long id,
                         Model model){
        System.out.println("el id es: "+id);
        Auto autoRetornado = autoService.buscarId(id);//capturar el objeto completo
        model.addAttribute("auto", autoRetornado);//pasar al jsp


        return "editarAuto.jsp";//redireccionar a otra url o jsp
    }

    //localhost:8080/auto/actualizar/{id} --> para la PERSISTENCIA EN LA BD
    @PostMapping("/actualizar/{id}")
    public String actualizarAuto(@PathVariable("id") Long id,
                                 @Valid @ModelAttribute("auto") Auto auto,
                              BindingResult result,
                              Model model){
        if(result.hasErrors()){
            model.addAttribute("msgError","Ingreso incorrecto de datos");
            return "editarAuto.jsp";
        }else {
            auto.setId(id);// agregar el id al objeto (AGREGADO LUEGO)
            /* "SPRING DICE QUE SI VIENE UNA ID ES UNA ACTUALIZACION, SI NO VIENE ES UNA CREACIÓN"*/

            //capturamos el objeto con los atributos completos
            System.out.println(auto.getModelo() + " " + auto.getMarca() + " " + auto.getColor() + " " + auto.getVelocidad());

            //y lo pasamos a service para que lo guarde
            autoService.saveAuto(auto);

            //redirecciona a "mostrar" porque ya lo tenía escrito
            return "redirect:/auto/mostrar";
        }
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminarAuto(@PathVariable("id") Long id){

        autoService.eliminarPorId(id);

        //redirecciona a "mostrar" porque ya lo tenía escrito
        return "redirect:/registroauto/mostrar";
    }


}
