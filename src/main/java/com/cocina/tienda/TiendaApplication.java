package com.cocina.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "tienda.model")  // Ajusta el paquete según la ubicación exacta de tus modelos
public class TiendaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiendaApplication.class, args);
        System.out.println("Aplicación de Tienda iniciada correctamente");
    }
}
