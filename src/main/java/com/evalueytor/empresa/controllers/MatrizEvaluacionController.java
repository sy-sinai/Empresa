package com.evalueytor.empresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.evalueytor.empresa.repositories.MatrizEvaluacionRepository;
import com.evalueytor.matrizevaluacion.models.MatrizEvaluacion;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/matrizevaluacion")
public class MatrizEvaluacionController {
    @Autowired
    MatrizEvaluacion matrizEvaluacionRepository;

    @GetMapping("/findall")
    public List<MatrizEvaluacion> listarMatrizEvaluacion() {
        return matrizEvaluacionRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<MatrizEvaluacion> obtenerMatrizEvaluacionPorId(@PathVariable Long id) {
        Optional<MatrizEvaluacion> matrizEvaluacionOptional = matrizEvaluacionRepository.findById(id);
        return matrizEvaluacionOptional.map(matrizEvaluacion -> new ResponseEntity<>(matrizEvaluacion, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<MatrizEvaluacion> crearMatrizEvaluacion(@RequestBody MatrizEvaluacion nuevaMatrizEvaluacion) {
        MatrizEvaluacion matrizEvaluacionGuardada = matrizEvaluacionRepository.save(nuevaMatrizEvaluacion);
        return new ResponseEntity<>(matrizEvaluacionGuardada, HttpStatus.CREATED);
    }
}
