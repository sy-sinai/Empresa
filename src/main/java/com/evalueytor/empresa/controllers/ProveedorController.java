package com.evalueytor.empresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.evalueytor.empresa.repositories.ProveedorRepository;
import com.evalueytor.empresa.models.Proveedor;

@RestController
@RequestMapping("/api/empresa/proveedor")
public class ProveedorController {
    @Autowired
    ProveedorRepository proveedorRepository;

    @GetMapping("/findall")
    public List<Proveedor> listarProveedor() {
        return proveedorRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Proveedor> obtenerProveedorsaPorId(@PathVariable Long id) {
        Optional<Proveedor> proveedorOptional = proveedorRepository.findById(id);
        return proveedorOptional.map(proveedor -> new ResponseEntity<>(proveedor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Proveedor> crearProveedor(@RequestBody Proveedor nuevoProveedor) {
        Proveedor proveedorGuardado = proveedorRepository.save(nuevoProveedor);
        return new ResponseEntity<>(proveedorGuardado, HttpStatus.CREATED);
    }
}
