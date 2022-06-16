package com.generation.services;

import com.generation.models.Usuario;
import com.generation.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* APLICAMOS LA LÓGICA DE NEGOCIO o validaciones del sistema */


@Service
public class UsuarioService {
    /* llamar al Repository (inyección de dependencia)*/
    @Autowired
    UsuarioRepository usuarioRepository;

    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }


}
