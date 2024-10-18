package com.name.vehicleregistration.controller;

import com.name.vehicleregistration.model.dtos.VehicleDto;
import com.name.vehicleregistration.service.VehicleService;
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
    public ResponseEntity<?> anadirVehiculo(@RequestBody VehicleDto vehicleDto){
        try {
            vehicleService.anadirVehiculo(vehicleDto);
            return ResponseEntity.ok("Vehiculo añadido.");
        } catch (Exception e){
            log.error("POST - {}",eInesperado);
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<?> obtenerVehiculo(@PathVariable Integer id){
        try{
            VehicleDto vehicleDto = vehicleService.obtenerVehiculo(id);
            return ResponseEntity.ok(vehicleDto);
        } catch (Exception e){
            log.error("GET - {}",eInesperado);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/vehicles/{id}")
    public ResponseEntity<?> actualizarVehiculo(@PathVariable Integer id, @RequestBody VehicleDto vehicleDto){
        try {
            vehicleService.actualizarVehiculo(id, vehicleDto);
            return ResponseEntity.ok("Vehiculo actualizado");
        } catch (Exception e){
            log.error("UPDATE - {}",eInesperado);
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> eliminarVehiculo(@PathVariable Integer id){
        try {
            vehicleService.eliminarVehiculo(id);
            return ResponseEntity.ok("Vehiculo eliminado");
        } catch (Exception e){
            log.error("DELETE - {}",eInesperado);
            return ResponseEntity.internalServerError().build();
        }
    }

    private String eInesperado = "El id no es correcto";

}