package com.generation.services;

import com.generation.models.Licencia;
import com.generation.repositories.LicenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class LicenciaService {

    @Autowired
    LicenciaRepository licenciaRepository;

    public void save(@Valid Licencia licencia) {
        //almacenando los datos de la licencia
        licenciaRepository.save(licencia);
    }

    public List<Licencia> findAll() {
        //regresando la lista de licencias
        return licenciaRepository.findAll();
    }
}
