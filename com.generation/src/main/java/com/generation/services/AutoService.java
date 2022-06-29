package com.generation.services;

import com.generation.models.Auto;
import com.generation.repositories.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
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

    public List<Auto> buscarMarca(String marca) {
        //lamado a un metodo propio
        //return autoRepository.buscarMarca(marca); //Query tradicional
        return autoRepository.findAllAutoMarca(marca); //Query por objeto (JPQL)
    }

    //PAGINACION
    //variable estatica, cantidad de datos a mostrar por pagina
    private static final int LOTE = 5;

    public Page<Auto> paginarAutos(int numeroPagina){
        PageRequest pageRequest = PageRequest.of(numeroPagina, LOTE,Sort.Direction.ASC,"id");
        Page<Auto> autos = autoRepository.findAll(pageRequest);
        return autoRepository.findAll(pageRequest);
    }



}
