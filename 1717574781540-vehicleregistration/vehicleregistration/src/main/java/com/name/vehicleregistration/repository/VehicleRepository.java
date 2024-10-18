package com.name.vehicleregistration.repository;

import com.name.vehicleregistration.model.Vehicle;

import java.util.List;

public interface VehicleRepository {
    //Obtener lista de vehiculos
    public List<Vehicle> obtenerVehiculo();
    //Guardar Vehiculo
    public void anadirV (Vehicle vehicle);
    //Obtener vehiculo por id
    public Vehicle obtenerId(Integer id);
    // Actualizar vehiculo
    public void actualizarV(Integer id, Vehicle vehicle);
    // Eliminar vehiculo
    public void eliminarV(Integer id);
}
