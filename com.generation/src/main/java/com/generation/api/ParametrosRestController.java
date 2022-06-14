package com.generation.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") //Establece el inicio de ruta por defecto
public class ParametrosRestController {

    //localhost:8080/api?fecha=20220613
    @RequestMapping("/")
    public String fecha(@RequestParam(value="fecha") String fecha){ //Capturamos la variable fecha
        //Luego utilizamos fecha
        //@RequestParam( Valor = variable) TipoDeDato Variable)

        return "La fecha es: "+ fecha;
    }

    //localhost:8080/api?modulo=3&seccion=5
    //PEDIR PARAMETROS DE FORMA OBLIGATORIA
    @RequestMapping("/seccion")
    public String seccion(@RequestParam(value="modulo") String modulo, @RequestParam (value="seccion") String seccion){
        return "el modulo es: " + modulo + " la seccion es: " + seccion;
    }

    //PEDIR PARAMETROS DE FORMA NO OBLIGATORIA
    //localhost:8080/api/date?anio=2022&mes=6&dia=13
    @RequestMapping("/date")
    public String capturarParametros(@RequestParam(value="anio", required=false) String anio,
                                     @RequestParam(value="mes", required=false) String mes,
                                     @RequestParam(value="dia", required=false) String dia){
        //FALTAN LOS SOUT PARA VER EN LA CONSOLA

        return "la fecha es " + anio + mes + dia;
    }

}
