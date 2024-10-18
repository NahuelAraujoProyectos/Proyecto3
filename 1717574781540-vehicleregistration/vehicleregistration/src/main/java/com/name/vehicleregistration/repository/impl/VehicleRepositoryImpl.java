package com.name.vehicleregistration.repository.impl;

import com.name.vehicleregistration.model.Vehicle;
import com.name.vehicleregistration.repository.VehicleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {
    private List<Vehicle> listaVehiculos = new ArrayList<>();

    //Obtener Lista Vehiculos
    @Override
    public List<Vehicle> obtenerVehiculo() {
        return listaVehiculos;
    }

    //Añadir Vehiculo
    @Override
    public void anadirV(Vehicle vehicle) {
        listaVehiculos.add(vehicle);
    }

    //Obtener Vehiculo
    @Override
    public Vehicle obtenerId(Integer id) {
        // Usamos Optional para manejar el caso en que el vehículo no existe
        Optional<Vehicle> vehicle = listaVehiculos.stream()
                .filter(vehicle1 -> vehicle1.getId().equals(id))
                .findFirst();
        return vehicle.orElse(null); // Devuelve null si no se encuentra
    }

    //Actualizar Vehiculo
    @Override
    public void actualizarV(Integer id, Vehicle vehicle) {
        Vehicle existingVehicle = obtenerId(id);
        if (existingVehicle != null) {
            eliminarV(id); // Solo eliminamos si el vehículo existe
            anadirV(vehicle); // Añadimos el vehículo actualizado
        } else {
            throw new IllegalArgumentException("Vehículo con ID " + id + " no encontrado para actualizar.");
        }
    }

    //Eliminar Vehiculo
    @Override
    public void eliminarV(Integer id) {
        Vehicle vehicle = obtenerId(id);
        if (vehicle != null) {
            listaVehiculos.remove(vehicle);
        } else {
            throw new IllegalArgumentException("Vehículo con ID " + id + " no encontrado para eliminar.");
        }
    }
}
