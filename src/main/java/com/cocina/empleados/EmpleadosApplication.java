package com.cocina.empleados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "empleadosmodel")  // Ajusta el paquete según la ubicación exacta de tu entidad
public class EmpleadosApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpleadosApplication.class, args);
		System.out.println("ok");
    }
}

