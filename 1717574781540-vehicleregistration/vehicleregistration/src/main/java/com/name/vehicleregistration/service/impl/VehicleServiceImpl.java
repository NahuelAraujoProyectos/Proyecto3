package com.name.vehicleregistration.service.impl;

import com.name.vehicleregistration.model.Vehicle;
import com.name.vehicleregistration.model.dtos.VehicleDto;
import com.name.vehicleregistration.repository.VehicleRepository;
import com.name.vehicleregistration.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    //Añadir Vehiculo
    @Override
    public void anadirVehiculo(VehicleDto vehicleDto) {
        Vehicle vehicle;
        vehicle = mapperEntity(vehicleDto);
        vehicleRepository.anadirV(vehicle);
        log.info("Vehiculo añadido");
    }

    //Obtener Vehiculo
    @Override
    public VehicleDto obtenerVehiculo(Integer id) {
        Vehicle vehicle;
        vehicle = vehicleRepository.obtenerId(id);
        log.info("Vehiculo con id {} obtenido", id);
        return mapperDto(vehicle);
    }

    //Actualizar Vehiculo
    @Override
    public void actualizarVehiculo(Integer id, VehicleDto vehicleDto) {
        Vehicle vehicle = mapperEntity(vehicleDto);
        vehicleRepository.actualizarV(id,vehicle);
        log.info("Vehiculo con id {} actualizado", id);
    }

    //Eliminar Vehiculo
    @Override
    public void eliminarVehiculo(Integer id) {
        vehicleRepository.eliminarV(id);
        log.info("Vehiculo con id {} eliminado", id);
    }

    private Vehicle mapperEntity (VehicleDto vehicleDto){
        Vehicle vehicle;
        vehicle = Vehicle.builder()
                .id(vehicleDto.getId())
                .brand(vehicleDto.getBrand())
                .model(vehicleDto.getModel())
                .millage(vehicleDto.getMillage())
                .price(vehicleDto.getPrice())
                .year(vehicleDto.getYear())
                .description(vehicleDto.getDescription())
                .colour(vehicleDto.getColour())
                .fuelType(vehicleDto.getFuelType())
                .NumDoors(vehicleDto.getNumDoors())
                .build();
        return vehicle;
    }
    private VehicleDto mapperDto (Vehicle vehicle){
        VehicleDto vehicleDto;
        vehicleDto = VehicleDto.builder()
                .id(vehicle.getId())
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .millage(vehicle.getMillage())
                .price(vehicle.getPrice())
                .year(vehicle.getYear())
                .description(vehicle.getDescription())
                .colour(vehicle.getColour())
                .fuelType(vehicle.getFuelType())
                .NumDoors(vehicle.getNumDoors())
                .build();
        return vehicleDto;
    }
}
