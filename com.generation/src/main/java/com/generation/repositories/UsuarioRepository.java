package com.generation.repositories;

import com.generation.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { //JpaRepository<Objeto, Tipo_dato_PK>
    /* LAS INTERFACES SOLO DEFINEN LOS METODOS (no implementa) */
    /* Se ejecutan Querys y usar metodos que se conectan a la base de datos */


}
