package com.name.vehicleregistration.controller;

import com.name.vehicleregistration.model.dtos.VehicleDto;
import com.name.vehicleregistration.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/vehicles")
    @Operation(summary = "Añadir un nuevo vehículo", description = "Este endpoint permite añadir un vehículo nuevo.")
    public ResponseEntity<String> anadirVehiculo(@RequestBody VehicleDto vehicleDto) {
        try {
            vehicleService.anadirVehiculo(vehicleDto);
            return ResponseEntity.ok("Vehículo añadido.");
        } catch (Exception e) {
            log.error("POST - Error añadiendo vehículo: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().body("Error añadiendo vehículo.");
        }
    }

    @GetMapping("/vehicles/{id}")
    @Operation(summary = "Obtener un vehículo por ID", description = "Este endpoint permite obtener un vehículo existente usando su ID.")
    public ResponseEntity<?> obtenerVehiculo(@PathVariable Integer id) {
        try {
            VehicleDto vehicleDto = vehicleService.obtenerVehiculo(id);
            return ResponseEntity.ok(vehicleDto);
        } catch (Exception e) {
            log.error("GET - Error obteniendo vehículo con id {}: {}", id, e.getMessage(), e);
            return ResponseEntity.internalServerError().body("Error obteniendo vehículo.");
        }
    }

    @PutMapping("/vehicles/{id}")
    @Operation(summary = "Actualizar un vehículo", description = "Este endpoint permite actualizar la información de un vehículo existente.")
    public ResponseEntity<String> actualizarVehiculo(@PathVariable Integer id, @RequestBody VehicleDto vehicleDto) {
        try {
            vehicleService.actualizarVehiculo(id, vehicleDto);
            return ResponseEntity.ok("Vehículo actualizado.");
        } catch (Exception e) {
            log.error("UPDATE - Error actualizando vehículo con id {}: {}", id, e.getMessage(), e);
            return ResponseEntity.internalServerError().body("Error actualizando vehículo.");
        }
    }

    @DeleteMapping("/vehicles/{id}")
    @Operation(summary = "Eliminar un vehículo", description = "Este endpoint permite eliminar un vehículo existente usando su ID.")
    public ResponseEntity<String> eliminarVehiculo(@PathVariable Integer id) {
        try {
            vehicleService.eliminarVehiculo(id);
            return ResponseEntity.ok("Vehículo eliminado.");
        } catch (Exception e) {
            log.error("DELETE - Error eliminando vehículo con id {}: {}", id, e.getMessage(), e);
            return ResponseEntity.internalServerError().body("Error eliminando vehículo.");
        }
    }

}