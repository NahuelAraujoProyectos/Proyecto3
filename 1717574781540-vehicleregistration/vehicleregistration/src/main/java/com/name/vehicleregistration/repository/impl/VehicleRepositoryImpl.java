package com.name.vehicleregistration.repository.impl;

import com.name.vehicleregistration.model.Vehicle;
import com.name.vehicleregistration.repository.VehicleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
    public void anadirV(Vehicle vehicleRequest) {
        listaVehiculos.add(vehicleRequest);
    }

    //Obtener Vehiculo
    @Override
    public Vehicle obtenerId(Integer id) {
        Vehicle vehicle;
        vehicle = listaVehiculos.stream().filter(vehicle1 -> vehicle1.getId().equals(id)).findFirst().get();
        return vehicle;
    }

    //Actualizar Vehiculo
    @Override
    public void actualizarV(Integer id, Vehicle vehicle) {
        eliminarV(id);
        anadirV(vehicle);
    }

    //Eliminar Vehiculo
    @Override
    public void eliminarV(Integer id) {
        Vehicle vehicle;
        vehicle = obtenerId(id);
        listaVehiculos.remove(vehicle);
    }
}
