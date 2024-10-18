package com.name.vehicleregistration.model.dtos;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {
    private Integer id;
    private String brand;
    private String model;
    private Integer millage;
    private double price;
    private Integer year;
    private String description;
    private String colour;
    private String fuelType;
    private Integer NumDoors;

}
