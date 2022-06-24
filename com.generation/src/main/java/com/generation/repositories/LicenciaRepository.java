package com.generation.repositories;

import com.generation.models.Auto;
import com.generation.models.Licencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenciaRepository extends JpaRepository<Licencia, Long> {
}
