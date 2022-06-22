package com.generation.services;

import com.generation.models.Auto;
import com.generation.repositories.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoService {
    @Autowired
    AutoRepository autoRepository;

    //guardar un auto
    public void saveAuto(Auto auto) {
        autoRepository.save(auto);
    }

    /*obtener la lista de autos*/
    public List<Auto> findAll() {

        return autoRepository.findAll();
    }

    public Auto buscarId(Long id) {
        return autoRepository.findById(id).get();//.get() especifica el tipo de datos que necesitamos
    }


    public void eliminarPorId(Long id) {
        autoRepository.deleteById(id);
    }
}
