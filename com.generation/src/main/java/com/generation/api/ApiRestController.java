package com.generation.api;

import com.generation.models.Auto;
import com.generation.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//LA DIFERENCIA ES QUE TENEMOS QUE ESPECIFICAR EL TIPO DE DATO QUE QUEREMOS RETORNAR
@RestController
@RequestMapping("/api")
public class ApiRestController {
    //INYECCION DE DEPENDENCIA: llamando una clase para ser usada internamente (METODOS)
    @Autowired
    AutoService autoService;


    @RequestMapping("/obtener/auto")
    public List<Auto> obtenerListaAutos(){
        List<Auto> listaAutos = autoService.findAll();
        return listaAutos;
    }

    //API = (JSON)
}
