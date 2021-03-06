package com.generation.repositories;

import com.generation.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

/* LAS INTERFACES SOLO DEFINEN LOS METODOS (YA ESTÁN LISTOS, solo los buscamos) */
/* Se ejecutan Querys y usar metodos que se conectan a la base de datos */

@Repository                               //JpaRepository<Objeto, Tipo_dato_PK>
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {



}
