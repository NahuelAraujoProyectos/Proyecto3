package com.name.vehicleregistration.service;

import com.name.vehicleregistration.model.dtos.VehicleDto;

public interface VehicleService {
    public void anadirVehiculo(VehicleDto vehicleDto);
    public VehicleDto obtenerVehiculo(Integer id);
    public void actualizarVehiculo(Integer id, VehicleDto vehicleDto);
    public void eliminarVehiculo(Integer id);
}
