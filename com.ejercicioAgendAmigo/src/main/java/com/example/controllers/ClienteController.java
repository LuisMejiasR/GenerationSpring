package com.example.controllers;

import com.example.models.Cliente;
import com.example.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    //inyección de clases
    @Autowired
    ClienteService clienteService;

    //primera url para deplegar el index
    @RequestMapping("")
    public String cliente(@ModelAttribute("cliente") Cliente cliente){
        return "index.jsp";
    }
}
