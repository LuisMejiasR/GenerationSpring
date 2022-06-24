package com.generation.services;

import com.generation.models.Usuario;
import com.generation.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* APLICAMOS LA LÓGICA DE NEGOCIO o validaciones del sistema */


@Service
public class UsuarioService {
    /* llamar al Repository (inyección de dependencia)*/
    @Autowired
    UsuarioRepository usuarioRepository;

    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }


    //Yendo a la BD para buscar todos los usuarios
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
}
