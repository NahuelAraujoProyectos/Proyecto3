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
    public List<Vehicle> obtenerVehiculos() {
        return listaVehiculos;
    }

    //Añadir Vehiculo
    @Override
    public void anadirVehiculo(Vehicle vehicle) {
        listaVehiculos.add(vehicle);
    }

    //Obtener Vehiculo
    @Override
    public Vehicle obtenerVehiculoPorId(Integer id) {
        // Usamos Optional para manejar el caso en que el vehículo no existe
        Optional<Vehicle> vehicle = listaVehiculos.stream()
                .filter(vehicle1 -> vehicle1.getId().equals(id))
                .findFirst();
        return vehicle.orElse(null); // Devuelve null si no se encuentra
    }

    //Actualizar Vehiculo
    @Override
    public void actualizarVehiculo(Integer id, Vehicle vehicle) {
        Vehicle existingVehicle = obtenerVehiculoPorId(id);
        if (existingVehicle != null) {
            // Aquí actualizamos cada una de las propiedades del vehículo existente
            existingVehicle.setBrand(vehicle.getBrand());
            existingVehicle.setModel(vehicle.getModel());
            existingVehicle.setMillage(vehicle.getMillage());
            existingVehicle.setPrice(vehicle.getPrice());
            existingVehicle.setYear(vehicle.getYear());
            existingVehicle.setDescription(vehicle.getDescription());
            existingVehicle.setColour(vehicle.getColour());
            existingVehicle.setFuelType(vehicle.getFuelType());
            existingVehicle.setNumDoors(vehicle.getNumDoors());
        } else {
            throw new IllegalArgumentException("Vehículo con ID " + id + " no encontrado para actualizar.");
        }
    }

    //Eliminar Vehiculo
    @Override
    public void eliminarVehiculo(Integer id) {
        Vehicle vehicle = obtenerVehiculoPorId(id);
        if (vehicle != null) {
            listaVehiculos.remove(vehicle);
        } else {
            throw new IllegalArgumentException("Vehículo con ID " + id + " no encontrado para eliminar.");
        }
    }
}
