package com.evalueytor.empresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.evalueytor.matrizevaluacion.models.MatrizEvaluacion;

public interface MatrizEvaluacionRepository extends JpaRepository<MatrizEvaluacion, Long> {
}
