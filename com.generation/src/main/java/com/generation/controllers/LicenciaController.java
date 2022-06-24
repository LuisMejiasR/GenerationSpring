package com.generation.controllers;

import com.generation.models.Auto;
import com.generation.models.Licencia;
import com.generation.models.Usuario;
import com.generation.services.LicenciaService;
import com.generation.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/licencia")
public class LicenciaController {
    @Autowired
    LicenciaService licenciaService;

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping("")
    public String despliegue(Model model){
        Licencia licencia = new Licencia();
        model.addAttribute("licencia", licencia);
        //creamos una List de tipo Usuario, y la rellenamos con usuarioService.findAll();
        List<Usuario> listaUsuarios = usuarioService.findAll();
        model.addAttribute("listaUsuarios",listaUsuarios);

        //enviamos la lista al jsp
        List<Licencia> listaLicencias = licenciaService.findAll();
        model.addAttribute("listaLicencias", listaLicencias);

        Date fechaActual= new Date();

        return "licencia.jsp";
    }

    @PostMapping("/guardar")
    public String guardarLicencia(@Valid @ModelAttribute("licencia") Licencia licencia){
        licenciaService.save(licencia);

        return "redirect:/licencia";
    }




}
