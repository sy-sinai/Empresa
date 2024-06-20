package com.evalueytor.empresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.evalueytor.empresa.repositories.FormularioEvaluacionRepository;

@RestController
@RequestMapping("/api/evaluacion/formularioevaluacion")
public class FormularioEvaluacionController {
    @Autowired
    FormularioEvaluacionRepository formularioEvaluacionRepository;

    @GetMapping("/findall")
    public List<FormularioEvaluacionController> listarFormularioEvaluacion() {
        return formularioEvaluacionRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<FormularioEvaluacionController> obtenerFormularioEvaluacionPorId(@PathVariable Long id) {
        Optional<FormularioEvaluacionController> formularioEvaluacionOptional = formularioEvaluacionRepository.findById(id);
        return formularioEvaluacionOptional.map(formularioEvaluacion -> new ResponseEntity<>(formularioEvaluacion, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<FormularioEvaluacionController> crearFormularioEvaluacion(@RequestBody FormularioEvaluacionController nuevoFormularioEvaluacion) {
        FormularioEvaluacionController formularioEvaluacionGuardado = formularioEvaluacionRepository.save(nuevoFormularioEvaluacion);
        return new ResponseEntity<>(formularioEvaluacionGuardado, HttpStatus.CREATED);
    }
}
