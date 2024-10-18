package com.name.vehicleregistration.repository;

import com.name.vehicleregistration.model.Vehicle;

import java.util.List;

public interface VehicleRepository {
    //Obtener lista de vehiculos
    public List<Vehicle> obtenerVehiculos();
    //Guardar Vehiculo
    public void anadirVehiculo (Vehicle vehicle);
    //Obtener vehiculo por id
    public Vehicle obtenerVehiculoPorId(Integer id);
    // Actualizar vehiculo
    public void actualizarVehiculo(Integer id, Vehicle vehicle);
    // Eliminar vehiculo
    public void eliminarVehiculo(Integer id);
}
