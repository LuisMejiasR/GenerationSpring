package com.generation.repositories;

import com.generation.models.Auto;
import com.generation.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long> {
    //JPQL
    //Usamos objeto para hacer la Query (se puede usar LAZY)
    @Query("SELECT a FROM Auto a WHERE a.marca = ?1")
    List<Auto> findAllAutoMarca(String marca);

    //Query comun (se puede usar LAZY)
    @Query(value = "SELECT * FROM autos a WHERE a.marca = ?1", nativeQuery = true)
    List<Auto> buscarMarca(String marca);

    //FILTRO POR ALGUNAS COLUMNAS DE LA TABLA, nos regresa un objeto generico (no entidad) y nos regresa un dato especifico
    @Query(value="SELECT a.marca, a.color FROM autos a WHERE a.marca = ?1 and a.color=?2",nativeQuery = true)
    List<Object[]> buscarMarcaColor(String marca, String color);

    //JOIN
    //@Query("SELECT a FROM Auto a JOIN a.comprasVentas cv WHERE ")


}
